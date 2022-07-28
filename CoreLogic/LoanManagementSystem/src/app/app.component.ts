import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  
 <p> {{title}}</p>
  <router-outlet></router-outlet>
  `,
  styles: [`
  p{
    font-size:30px ;
    font-weight:bold;
    font-style: italic;

  
  
  }
  `]
})
export class AppComponent {
  title = 'Loan Management System';
}
