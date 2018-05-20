import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  public API = '//localhost:8080';
  public TOKEN_API = this.API + '/tokens';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.TOKEN_API + '-list');
  }

  get(id: string) {
    return this.http.get(this.TOKEN_API + '/' + id);
  }

  save(token: any): Observable<any> {
    let result: Observable<Object>;
    if (token['href']) {
      result = this.http.put(token.href, token);
    } else {
      result = this.http.post(this.TOKEN_API, token);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
