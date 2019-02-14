import { Directive, Input, SimpleChanges, ElementRef } from '@angular/core';

@Directive({
  selector: '[appCountdown]'
})
export class CountdownDirective {

  @Input() appCountdown : number;

  constructor(private element: ElementRef) { 
    console.trace("Constructor Countdown")
  }

  ngOnChanges(changes: SimpleChanges){
    if(changes.appCountdown){
      console.debug('Input currentValue %o' + changes.appCountdown.currentValue);
      let valorActual = changes.appCountdown.currentValue;
      if( valorActual <= 3){
        this.element.nativeElement.style.color = 'red';
      }else if( valorActual <= 5){
        this.element.nativeElement.style.color = 'orange';
      }else{
        this.element.nativeElement.style.color = 'green';
      }
    }
  } // ngOnChanges

}
