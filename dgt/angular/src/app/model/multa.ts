export class Multa {

    private _id: number;
    private _importe: number;
    private _concepto: string;
    private _fecha: string;
    private _fechaBaja: string;

    constructor(id?: number, importe?: number, concepto?: string, fecha?: string, fechaBaja?: string) {
        this._id = (id) ? id : -1;
        this._importe = importe;
        this._concepto = concepto;
        this._fecha = fecha;
        this._fechaBaja = (fechaBaja) ? fechaBaja : "Activa";
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
    public get fechaBaja(): string {
        return this._fechaBaja;
    }
    public set fechaBaja(value: string) {
        this._fechaBaja = value;
    }


    public toString() {
      return `{"id": ${this.id},"importe": ${this.importe},"concepto":"${this.concepto}","fecha": "${this.fecha}","fechaBaja": "${this.fechaBaja}"}`;
    }

}
