import { Directive, HostListener, ElementRef, Input } from '@angular/core';

@Directive({
  selector: '[appDirectiva1]'
})
export class Directiva1Directive {

  @Input() appDirectiva1:string;

  constructor(private element: ElementRef) {
    console.trace("Directiva1Directive constructor");
   }

   @HostListener('mouseenter')
    publiconMouseEnter(){
      console.trace("Directiva1Directive MouseEnter");
      this.element.nativeElement.style.backgroundColor = this.appDirectiva1;
    }
 
    @HostListener('mouseleave')
    publiconMouseLeave(){
      console.trace("Directiva1Directive MouseLeave");
      this.element.nativeElement.style.backgroundColor = "white";
    }

}
