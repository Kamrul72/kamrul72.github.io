import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder,FormControl,FormGroup,Validators} from '@angular/forms';
import { CompanyService } from 'src/app/services/company.service';
import { Subscription } from 'rxjs';
//import { ForcompanyService } from '../../../forcompany.service';
@Component({
  selector: 'app-companyregister',
  templateUrl: './companyregister.component.html',
  styleUrls: ['./companyregister.component.css']
})
export class CompanyregisterComponent implements OnInit {
  subscription: Subscription = new Subscription;
  CompanyRegisterForm:any;
  registrationsuccess:any;
  regisfail:any;
  regisserver:any;
  
  constructor(private router:Router,private fb:FormBuilder,private companyService:CompanyService){ }
 
  ngOnInit() {
    this.CompanyRegisterForm=this.fb.group({
      companyName: ['',Validators.required],
      password: ['',Validators.compose([Validators.required,Validators.minLength(8)])],
      email:['',Validators.compose([Validators.required,Validators.email])],
      About: ['']
      });
  }
  register_rectuiter()
  {
   this.subscription= this.companyService.companyRegister(this.CompanyRegisterForm.value).subscribe(
      (response:any)=>{
        console.log(response.success);
        if(response.success===1){
          this.registrationsuccess='your are successfully registered as Company';
          this.CompanyRegisterForm.reset();
            setTimeout(() => {
              this.router.navigate(['/login/rec_login']);
            }, 4000);
        }else{
          this.regisfail='You are already a job Giver';
          console.log(this.regisfail);
        }
      },
      (error)=>{
          this.regisserver='Internal server error'; 
      }

    );
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
