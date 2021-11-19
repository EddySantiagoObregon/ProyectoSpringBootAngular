import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../modelo/Persona';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8080/api/persona"

  getPersonas(){
    return this.http.get<Persona[]>(this.url)
  }
  createPersona(persona:Persona){
    return this.http.post<Persona>(this.url,persona);
  }
  getPersonaId(id:String){
    return this.http.get<Persona>(this.url+"/"+id);
  }
  updatePersona(persona:Persona){
    
    return this.http.put<Persona>(this.url+"/"+persona.id,persona);
  }
  delePersona(persona:Persona){
    return this.http.delete<Persona>(this.url+"/"+persona.id)
  }
}
