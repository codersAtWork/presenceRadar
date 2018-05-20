import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription, Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../shared/person/person.service';
import { NgForm } from '@angular/forms';
import { Apollo } from 'apollo-angular';
import { Query, Person } from '../types';
import gql from 'graphql-tag';
import { API } from 'environments/environment';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-person-edit',
  templateUrl: './person-edit.component.html',
  styleUrls: ['./person-edit.component.scss']
})
export class PersonEditComponent implements OnInit, OnDestroy{

  public PERSON_API = API + '/persons';

  person: Person;

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private personService: PersonService,
              private apollo: Apollo,
              private http: HttpClient) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];

      if (id) {
        this.apollo.watchQuery<Query>({
          query: gql`
            query person($id: ID!) {
              person(id: $id) {
                id
                name
                tokens {
                  name
                  active
                }
              }
            }
          `,
          variables: {
            id: id
          }
        }).valueChanges
          .subscribe( response => 
            this.person = response.data.person
          );
      } else {
        this.person = new Person();
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/persons']);
  }

  save(person: Person) {

    let result: Observable<Object>;
    if (person['id']) {
      result = this.http.put(this.PERSON_API, person);
    } else {
      result = this.http.post(this.PERSON_API, person);
    }
    result.subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(id) {
    return this.http.delete(this.PERSON_API + '/' + id).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
