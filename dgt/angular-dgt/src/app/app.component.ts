import { Component } from '@angular/core';
import { LoginServiceService } from './providers/login-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-dgt';

  constructor(private loginService: LoginServiceService){
    
  }
  logout(){
    this.loginService.logout();
  }
}

