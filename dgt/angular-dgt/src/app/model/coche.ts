export class Coche {

    private _id: number;
   
    private _matricula: string;
   
    private _modelo: string;
   
    private _km: number;
    
    constructor(id:number, matricula:string, modelo:string, km: number){
        this._id = id;
        this._matricula= matricula;
        this._modelo = modelo;
        this._km = km;
    }
    
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
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

    public get km(): number {
        return this._km;
    }
    public set km(value: number) {
        this._km = value;
    }


}
