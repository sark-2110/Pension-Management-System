import { Component, OnInit } from '@angular/core';
import { PensionerServiceService } from 'src/app/services/pensioner-service.service';
import Swal from 'sweetalert2';
import { pensionDisburse } from '../pensionDisburse';

@Component({
  selector: 'app-pension-disburse',
  templateUrl: './pension-disburse.component.html',
  styleUrls: ['./pension-disburse.component.css']
})
export class PensionDisburseComponent implements OnInit {

  credentials={
    aadhaarNumber:'',
    pensionAmount:null,
    bankServiceCharge:null,
  }
  result:any;

  data : pensionDisburse[]=[];
  constructor(private pensionService : PensionerServiceService) { }

  ngOnInit(): void {
  }
  onSubmit()
  {
    console.log("In here");
    this.pensionService.processPension(this.credentials).subscribe(
      (data:any)=>
      {
        console.log("Data",data);
        
        this.result=Object.values(data);
        console.log("Result "+this.result);

        if(this.result==10)
        {
          Swal.fire('Congratualtions!', 'Pension successfully disbursed!', 'success');
        }
        if(this.result==21)
        {
          Swal.fire('Error!', "Pension can't be disbursed!", 'error');
        }
      },
      error=>
      {
        console.log(error);
      }
    );
  }
}
