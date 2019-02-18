export class Persona {
    //atributos privados y empiezas por " _ "
    private _nombre: string;
    //solo se puede declarar un constructor
    constructor(nombre?: string){
       this._nombre = (nombre)? nombre : 'Anoimo';
        /* if(nombre){
            this._nombre=nombre;
        }else{
            this._nombre='Anonimo';
        }
        */
    }
    //gettters y setters
    public get nombre(): string {
        console.trace('getter ' + this._nombre);
        return this._nombre;
    }
    public set nombre(value: string) {
        console.trace('setter ' + this._nombre);
        this._nombre = value;
    }


}
