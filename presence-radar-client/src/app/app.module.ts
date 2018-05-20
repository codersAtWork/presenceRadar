import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ClarityModule } from '@clr/angular';
import { AppComponent } from './app.component';
import { ROUTING } from "./app.routing";
import { AboutComponent } from "./about/about.component";
import { PersonOverviewComponent } from './person-overview/person-overview.component';
import { PersonService } from "./shared/person/person.service";
import { HttpClientModule } from "@angular/common/http";
import { PersonEditComponent } from './person-edit/person-edit.component';
import { ApolloModule, Apollo } from 'apollo-angular';
import { HttpLinkModule, HttpLink } from 'apollo-angular-link-http';
import { InMemoryCache } from 'apollo-cache-inmemory';
import { SettingsComponent } from './settings/settings.component';
import { TokenOverviewComponent } from './token-overview/token-overview.component';
import { LogsComponent } from './logs/logs.component';
import { TokenService } from "./shared/token/token.service";
import { TokenEditComponent } from './token-edit/token-edit.component';

@NgModule({
    declarations: [
        AppComponent,
        AboutComponent,
        PersonOverviewComponent,
        PersonEditComponent,
        SettingsComponent,
        TokenOverviewComponent,
        LogsComponent,
        TokenEditComponent
    ],
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        FormsModule,
        HttpClientModule,
        ClarityModule,
        ROUTING,
        ApolloModule,
        HttpLinkModule
    ],
    providers: [PersonService, TokenService],
    bootstrap: [AppComponent]
})
export class AppModule {
    constructor(apollo: Apollo, httpLink: HttpLink) {
      apollo.create({
        link: httpLink.create({uri: 'http://localhost:8080/graphql'}),
        cache: new InMemoryCache()
      });
    }
  }
