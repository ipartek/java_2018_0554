export class Persona {

    private _nombre: string;

    private _apellido: string;

    private _email: string;

    private _picture: string;
 

    constructor(nombre:string,apellido:string,email:string,picture:string){
        this._nombre=nombre;
        this._apellido=apellido;
        this._email=email;
        this._picture=picture;
    }
    
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
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
    public get picture(): string {
        return this._picture;
    }
    public set picture(value: string) {
        this._picture = value;
    }
}
