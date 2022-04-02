import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SeekerloginComponent } from './components/login/seekerlogin/seekerlogin.component';
import { CompanyloginComponent } from './components/login/companylogin/companylogin.component';
import { DashboardComponent } from './components/seekerdashboard/dashboard.component';
import { JobsComponent } from './components/seekerdashboard/jobs/jobs.component';
import { AppliedjobsComponent } from './components/seekerdashboard/appliedjobs/appliedjobs.component';
import { RegisterComponent } from './components/register/register.component';
import { SeekerregisterComponent } from './components/register/seekerregister/seekerregister.component';
import { CompanyregisterComponent } from './components/register/companyregister/companyregister.component';
import { PostjobComponent } from './components/companydashboard/postjob/postjob.component';
import { PostedjobsComponent } from './components/companydashboard/postedjobs/postedjobs.component';
import { CompanydashboardComponent } from './components/companydashboard/companydashboard.component';
import { AuthorizationGuard } from './authorization.guard';
import { CompanyGuard } from './company.guard';
const routes: Routes = [
  { path: '', redirectTo: 'login/emp_login', pathMatch: 'full' },
  {
    path: 'login',
    component: LoginComponent,
    children: [
      { path: 'emp_login', component: SeekerloginComponent },
      { path: 'rec_login', component: CompanyloginComponent },
    ],
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthorizationGuard],
    children: [
      {
        path: 'jobs',
        component: JobsComponent,
        canActivate: [AuthorizationGuard],
      },
      {
        path: 'appliedjobs',
        component: AppliedjobsComponent,
        canActivate: [AuthorizationGuard],
      },
    ],
  },
  {
    path: 'register',
    component: RegisterComponent,
    children: [
      { path: 'emp_register', component: SeekerregisterComponent },
      { path: 'rec_register', component: CompanyregisterComponent },
    ],
  },
  {
    path: 'rdashboard',
    component: CompanydashboardComponent,
    canActivate: [CompanyGuard],
    children: [
      {
        path: 'postedjobs',
        component: PostedjobsComponent,
        canActivate: [CompanyGuard],
      }
    ],
  },
  {
    path: 'company/postjob',
    component: PostjobComponent,
    canActivate: [CompanyGuard],
  },
  { path: '**', redirectTo: 'login/emp_login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
export const routingComponents = [
  SeekerloginComponent,
  CompanyloginComponent,
  DashboardComponent,
  JobsComponent,
  AppliedjobsComponent,
  RegisterComponent,
  SeekerregisterComponent,
  CompanyregisterComponent,
  PostjobComponent,
  PostedjobsComponent,
  CompanydashboardComponent,
];
