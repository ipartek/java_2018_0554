export class Alert {
    static DANGER = 'danger';
    static PRIMARY = 'primary';
    static SUCCESS = 'success';
    static WARNING = 'warning';

    private _mensaje: string;
    private _tipo: string;

    constructor( mensaje: string, tipo: string = Alert.DANGER ){
        this._mensaje = mensaje;
        this._tipo = tipo;
    }

    public get mensaje(): string {
        return this._mensaje;
    }
    public set mensaje(value: string) {
        this._mensaje = value;
    }
   
    public get tipo(): string {
        return this._tipo;
    }
    public set tipo(value: string) {
        this._tipo = value;
    }
}
