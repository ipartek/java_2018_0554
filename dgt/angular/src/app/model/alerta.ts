export class Alerta {

    public static TIPO_ERROR = 'danger';
    public static TIPO_SUCCESS = 'success';
    public static TIPO_INFO = 'info';
    public static TIPO_WARNING = 'warning';

    private _texto: string;
    private _tipo: string;

    constructor(texto: string, tipo = Alerta.TIPO_ERROR) {
        this._texto = texto;
        this._tipo = tipo;
    }

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
