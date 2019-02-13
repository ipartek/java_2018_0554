import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appDirectiva1]'
})
export class Directiva1Directive {

  @Input('appDirectiva1') appDirectiva1:string;
  @Input('colorTexto')colorTexto:string;

  constructor(private element: ElementRef) {
    console.trace('Directiva1Directive constructor');
   }

   @HostListener('mouseenter')
   publiconMouseEnter(){
    console.trace('Directiva1Directive publiconMouseEnter');

    this.element.nativeElement.style.backgroundColor = (this.colorTexto) ? this.colorTexto : 'black';
    this.element.nativeElement.style.color = this.appDirectiva1;

   }

   @HostListener('mouseleave')
   publiconMouseLeave(){
    console.trace('Directiva1Directive publiconMouseLeave');

    this.element.nativeElement.style.backgroundColor = 'black';
    this.element.nativeElement.style.colorTexto = 'white';
  
   }

}
