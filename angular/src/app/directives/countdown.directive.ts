import { Directive, HostListener, ElementRef, Input, SimpleChanges } from '@angular/core';

@Directive({
  selector: '[appCountdown]'
})
export class CountdownDirective {
  @Input() appCountdown:number;


  constructor(private element: ElementRef) {
    console.trace('appCountdown constructor %o', this.appCountdown);
    this.element.nativeElement.style.backgroundColor = 'green';
    
  }
  ngOnChanges(changes: SimpleChanges){
    if(changes.appCountdown){
      //%o pinta el objeto
      console.log('appCountdown cambiando %o', changes.appCountdown);
     let valorActual = changes.appCountdown.currentValue;
     if(valorActual<=3){
      this.element.nativeElement.style.backgroundColor = 'red';
     }else if(valorActual<=5){
      this.element.nativeElement.style.backgroundColor = 'DarkOrange';
     }
     else if(valorActual<=8){
      this.element.nativeElement.style.backgroundColor = 'coral';
     }
    }
  }

}
