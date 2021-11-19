import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Gestion Persona';

  constructor(private router: Router) { }
    Listar(){
      this.router.navigate(["listar"]);
    }
    Agregar(){
      this.router.navigate(["agregar"]);
    }
}
