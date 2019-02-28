export class Agente {

    private _id: number;
    private _nombre: string;
    private _placa: string;
    private _id_departamento: number;
    private _password: string;

    constructor(
        id: number = -1,
        nombre: string,
        placa: string,
        id_departamento: number,
        password: string
    ) {
        this._id = id;
        this._nombre = nombre;
        this._placa = placa;
        this._id_departamento = id_departamento;
        this._password = password;
    }

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
    public get placa(): string {
        return this._placa;
    }
    public set placa(value: string) {
        this._placa = value;
    }
    public get id_departamento(): number {
        return this._id_departamento;
    }
    public set id_departamento(value: number) {
        this._id_departamento = value;
    }
    public get password(): string {
        return this._password;
    }
    public set password(value: string) {
        this._password = value;
    }
}
