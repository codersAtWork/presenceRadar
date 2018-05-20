import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PersonOverviewComponent } from './person-overview/person-overview.component';
import { PersonService } from './shared/person/person.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonOverviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
