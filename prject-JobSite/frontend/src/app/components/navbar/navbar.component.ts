import { Component, OnInit } from '@angular/core';
// import { ForseekerService } from '../forseeker.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
username:any=localStorage.getItem('currentseeker');
  constructor() { }

  ngOnInit() {
  }
logout()
{
  // this.seekerservice.logout();
  // this.router.navigate(['login/emp_login']);
}
}
