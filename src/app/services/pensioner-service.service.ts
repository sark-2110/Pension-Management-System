import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PensionerServiceService {

  baseUrl="http://localhost:8082";
  constructor(private http:HttpClient) { }

  getPensionDetail(credentials:any)
  {
    return this.http.post( `${this.baseUrl}/pensionDetail`,credentials);
  }

  processPension(credentials:any)
  {
    console.log(credentials,"sd");
    return this.http.post(`${this.baseUrl}/processPension`,credentials);
  }
}
