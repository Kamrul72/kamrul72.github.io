import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {

  successfullyLoanAdded:any;
  errorAddingLoan:any  
  numberRegEx = /\-?\d*\.?\d{1,2}/;

  constructor(private router: Router,private fb:FormBuilder, private http:HttpClient) {}
  addLoanForm: FormGroup = this.fb.group({
    fName: [null,Validators.required],
    lName: [null,Validators.required],
    loanNum: [null,Validators.compose([Validators.required,Validators.pattern(this.numberRegEx)])],
    propertyAdd: [null,Validators.required]

  });

  ngOnInit(): void {
  }

  addLoan(){
    if (!this.addLoanForm.valid) {
      console.log('Invalid'); return;
    }
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer '+localStorage.getItem('loanseekertoken'),
      })
    };
  
    this.http.post( 'http://localhost:3000/add/',this.addLoanForm.value,httpOptions)
       .subscribe( (response: any) =>  {
          console.log(response)    ;
          this.successfullyLoanAdded='Successfully LoanAdded'
         
        },
        (err)=> { 
         this.errorAddingLoan='Got Error to add loan ';
          console.log('Internal Server Error');
        });

  }

moveToSearchLoan(){
this.router.navigate(['searchLoan']);
  }
logout(){
  localStorage.removeItem('loanseekertoken');
  localStorage.removeItem('name');
  this.router.navigate(['login']);

}

}
