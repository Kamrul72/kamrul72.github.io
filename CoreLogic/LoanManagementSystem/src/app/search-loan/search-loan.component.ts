import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-search-loan',
  templateUrl: './search-loan.component.html',
  styleUrls: ['./search-loan.component.css']
})
export class SearchLoanComponent implements OnInit {

  loans: any=[];
  notFound:any;

  numberRegEx = /\-?\d*\.?\d{1,2}/;


 constructor(private router: Router,private fb:FormBuilder, private http:HttpClient) {}
  searchForm: FormGroup = this.fb.group({
    fName: [null,Validators.required],
    lName: [null,Validators.required],
    loanNum: [null,Validators.compose([Validators.required, Validators.pattern(this.numberRegEx)])]

  });
 
  ngOnInit(): void {
  }

  search(){
    if (!this.searchForm.valid) {
      console.log('Invalid'); return;
    }
    const httpOptions = {
      headers: new HttpHeaders({
       
        'Content-Type': 'application/json',
        'Authorization': 'Bearer '+localStorage.getItem('loanseekertoken'),
      })
    };
  
    this.http.get( 'http://localhost:3000/search/'+this.searchForm.getRawValue().fName+'/'+
    this.searchForm.getRawValue().lName+'/'+this.searchForm.getRawValue().loanNum, httpOptions)
       .subscribe( (response: any) =>  {
          this.loans=response    ;
         
        },
        (err)=> { 
           this.notFound='Sorry , We got an error to find your loan';
          console.log(this.searchForm.getRawValue().fName);
        });

  }

  moveToAddLoan(){
    this.router.navigate(['addLoan']);
  }
logout(){

  localStorage.removeItem('seekertoken');
  localStorage.removeItem('name');
  this.router.navigate(['login']);

}

}
