import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import { CompanyService } from 'src/app/services/company.service';
//import {ForcompanyService} from '../../forcompany.service';
@Component({
  selector: 'app-rdashboard',
  templateUrl: './companydashboard.component.html',
  styleUrls: ['./companydashboard.component.css']
})
export class CompanydashboardComponent implements OnInit {

  constructor(private router:Router,private activeroute:ActivatedRoute,private companyService:CompanyService) { }
  companyName:any;
  ngOnInit() {
   this.companyName=this.companyService.getpayload()
  }
  logoutCompany()
  {
    this.companyService.logout();
    this.router.navigate(['login/rec_login'],)
  }
  posted_jobs()
  {
    this.router.navigate(['postedjobs'],{relativeTo:this.activeroute});
  }

}
