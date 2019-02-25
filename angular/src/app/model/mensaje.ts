export class Mensaje {

    private _texto: string;
    private _color: string;
    static DANGER ='alert-danger';
    static INFO ='alert-info';
    static SUCCESS='alert-success';
    static WARNING='alert-warning';
  

    constructor(texto: string, color: string= Mensaje.DANGER) {
        this._texto = texto;
        this._color = color;
    }

    public get texto(): string {
        return this._texto;
    }
    public set texto(value: string) {
        this._texto = value;
    }
    public get color(): string {
        return this._color;
    }
    public set color(value: string) {
        this._color = value;
    }
}
