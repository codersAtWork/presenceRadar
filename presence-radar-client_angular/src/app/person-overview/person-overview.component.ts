import { Component, OnInit } from '@angular/core';
import { PersonService } from '../shared/person/person.service';

@Component({
  selector: 'app-person-overview',
  templateUrl: './person-overview.component.html',
  styleUrls: ['./person-overview.component.css']
})
export class PersonOverviewComponent implements OnInit {

  persons: Array<any>;

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.getAll().subscribe(data => {
      this.persons = data;
    });
  }

}
