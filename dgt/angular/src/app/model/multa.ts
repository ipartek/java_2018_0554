export class Multa {

    private _id: number;
    private _importe: number;
    private _concepto: string;
    private _fecha: string;

    constructor(id: number, importe: number, concepto: string, fecha: string) {
        this._id = id;
        this._importe = importe;
        this._concepto = concepto;
        this._fecha = fecha;
    }


    //Getters y Setters
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get importe(): number {
        return this._importe;
    }
    public set importe(value: number) {
        this._importe = value;
    }
    public get concepto(): string {
        return this._concepto;
    }
    public set concepto(value: string) {
        this._concepto = value;
    }
    public get fecha(): string {
        return this._fecha;
    }
    public set fecha(value: string) {
        this._fecha = value;
    }



}
