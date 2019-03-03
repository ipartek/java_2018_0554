import { Directive, Input, SimpleChange, ElementRef } from '@angular/core';

@Directive({
  selector: '[appPrueba]'
})
export class PruebaDirective {

  @Input() appPrueba: number;
  constructor(
    private element: ElementRef
  ) { 
    console.trace('PruebaDirective constructor');
  }

  /*ngOnChanges (changes: SimpleChange){
    if(changes.appPrueba){
      console.debug('input currentValue %o', changes.appPrueba);
      let valorActual = changes.appPrueba.currentValue;
      if(valorActual <= 3){
        this.element.nativeElement.style.color = 'red';
      }else if (valorActual <= 5){
        this.element.nativeElement.style.color = 'orange';
      }else{
        this.element.nativeElement.style.color = 'green';
      }
    }//changes
  }//ngOnChanges*/
}
