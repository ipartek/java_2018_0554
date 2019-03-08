export class Servicio {

    private _nombre: string;
    
    private _disponible: boolean;
    

    constructor( nombre: string, disponible: boolean ){
        this._nombre = nombre;
        this._disponible = disponible;
    }

    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
    public get disponible(): boolean {
        return this._disponible;
    }
    public set disponible(value: boolean) {
        this._disponible = value;
    }
}
