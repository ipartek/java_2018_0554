import { Mensaje } from './mensaje';


export class Fruta {

    //atributos
    private _id: number;
    private _nombre: string;
    private _oferta: boolean;
    private _precio: number;
    private _descuento: number;
    private _imagen: string;
    private _cantidad: number;

    static IMAGEN_DEFAULT = 'http://frutas.consumer.es/sites/default/files/compra_0.jpg';

    //http://frutas.consumer.es/sites/default/files/compra_0.jpg img por defecto
    //constructor,solo puede haber uno, no existe sobrecarga
    //usaremos parametros con ?, para marcar opcionales
    /**Obligatorio nombre y precio
     * @param nombre obligatorio
     * @param precio obligatorio
     * @param id?-1 opcional
     * @param oferta? valor por defecto false;
     * @param descuent? 0 opcional
     * @param imagen? opcional
     * @param cantidad 1 por defecto
     */
    constructor(nombre: string, precio: number, id?: number, oferta = false, descuento?: number, imagen?: string, cantidad = 1) {

        this._nombre = nombre;
        this._precio = precio;
        this._id = (id) ? id : -1;
        this._oferta = oferta;
        this._descuento = (descuento) ? descuento : 0;
        this._imagen = (imagen) ? imagen : Fruta.IMAGEN_DEFAULT;
        this._cantidad = cantidad;
    }
    //getters y setters
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
    public get oferta(): boolean {
        return this._oferta;
    }
    public set oferta(value: boolean) {
        this._oferta = value;
    }
    public get precio(): number {
        return this._precio;
    }
    public set precio(value: number) {
        this._precio = value;
    }
    public get descuento(): number {
        return this._descuento;
    }
    public set descuento(value: number) {
        this._descuento = value;
    }
    public get imagen(): string {
        if (this._imagen && this._imagen != '') {
            return this._imagen;
        }

        return Fruta.IMAGEN_DEFAULT;
    }
    public set imagen(value: string) {
        if (this._imagen && this._imagen != '') {
            this._imagen = value;
        }

        this._imagen = Fruta.IMAGEN_DEFAULT;
    }
    public get cantidad(): number {
        return this._cantidad;
    }
    public set cantidad(value: number) {
        this._cantidad = value;
    }
    //TODO
    jsonMapper(jsonData: any) {

    }
}
