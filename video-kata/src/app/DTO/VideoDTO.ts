import { ParseErrorLevel } from "@angular/compiler";
import { from } from "rxjs";
import { Level } from "./Level";


export class VideoDTO {
    id: string;
    title: string;
    description: string;
    url: string;
    duration: Number;
    level: Level;
    tags: string[];

}