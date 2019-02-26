import { Directive, HostListener, ElementRef, Input } from '@angular/core';

@Directive({
  selector: '[appDirectiva1]'
})
export class Directiva1Directive {

  @Input('appDirectiva1') appDirectiva1: string;
  @Input('segundo') segundo: string;  // segundo parametro

  constructor(
    private element: ElementRef
  ) {
    console.trace('Directiva1Directive constructor');
  }

  @HostListener('mouseenter')
  publiconMouseEnter(){
    console.trace('Directiva1Directive mouseenter');
    
    this.element.nativeElement.style.backgroundColor = (this.segundo) ? this.segundo : 'black';
    this.element.nativeElement.style.color = this.appDirectiva1;
  }

  @HostListener('mouseleave')
  publiconMouseLeave(){
    console.trace('Directiva1Directive mouseleave');
    this.element.nativeElement.style.backgroundColor = 'white';
    this.element.nativeElement.style.color = 'black';
  }

}
