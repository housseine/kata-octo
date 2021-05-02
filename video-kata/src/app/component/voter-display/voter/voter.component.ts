import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';


@Component({
  selector: 'voter-component',
  templateUrl: './voter.component.html',
  styleUrls: ['./voter.component.css']
})
export class VoterComponent {
  @Input()
  question: string;

  @Input()
  yesAnswer: string;

  @Input()
  noAnswer: string;

  @Output() voteEvent:EventEmitter<boolean> = new EventEmitter();

  vote(value: boolean) {
    this.voteEvent.emit(value);
  }

}
