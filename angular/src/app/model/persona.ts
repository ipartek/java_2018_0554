export class Persona {

    // atributos privados y comienzan por guion bajo "_"
    private _nombre: string;


    // solo se puede declara un constructor
    constructor( nombre?: string ){

        this._nombre = (nombre) ? nombre : 'Anonimo';

        /*
        if (nombre){
            this._nombre = nombre;
        }else{
            this._nombre = 'Anonimo';
        } 
        */
    }

    // getters y setters
    public get nombre(): string {
        console.trace('getter ' + this._nombre);
        return this._nombre;
    }

    public set nombre(value: string) {
        console.trace('setter ' + this._nombre);
        this._nombre = value;
    }

    


}