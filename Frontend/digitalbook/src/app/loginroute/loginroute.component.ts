import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

@Component({
  selector: 'app-loginroute',
  templateUrl: './loginroute.component.html',
  styleUrls: ['./loginroute.component.css']
})
export class LoginrouteComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {

    let data = localStorage.getItem('value');

    if (data) {

      this.router.navigate(['/author'])
    }
    else {
      this.router.navigate(['/login']);
    }

  }

}
