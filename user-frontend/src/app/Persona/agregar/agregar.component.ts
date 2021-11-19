import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/modelo/Persona';
import { ServicioService } from 'src/app/Servicio/servicio.service';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent implements OnInit {

  constructor(private router:Router, private service:ServicioService) { }

  ngOnInit(): void {
  }
  persona: Persona = new Persona();
  Guardar(persona:Persona){
    this.service.createPersona(persona).subscribe(data=>{
      alert("Se agrego con exito");
      this.router.navigate(["listar"])
    })
    
  }
}
