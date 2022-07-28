import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginsuccess: any;
  loginfail:any;
  loginMessage=false;
 

  constructor(private router: Router,private fb:FormBuilder, private http:HttpClient) { }
  loginForm: FormGroup = this.fb.group({
    name: [null,Validators.required],
    password: [null,Validators.compose([Validators.required,Validators.minLength(5)])]
  });
  ngOnInit() {
  }
  
  login() {
    
    if (!this.loginForm.valid) {
      console.log('Invalid'); return;
    }
    console.log(JSON.stringify(this.loginForm.value.name));
    this.http.post( 'http://localhost:3000/login', this.loginForm.value)
      .subscribe(
        (response: any) => {
          console.log(response.success);
          if (response.success===1) {
            this.loginsuccess = "Login Success";
            localStorage.setItem('loanseekertoken',response.token);    
            this.loginForm.reset();
            setTimeout(() => {
              localStorage.setItem('name',response.name);
              this.router.navigate(['searchLoan']);
            }, 20);
          }
          else {
            this.loginfail ="invalid username/password";
          }
        },
        (error:any) => { console.log(error); 
          this.router.navigate(['searchLoan']);
        }
      );
  }

  get form(){
    return this.loginForm.controls;
  }
  clearForm(){
    (<HTMLFormElement>document.getElementById("loginform")).reset();
   }


}
