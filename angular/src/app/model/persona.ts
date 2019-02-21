export class Persona {

    // atributos privados y comienzan por guion bajo "_"
    private _nombre: string;
    private _apellido: string;   
    private _email: string;  
    private _foto: string;
 
    // solo se puede declara un constructor
    constructor( nombre: string, apellido: string, email: string, foto:string ){

        this._nombre = (nombre) ? nombre : '';
        this._apellido = (apellido) ? apellido : '';
        this._email = (email) ? email : '';
        this._foto = (foto) ? foto : '';        
    }

    // getters y setters
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
    public get foto(): string {
        return this._foto;
    }
    public set foto(value: string) {
        this._foto = value;
    }
    


}
