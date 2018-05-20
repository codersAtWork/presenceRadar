import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenService } from '../shared/token/token.service';
import { NgForm } from '@angular/forms';
import { PersonService } from '../shared/person/person.service';

@Component({
  selector: 'app-token-edit',
  templateUrl: './token-edit.component.html',
  styleUrls: ['./token-edit.component.scss']
})
export class TokenEditComponent implements OnInit {

  token: any = {};
  persons: Array<any>;

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private tokenService: TokenService,
              private personService: PersonService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.tokenService.get(id).subscribe((token: any) => {
          if (token) {
            this.token = token;
            this.token.href = token._links.self.href;
          } else {
            console.log(`'Token' with id '${id}' not found, returning to overview`);
            this.gotoList();
          }
        });
      }

      this.personService.getAll().subscribe(data => {
        this.persons = data;
      });
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/tokens']);
  }

  save(form: NgForm) {
    this.tokenService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.tokenService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
