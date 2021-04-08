import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { VideoDTO } from '../DTO/VideoDTO';
import { MessageService } from './message.service';
const BASE_API_URL = environment.ENDPOINT_ROOT_URL;
@Injectable({
  providedIn: 'root'
})
export class VideoService {
  private videotUrl = BASE_API_URL + '/api/v1/videos';
  constructor(
    private http: HttpClient,
    private messageService: MessageService
    ) { }

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    withCredentials: true
  };

  searchVideos(level: string,tags:string[]): Observable<VideoDTO[]> {
    var urltags:String="";
    if (level==undefined) level="";
    if(tags==undefined|| tags.length==0){
      urltags=""
    }else{
      tags.forEach(tag=>{urltags=urltags+"tags="+tag+"&"});
    }
    console.log(urltags);
    return this.http.get<VideoDTO[]>(`${this.videotUrl}?level=${level}&${urltags}`,this.httpOptions).pipe(
      tap(_ => this.log(`found objects matching "${level}" and "${tags}"`)),
      catchError(this.handleError<VideoDTO[]>('searchObjects', []))
    );
  }


  private log(message: string) {
    this.messageService.add(message);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    }
  };

  handleErrors(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}

