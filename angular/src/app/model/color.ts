export class Color{
    private _nombre: string;
    private _codigo: string;

    constructor(nombre:string,codigo:string){
        this._nombre =(nombre) ? nombre :'blanco';
        this._codigo = (codigo) ? codigo :'#fff';
    }

    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
   
    public get codigo_1(): string {
        return this._codigo;
    }
    public set codigo_1(value: string) {
        this._codigo = value;
    }

    
}