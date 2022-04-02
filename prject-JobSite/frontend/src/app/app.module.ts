import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ReactiveFormsModule,FormsModule} from '@angular/forms';
import { AppRoutingModule,routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { SeekerService } from './services/seeker.service';
import { HttpClientModule } from '@angular/common/http';
import { CompanyService } from './services/company.service';
import { AuthorizationGuard } from './authorization.guard';
import { CompanyGuard } from './company.guard';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    routingComponents,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [SeekerService,CompanyService,AuthorizationGuard,CompanyGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
