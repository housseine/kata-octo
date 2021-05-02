import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransactionDetailsComponent } from './component/transaction/transaction-details/transaction-details.component';
import { VideoComponent } from './component/video/video.component';
import { DisplayComponent } from './component/voter-display/display/display.component';
import { VoterComponent } from './component/voter-display/voter/voter.component';


const routes: Routes = [
  {path:'',component:VideoComponent},
  {path:'tran',component:TransactionDetailsComponent},
  {path:'vote',component:DisplayComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
