import { Servicio } from './servicio';

export class Casa {

    private _id: number;
    

    private _nombre: string;
    
    private _precio: number;
    
    private _alquiler: boolean;
    
    private _habitaciones: number;
    
    private _foto: string;
    
    private _direccion: string;
    
    private _servicios: Servicio[];
    



    constructor(
        id: number,
        nombre: string,
        precio: number,
        alquiler: false,
        habitaciones: number,
        foto: string,
        direccion: string,
        servicios: any
        
    ) {
        this._id = id;
        this._nombre = nombre;
        this._precio = precio;
        this._alquiler = alquiler;
        this._habitaciones = habitaciones;
        this._foto = foto;
        this._direccion = direccion;
        this._servicios = servicios;
    }

    public get id_1(): number {
        return this._id;
    }
    public set id_1(value: number) {
        this._id = value;
    }

    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }

    public get precio(): number {
        return this._precio;
    }
    public set precio(value: number) {
        this._precio = value;
    }

    public get alquiler(): boolean {
        return this._alquiler;
    }
    public set alquiler(value: boolean) {
        this._alquiler = value;
    }

    public get habitaciones(): number {
        return this._habitaciones;
    }
    public set habitaciones(value: number) {
        this._habitaciones = value;
    }

    public get foto(): string {
        return this._foto;
    }
    public set foto(value: string) {
        this._foto = value;
    }

    public get direccion(): string {
        return this._direccion;
    }
    public set direccion(value: string) {
        this._direccion = value;
    }

    public get servicios(): Servicio[] {
        return this._servicios;
    }
    public set servicios(value: Servicio[]) {
        this._servicios = value;
    }
}

