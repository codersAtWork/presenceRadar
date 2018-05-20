import { Component, OnInit } from '@angular/core';
import { TokenService } from '../shared/token/token.service';

@Component({
  selector: 'app-token-overview',
  templateUrl: './token-overview.component.html',
  styleUrls: ['./token-overview.component.scss']
})
export class TokenOverviewComponent implements OnInit {

  tokens: Array<any>

  constructor(private tokenService: TokenService) { }

  ngOnInit() {
    this.tokenService.getAll().subscribe(data => {
      this.tokens = data;
    });
  }

}
