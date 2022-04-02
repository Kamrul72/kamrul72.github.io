import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const url = 'http://localhost:3000/'
@Injectable()
export class CompanyService {

  constructor(private httpclient: HttpClient) { }
  login(body: any) {
    return this.httpclient.post(`${url}companies/login`, body, {
      observe: 'body',
      // withCredentials: true,
      headers: new HttpHeaders().append('Content-Type', 'application/json'),
    });
  }
  companyRegister(body: any) {
    return this.httpclient.post(`${url}companies`,body)
  }
  getpostedjobs(){
    return this.httpclient.get(`${url}companies/postedJobs/${this.getpayload()}`)
  }
  getseekers(){
    return this.httpclient.get(`${url}companies/appliedSeeker/${this.getpayload()}`)
  }
  send(info:any){
    let email=info;
    console.log(email);
    return this.httpclient.get(`${url}companies/send/${email}`);
  }
  postjob(body: any){
    return this.httpclient.post(`${url}companies/addJobs/${this.getpayload()}`,body)
  }
  gettoken() {
    return localStorage.getItem('companytoken');
  }
  getpayload() {
    return localStorage.getItem('name');
  }
  logout()
{
  localStorage.removeItem('companytoken');
  localStorage.removeItem('name');
}
}
