export class Multa {

    private _id: number;
    private _importe: number;
    private _concepto: string;
    private _fechaAlta: string;
    private _idAgente: number;
    private _idCoche: number;
    private _fechaModificacion: string;
    private _fechaBaja: string;

    constructor( 
        id: number, 
        importe: number, 
        concepto: string, 
        fechaAlta: string, 
        idAgente: number, 
        idCoche: number,
        fechaModificacion: string, 
        fechaBaja: string
    ){
    this._id = id;
    this._importe = importe;
    this._concepto = concepto;
    this._fechaAlta = fechaAlta;
    this._idAgente = idAgente;
    this._idCoche = idCoche;
    this._fechaModificacion = fechaModificacion;
    this._fechaBaja = fechaBaja;
    }

    //getters y setters
      
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get importe_1(): number {
        return this._importe;
    }
    public set importe_1(value: number) {
        this._importe = value;
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
        
    public get idAgente(): number {
        return this._idAgente;
    }
    public set idAgente(value: number) {
        this._idAgente = value;
    }
      
    public get idCoche(): number {
        return this._idCoche;
    }
    public set idCoche(value: number) {
        this._idCoche = value;
    }
       
    public get fechaModificacion(): string {
        return this._fechaModificacion;
    }
    public set fechaModificacion(value: string) {
        this._fechaModificacion = value;
    }
    
    public get fechaBaja(): string {
        return this._fechaBaja;
    }
    public set fechaBaja(value: string) {
        this._fechaBaja = value;
    }
}
