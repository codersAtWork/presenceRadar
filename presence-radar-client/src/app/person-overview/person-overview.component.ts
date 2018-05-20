import { Component, OnInit } from '@angular/core';
import { PersonService } from '../shared/person/person.service';
import { Observable } from 'rxjs';
import { Apollo } from 'apollo-angular';
import { Query, Person } from '../types';
import gql from 'graphql-tag';

@Component({
  selector: 'app-person-overview',
  templateUrl: './person-overview.component.html',
  styleUrls: ['./person-overview.component.scss']
})
export class PersonOverviewComponent implements OnInit {

  persons: Person[];
  constructor(private apollo: Apollo) { }

  ngOnInit() {
    this.apollo.watchQuery<Query>({
      query: gql`
        query allPersons {
          allPersons {
            id
            name
          }
        }
      `,
      fetchPolicy: 'network-only'
    }).valueChanges
      . subscribe( response =>
        this.persons = response.data.allPersons
      );
  }
}
