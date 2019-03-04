export class Multa {

    private _id: number;
   

    private _idCoche: number;
 

    private _concepto: string;
   

    private _fechaAlta: string;
    

    private _fechaBaja: string;
    

    private _matricula: string;
    

    private _modelo: string;

    private _importe: number;
   

     /**
     * Obligatorio todos menos fechaBaja
     * @param id 
     * @param idCoche 
     * @param concepto 
     * @param fechaAlta 
     * @param fechaBaja 
     * @param matricula
     * @param modelo
     */
    //constructor, solo puede haber uno, no existe sobrecarga
    constructor(id: number, idCoche: number, concepto: string, fechaAlta: string, fechaBaja: string, matricula: string, modelo: string, importe:number) {
        console.trace('Fruta constructor');
        this._id = id;
        this._idCoche = (idCoche) ? idCoche : 0;
        this._concepto = concepto;
        this._fechaAlta = (fechaAlta) ? fechaAlta : '';
        this._fechaBaja = (fechaBaja) ? fechaBaja : '';
        this._matricula = matricula;
        this._modelo = (modelo) ? modelo : '';
        this._importe = importe;
    }
    
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get idCoche(): number {
        return this._idCoche;
    }
    public set idCoche(value: number) {
        this._idCoche = value;
    }

    public get concepto(): string {
        return this._concepto;
    }
    public set concepto(value: string) {
        this._concepto = value;
    }

    public get fechaAlta(): string {
        return this._fechaAlta;
    }
    public set fechaAlta(value: string) {
        this._fechaAlta = value;
    }

    public get fechaBaja(): string {
        return this._fechaBaja;
    }
    public set fechaBaja(value: string) {
        this._fechaBaja = value;
    }

    public get matricula(): string {
        return this._matricula;
    }
    public set matricula(value: string) {
        this._matricula = value;
    }

    public get modelo(): string {
        return this._modelo;
    }
    public set modelo(value: string) {
        this._modelo = value;
    }

    public get importe(): number {
        return this._importe;
    }
    public set importe(value: number) {
        this._importe = value;
    }


}
