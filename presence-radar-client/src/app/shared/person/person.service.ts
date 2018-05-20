import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API } from 'environments/environment';

@Injectable()
export class PersonService {

  public PERSON_API = API + '/persons';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.PERSON_API);
  }

  save(person: any): Observable<any> {
    let result: Observable<Object>;
    if (person['id']) {
      result = this.http.put(this.PERSON_API, person);
    } else {
      result = this.http.post(this.PERSON_API, person);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }

}
