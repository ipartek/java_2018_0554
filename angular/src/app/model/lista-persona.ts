
export class ListaPersona {

    private _nombre: string;    
    private _apellido: string;   
    private _email: string;   
    private _imagen: string;
   

    constructor(
        nombre: string,
        apellido: string,
        email: string,
        imagen: string

    ) {
        this._nombre = (nombre) ? nombre : '';
        this._apellido = (apellido) ? apellido : '';
        this._email = (email) ? email : '';
        this._imagen = (imagen) ? imagen : '';  
    }

    public get nombre(): string {
        console.trace('getter ' + this._nombre);
        return this._nombre;
    }
    public set nombre(value: string) {
        console.trace('setter ' + this._nombre);
        this._nombre = value;
    }

    public get apellido(): string {
        return this._apellido;
    }
    public set apellido(value: string) {
        this._apellido = value;
    }

    public get email(): string {
        return this._email;
    }
    public set email(value: string) {
        this._email = value;
    }

    public get imagen(): string {
        return this._imagen;
    }
    public set imagen(value: string) {
        this._imagen = value;
    }
}
