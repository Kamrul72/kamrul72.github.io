import { Component, OnInit } from '@angular/core';
import{Router,ActivatedRoute,ParamMap} from '@angular/router';
import { CompanyService } from 'src/app/services/company.service';
//import{ForcompanyService} from '../../../forcompany.service';
@Component({
  selector: 'app-postedjobs',
  templateUrl: './postedjobs.component.html',
  styleUrls: ['./postedjobs.component.css']
})
export class PostedjobsComponent implements OnInit {
  headers=['Job Role','Experience','Job Type','PostedDate',''];
  posted:any;
  nojobs:any;
  totaljobs:any;
  errormsg:any;
  successmsg:boolean=true;
  constructor(private router:Router,private activeroute:ActivatedRoute, private companyService:CompanyService) { }

  ngOnInit() {
    this.postedjobs();
  }
  postedjobs()
  {
    this.companyService.getpostedjobs().subscribe(
      (response:any)=>{
        if(response&& response.length>0){
        this.successmsg=true;
       
        this.posted=response;
        this.totaljobs=response.length;
        this.successmsg=true;
        }
        
      else{
        console.log(response);
        this.nojobs=response.message;
        console.log(response.length);
        
        //console.log(this.applied);
      }
    },(error:any)=>{
      this.errormsg=error;
    }
    )
  }
}
