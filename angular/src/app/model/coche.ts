const IMAGEN_DEFAULT = 'https://cdn.pixabay.com/photo/2017/07/27/17/56/bmw-2546164_960_720.png';

export class Coche {

    private _modelo: string;
    private _combustible: string;
    private _precio: number;
    private _km: number;
    private _imagen: string;

    constructor( modelo: string, combustible: string, precio: number, km?: number, imagen?: string ){

        this._modelo = modelo;
        this._combustible = combustible;
        this._precio = precio;
        this._km = (km) ? km : 0;
        this._imagen = (imagen) ? imagen : IMAGEN_DEFAULT;

    }

    //getters y setters
    public get modelo(): string {
        return this._modelo;
    }
    public set modelo(value: string) {
        this._modelo = value;
    }
    
    public get combustible(): string {
        return this._combustible;
    }
    public set combustible(value: string) {
        this._combustible = value;
    }
    
    public get precio(): number {
        return this._precio;
    }
    public set precio(value: number) {
        this._precio = value;
    }
    
    public get km(): number {
        return this._km;
    }
    public set km(value: number) {
        this._km = value;
    }
    
    public get imagen(): string {
        return this._imagen;
    }
    public set imagen(value: string) {
        this._imagen = value;
    }
}
