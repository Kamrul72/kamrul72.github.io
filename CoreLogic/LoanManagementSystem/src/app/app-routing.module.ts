import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { TestComponentComponent } from './test-component/test-component.component';
import { SearchLoanComponent } from './search-loan/search-loan.component';
import { AddLoanComponent } from './add-loan/add-loan.component';


const routes: Routes = [ 
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path:'login',component:LoginComponent},
  {path:'searchLoan', component: SearchLoanComponent},

  {path:'addLoan' , component:AddLoanComponent},

  { path: '**', redirectTo: 'login' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
