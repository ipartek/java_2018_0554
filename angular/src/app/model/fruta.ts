const IMAGEN_DEFAULT ='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxzQ8VNlPlj3bzVsE96lJJIdEHzKRkGBUeaI4y4v_x_PdvWZDN-A';

export class Fruta {
    
    //atributos privados y comienzan por _atributo
    private _id: number;
    private _nombre: string;
    private _precio: number;
    private _oferta: boolean;
    private _imagen: string;
    private _descuento: number;
    private _cantidad: number;
   
    
    //constructor solo uno
    // usaremos parametros opcionales?
    /**
     * 
     * @param nombre obligatorio
     * @param precio  obligatorio
     * @param id? -1
     * @param oferta ? false
     * @param descuento ? 0
     * @param imagen?IMAGEN_DEFAULT
     */
    constructor(nombre:string, precio:number,  id?:number, oferta:boolean=false, descuento?:number, imagen?:string, cantidad:number=1){
        //primero los obligatorios
        this._nombre = nombre;
        this._precio = precio;
        this._id = (id) ? id : -1;
        this._oferta = oferta ;
        this._descuento = (descuento) ? descuento : 0;
        this._imagen = (imagen) ? imagen : IMAGEN_DEFAULT;
        this.cantidad = cantidad;
    }


// - - - - - - - - - - - - - - - GETTERS & SETTERS - - - - - - - - - - - - - - -  

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


    public get precio(): number {
        return this._precio;
    }
    public set precio(value: number) {
        this._precio = value;
    }
 
    
    public get oferta(): boolean {
        return this._oferta;
    }
    public set oferta(value: boolean) {
        this._oferta = value;
    }


    public get imagen(): string {
        return this._imagen;
    }
    public set imagen(value: string) {
        this._imagen = value;
    }
 
    
    public get descuento(): number {
        return this._descuento;
    }
    public set descuento(value: number) {
        this._descuento = value;
    }

    public get cantidad(): number {
        return this._cantidad;
    }
    public set cantidad(value: number) {
        this._cantidad = value;
    }

//ToDo
    jsonMapper(jsonData : any){

    }
}
