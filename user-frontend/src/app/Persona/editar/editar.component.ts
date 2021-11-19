import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/modelo/Persona';
import { ServicioService } from 'src/app/Servicio/servicio.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {
  persona:Persona=new Persona()
  constructor(private router:Router, private service:ServicioService) { }

  ngOnInit() 
  {
    this.Editar()
  }
Editar(){
    let id=localStorage.getItem("id");
  this.service.getPersonaId(""+id)
  .subscribe(data=>{this.persona=data})

}
Actualizar(persona:Persona){

  this.service.updatePersona(persona)
  
  .subscribe(data=>{
   
    this.persona=data;
    this.router.navigate(["listar"]);
  })
}
}
