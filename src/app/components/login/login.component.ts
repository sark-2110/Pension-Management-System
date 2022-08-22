import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

@Injectable({
  providedIn: 'root'
})
export class LoginComponent implements OnInit {

  credentials={
    userName:'',
    password:''
  }
  constructor(private loginService : LoginService , private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    if(this.credentials.userName!='' && this.credentials.password!='')
    {
      console.log("login details submitted");

      this.loginService.doLogin(this.credentials).subscribe(
        (response:any)=>{
          console.log(response);
          this.loginService.loginUser(response.token,this.credentials);
          console.log(response.token+" fg "+this.credentials);
          window.location.href="/pensionCalculation";
        },
        error=>{
          Swal.fire('Invalid!','Wrong username or password','error');     
        }
        
        
      )

    }else{
      console.log("empty fields");
    }
  }

}
