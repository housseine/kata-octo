import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'transaction-component',
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css']
})
export class TransactionDetailsComponent  implements OnInit{
  ngOnInit(): void {
   this.currency="Euro";
   this.amount=0.031238;
   this.timeOfTransaction=new Date();
  }
  @Input()
  public currency: string;

  @Input()
  public timeOfTransaction: Date;

  @Input()
  public amount: number;


}
