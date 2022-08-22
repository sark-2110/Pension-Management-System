import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './services/auth.guard';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PensionDisburseComponent } from './components/pension-disburse/pension-disburse.component';
import { PensionerInputComponent } from './components/pensioner-input/pensioner-input.component';


const routes: Routes = [
  {
    path:'',component:HomeComponent,pathMatch:'full'
  },
  {
    path:'login',component:LoginComponent,pathMatch:'full'
  },
  {
    path:'pensionCalculation',component:PensionerInputComponent,pathMatch:'full',canActivate:[AuthGuard]
  },
  {
    path:'disbursePension',component:PensionDisburseComponent,pathMatch:'full',canActivate:[AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { 
  
 }
