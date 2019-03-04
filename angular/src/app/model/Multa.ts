export class Multa {


    private _id: number;
    private _importe: any;
    private _concepto: string;
    private _fecha_alta: any;
    private _id_coche: number;
    private _id_agente: number;



    constructor(id: number, importe: any, concepto: string, fecha_alta: any, id_coche: number, id_agente: number) {
        this._id = id;
        this._importe = importe;
        this._concepto = concepto;
        this._fecha_alta = fecha_alta;
        this._id_coche = id_coche;
        this._id_agente = id_agente;

    }


    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get importe(): any {
        return this._importe;
    }
    public set importe(value: any) {
        this._importe = value;
    }

    public get concepto(): string {
        return this._concepto;
    }
    public set concepto(value: string) {
        this._concepto = value;
    }

    public get fecha_alta(): any {
        return this._fecha_alta;
    }
    public set fecha_alta(value: any) {
        this._fecha_alta = value;
    }

    public get id_coche(): number {
        return this._id_coche;
    }
    public set id_coche(value: number) {
        this._id_coche = value;
    }

    public get id_agente(): number {
        return this._id_agente;
    }
    public set id_agente(value: number) {
        this._id_agente = value;
    }
}