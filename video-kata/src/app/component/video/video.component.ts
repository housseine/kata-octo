import { Component, OnInit } from '@angular/core';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatChipInputEvent} from '@angular/material/chips';
import {Level} from '../../DTO/Level'
import { VideoService } from 'src/app/service/video.service';
import { VideoDTO } from 'src/app/DTO/VideoDTO';

export interface Tag {
  name: string;
}

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})


export class VideoComponent implements OnInit {
  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true; 
  selectedLevel:string;
  videoDTOs:VideoDTO[];
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  tags: string[] = [
     'POURCENTAGE',

  ];
  levels: string[]=['','EASY','ELEMENTARY','HARD','MEDIUM']
  
  constructor(private videoService:VideoService) { }

  ngOnInit() {
  
  }
  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    if ((value || '').trim()) {
      this.tags.push( value.trim());
    }

    if (input) {
      input.value = '';
    }
  }

  remove(tag: string): void {
    const index = this.tags.indexOf(tag);

    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }
  save(){
    this.videoService.searchVideos(this.selectedLevel,this.tags).subscribe(videos=>this.videoDTOs=videos);
  }


}
