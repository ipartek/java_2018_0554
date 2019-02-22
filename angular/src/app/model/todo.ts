export class Todo{

    id : number;
    idUser : number;
    title : string;
    completed : boolean;

    constructor( title: string ){
        this.id = -1;
        this.idUser = -1;
        this.title = title;
        this.completed = false;
    }

}