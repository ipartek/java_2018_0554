export class Mensaje {
    
public static MENSAJE_ERROR = 'danger';
public static MENSAJE_SUCCESS = 'success';
public static MENSAJE_INFO = 'info';
public static MENSAJE_WARNING = 'warning';

    private _texto: string;
    private _tipo: string;
    

    constructor(texto: string, tipo = Mensaje.MENSAJE_ERROR){
        this._texto = texto;
        this._tipo = tipo;
    }

    //Getters y Setters
    public get texto(): string {
        return this._texto;
    }
    public set texto(value: string) {
        this._texto = value;
    }
    public get tipo(): string {
        return this._tipo;
    }
    public set tipo(value: string) {
        this._tipo = value;
    }
}
