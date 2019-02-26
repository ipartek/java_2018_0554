export class Agente {


        private _id: number;
   
        private _pass: any;
    
     
        constructor(id:number,pass:any){
            this._id=id;
            this._pass=pass;        
        }
        
    
        public get id(): number {
            return this._id;
        }
        public set id(value: number) {
            this._id = value;
        }

        public get pass(): any {
            return this._pass;
        }
        public set pass(value: any) {
            this._pass = value;
        }
    


    
}
