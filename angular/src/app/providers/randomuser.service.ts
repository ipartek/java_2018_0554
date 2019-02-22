import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RandomuserService {

  constructor( private httpClient: HttpClient ) { }


  getAll( numerOfPersons = 10 ){
    return this.httpClient.get('https://api.randomuser.me/?results='+numerOfPersons);    
  }
}