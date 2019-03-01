import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GLOBAL } from 'src/global';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  constructor( public http: HttpClient ) {
    console.log('MultaService constructor');

   }

   
}
