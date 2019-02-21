import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/model/todo';
import { TodosService } from 'src/app/providers/todo.service';

@Component({
  selector: 'app-pagina-service-todos',
  templateUrl: './pagina-service-todos.component.html',
  styleUrls: ['./pagina-service-todos.component.scss']
})
export class PaginaServiceTodosComponent implements OnInit {

  todos : Todo[];
  nuevaTarea : string;

  constructor( public todosService:TodosService ) {
      console.log('TodosComponent constructor');
      this.todos = [];
  }

  ngOnInit() {
    console.log('TodosComponent ngOnInit');
    this.cargarTareas();

  }
  //ngOnInit

  cargarTareas(){
    console.log('TodosComponent cargarTareas');
    this.todos = [];
    this.todosService.getTodos().subscribe(
      resultado => {
        console.debug('peticion correcta %o', resultado);
       // this.mapeo(resultado);
      // this.todos = resultado.filter( todo => !todo.completed );
         this.todos = resultado;
      },
      error=>{
        console.warn('peticion incorrecta %o', error);
      }
    );//subscribe

    
  }

  /**
   * Mapea los Datos en formato Json a Todo que proviene del Servicio Rest
   * @param resultado : any 
   */
  mapeo( result : any ){

    let todo:Todo;
    result.forEach(el => {
        todo = new Todo( el.title );
        todo.id = el.id;
        todo.idUser = el.userId;
        todo.completed = el.completed;

        this.todos.push(todo);
    });

  }

  change(todo:Todo){
    console.log('TodosComponent change %o', todo );
    this.todosService.patch(todo).subscribe(     
        result=>{
          console.log('Tarea modificada con exito %o', result);
          this.cargarTareas();
        },
        error=>{
          alert('No de pudo Modificar la Tarea');
        }      
    );
  }

  delete(todo:Todo){
    console.log('TodosComponent delete %o', todo );

    this.todosService.delete(todo.id).subscribe(
      result=>{
        this.cargarTareas();
      },
      error=>{
        alert('No de pudo elimiar Tarea');
      }
    );
    /*
    this.todos.forEach( (t, index) =>{
      if ( t.id === todo.id ){
        this.todos.splice(index,1);
        return false; //break        
      }
    });*/

  }
  
  new(){
    console.log('TodosComponent new ');
    let todo = new Todo(this.nuevaTarea);
    /*
    let todo = new Todo(this.nuevaTarea);
    this.todos.unshift(todo);
    this.nuevaTarea = "";
    */
    this.todosService.post(todo).subscribe(
      result=>{
        console.log('TodosComponent new %o', result);
        this.cargarTareas();
      },
      error=>{
        alert('No de pudo Crear Nueva Tarea');
        console.error(error);
      }
    );
  }

}
