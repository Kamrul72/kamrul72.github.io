import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CompanyService } from 'src/app/services/company.service';
@Component({
  selector: 'app-postjob',
  templateUrl: './postjob.component.html',
  styleUrls: ['./postjob.component.css']
})
export class PostjobComponent implements OnInit {
  // private postjobForm: FormGroup;
  postjobForm:any;
  postedMsg:any;
  alreadyposted:any;
  errormsg:any;
  companyname:any;
  companyId:any;
  constructor(private router: Router,private fb: FormBuilder,private companyService:CompanyService) { }

  ngOnInit() {
    this.companyname=this.companyService.getpayload();
    this.postjobForm = this.fb.group({
      companyId: new FormControl(this.companyId),
      jobRole: ['', Validators.required],
      experience: ['', Validators.required],
      skills: ['', Validators.required],
      description: ['', Validators.required],
      jobType: ['', Validators.required]
    })
  }
  logoutCompany() {
    this.companyService.logout();
    this.router.navigate(['login/rec_login'])
  }
  postajob() {
    this.router.navigate(['rdashboard/postedjobs']);
    console.log(this.postjobForm.value);
    this.companyService.postjob(this.postjobForm.value).subscribe(
      (response:any)=>{
        if(response.status && response.status==1)
        {
          this.postedMsg=response.message;
          setTimeout(()=>{
            this.postedMsg='';
            this.router.navigate(['rdashboard/postedjobs']);
          },3000);
        }else{
          this.alreadyposted=response.message;
          setTimeout(()=>{
            this.alreadyposted='';
          },2000);
        }
      },(error)=>{
        this.errormsg="Internal Server Error";
      }
    )
  }

}
