export class Persona {
//atributos privados comienzan por _nombreAtributo
    private _nombre: string;

//solo se puede declarar un constructor
//constructor(nombre:string='valor por defecto'){
    constructor(nombre?:string){
        this.nombre = (nombre)?nombre:'Anonimo';
        /*if(nombre){
            this.nombre = nombre
        }else{this.nombre = "anonimo";}*/
        
    }

//SETTERS GETTERS
    public get nombre(): string {
        console.trace("get Persona Nombre");
        return this._nombre;
    }

    public set nombre(value: string) {
        console.trace("set Persona nombre");
        this._nombre = value;
    }

}
