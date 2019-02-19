export class Persona {

    private _nombre: string;

    constructor(){
        this.nombre = 'Anonimo';
    }
    
    public get nombre(): string {
        console.trace('getter' + this._nombre);
        return this._nombre;
    }
    public set nombre(value: string) {
        console.trace('setter' + this._nombre);
        this._nombre = value;
    }
}
