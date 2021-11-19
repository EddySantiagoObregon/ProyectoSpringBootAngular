import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/modelo/Persona';
import { ServicioService } from 'src/app/Servicio/servicio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  personas:Persona[]
  constructor(private router:Router, private service:ServicioService) { }

  ngOnInit(): void {
    this.service.getPersonas().subscribe(data=>{this.personas=data;})
  }
  Editar(persona:Persona){
    localStorage.setItem("id",persona.id.toString());
    this.router.navigate(["editar"]);
  
  }
  Eliminar(persona:Persona){
    this.service.delePersona(persona)
    .subscribe(data=>{
    this.personas=this.personas.filter(p=>p!==persona)})
    alert("Eliminado correctamente");
  }
 
}
