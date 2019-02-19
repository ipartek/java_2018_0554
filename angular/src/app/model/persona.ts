export class Persona {

    //Atributos privados y comienzan por guión bajo '_'
    private _nombre: string;

    // Solo se puede declarar un constructor
    constructor( nombre?: string){
        // Con operador ternario (Tipo JavaScript)
        this._nombre = (nombre) ? nombre : 'Anonimo';
        
        //Tipo Java
        // if(nombre){
        //     this._nombre=nombre;
        // }else{
        //     this._nombre='Anónimo';
        // }
    }

    //Getters y Setters
    public get nombre(): string {
        console.trace('getter ' + this._nombre);
        return this._nombre;
    }
    public set nombre(value: string) {
        console.trace('setter ' + this._nombre);
        this._nombre = value;
    }
}
