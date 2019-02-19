import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.scss']
})
export class CarritoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  recibirCarrito(event){
    alert("He recibido un evento del Hijo prueba=" + event.prueba);
  }

}
