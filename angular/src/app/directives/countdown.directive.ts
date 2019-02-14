import { Directive, Input, ElementRef, SimpleChanges } from '@angular/core';

@Directive({
  selector: '[appCountdown]'
})
export class CountdownDirective {

  //Declarar variables de entrada mediante el @Input()
  @Input('appCountdown')appCountdown:number;

  constructor(private element:ElementRef) {
    console.trace('CountdownDirective constructor');
   }

   ngOnChanges(changes: SimpleChanges){
     console.trace('Metodo para realizar cambios de color');
    if(changes.appCountdown){
      //Obtener el valor de appCountdown cuando hay cambios
      let value = changes.appCountdown.currentValue;
      console.debug('input currentValue %o', changes.appCountdown);
        if(value <= 5 && value > 3){
          this.element.nativeElement.style.color='orange';
        
        }else if(value<=3){
          this.element.nativeElement.style.color='red';
          
        }else {
          this.element.nativeElement.style.color='green';
        }
      }//changes
   }//ngOnChanges
}
