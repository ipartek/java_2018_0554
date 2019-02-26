import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from '../model/todo';
import { GLOBAL } from '../GLOBAL';



@Injectable({
  providedIn: 'root'
})
export class TodosService {
  

  constructor( public http: HttpClient) { 
    console.log('TodosService constructor');
  }

  /** 
   * Recuperamos todas las Tareas sin filtrar por usuario
  */
  getTodos():Observable<any>{

    //let url = END_POINT + '/todos?userId=2';
    const url = GLOBAL.endpoint + '/todos';
    console.log(`TodosService getTodos ${url}`);
    return this.http.get(url);

  }

  /**
   * Eliminamos una Tarea por su id
   * @param id : number
   */
  delete(id:number){
    let url = GLOBAL.endpoint + '/todos/'+id;
    console.log(`TodosService delete ${url}`);
    return this.http.delete(url);
  }

  /**
   * Creamos una nueva Tarea
   * @param todo : Todo
   */
  post(todo:Todo):Observable<any>{
      let url = GLOBAL.endpoint + '/todos/';
      console.log(`TodosService put ${url}`);

      let body = {
                    // "id": todo.id,
                    "userId": todo.idUser,
                    "title": todo.title,
                    "completed": todo.completed    
                  } 
                
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };

      return this.http.post( url, body , httpOptions );
    }

    /**
     * Modificamos el estado "completed" de una Tarea por su id
     * @param todo : Todo
     */
    patch(todo: Todo):Observable<any>{
      let url = GLOBAL.endpoint + `/todos/${todo.id}`;
      console.log(`TodosService patch ${url}`);

      let body = {                    
                    "completed": !todo.completed    
                  } 
                
      
      return this.http.patch( url, body );
    }


}