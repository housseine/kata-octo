import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent  {
  public question = "too easy";
  public yesAnswer = "Yes";
  public noAnswer = "No";
  private lastAnswer:string;

  captureAnswer(answer:boolean){
if(answer){this.lastAnswer=this.yesAnswer}
else this.lastAnswer=this.noAnswer;
  }

}
