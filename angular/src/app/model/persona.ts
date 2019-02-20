export class Persona {

    //Atributos privados y comienzan por guión bajo '_'
    private _nombre: string;
    private _apellido: string;
    private _email: string;
    private _imagen: string;
    


    // Solo se puede declarar un constructor
    constructor( nombre?: string, apellido?: string, email?: string, imagen?: string){
        // Con operador ternario (Tipo JavaScript)
        this._nombre = (nombre) ? nombre : 'No definido';
        this._apellido = (apellido) ? apellido : 'No definido';
        this._email = (email) ? email : 'No definido';
        this._imagen = (imagen) ? imagen : 'No definido';
        
        //Tipo Java
        // if(nombre){
        //     this._nombre=nombre;
        // }else{
        //     this._nombre='Anónimo';
        // }
    }

    //Getters y Setters
    public get nombre(): string {
        //console.trace('getter ' + this._nombre);
        return this._nombre;
    }
    public set nombre(value: string) {
        //console.trace('setter ' + this._nombre);
        this._nombre = value;
    }

    public get apellido(): string {
        return this._apellido;
    }
    public set apellido(value: string) {
        this._apellido = value;
    }

    public get email(): string {
        return this._email;
    }
    public set email(value: string) {
        this._email = value;
    }

    public get imagen(): string {
        return this._imagen;
    }
    public set imagen(value: string) {
        this._imagen = value;
    }

}
