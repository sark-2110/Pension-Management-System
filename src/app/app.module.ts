import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PensionerInputComponent } from './components/pensioner-input/pensioner-input.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { PensionDisburseComponent } from './components/pension-disburse/pension-disburse.component';
import { LoginService } from 'src/app/services/login.service';
import { AuthGuard } from 'src/app/services/auth.guard';
import { AuthInterceptor } from 'src/app/services/auth.interceptor';
import {MatIconModule} from '@angular/material/icon'
import { MatTabsModule } from '@angular/material/tabs';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    PensionDisburseComponent,
    PensionerInputComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    NgbModule,
    MatTableModule,
    HttpClientModule,
    MatIconModule,
    MatTabsModule,
    NgbModule

  ],
  providers: [ LoginService,AuthGuard,[{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}] ],
  bootstrap: [AppComponent]
})
export class AppModule { }
