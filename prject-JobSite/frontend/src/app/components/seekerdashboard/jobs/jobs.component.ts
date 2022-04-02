import { Component, OnInit } from '@angular/core';
import { SeekerService } from 'src/app/services/seeker.service';
// import{ForseekerService} from '../../../forseeker.service';
@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {


jobs:any=[];
waitforjobs:any;
appliedmessage:any;
alreadyapplied:any;
errormessage:any;
totaljobs:any;
headers=['Company Name','Job Role','Skills','Job Type','Experience','posted Date','  '];
  constructor(private seekerService:SeekerService) {} 
  ngOnInit() {
  this.getjobs();
  }
  getjobs()
  {
    this.seekerService.getJobs().subscribe(
      (response:any)=>
    {
      if(response)
      {
        this.jobs=response;
        console.log(this.jobs);
        this.totaljobs=response.length;
      } 
    },
    (error)=>{
      console.log(error.msg);
    }
    );
  }
  apply(jobapply:any)
  {
    console.log(jobapply);
    this.seekerService.applyjob(jobapply).subscribe(
      (response:any)=>{
        if(response.success===1){
         this.appliedmessage="Applied successfully";
         setTimeout(()=>{
          this.appliedmessage='';
          this.getjobs();
         },2000) ;
        }else{
          this.alreadyapplied="already applied "; 
          setTimeout(()=>{
            this.alreadyapplied='';
            this.getjobs();
           },1000);
        }
        
      },(err:any)=>{
        this.errormessage=err.message;
      }
    );
    
  }
}
