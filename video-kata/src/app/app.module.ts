import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { VideoComponent } from './component/video/video.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatChipsModule, MatIconModule, MatInputModule, MatListModule, MatOptionModule, MatSelectModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TransactionDetailsComponent } from './component/transaction/transaction-details/transaction-details.component';
import { DisplayComponent } from './component/voter-display/display/display.component';
import { VoterComponent } from './component/voter-display/voter/voter.component';

@NgModule({
  declarations: [
    AppComponent,
    VideoComponent,
    TransactionDetailsComponent,
    DisplayComponent,
    VoterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatChipsModule,
    MatIconModule,
    MatOptionModule,
    MatSelectModule,
    FormsModule,
    HttpClientModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
