import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router
 } from '@angular/router';

@Component({
  selector: 'app-userbooks',
  templateUrl: './userbooks.component.html',
  styleUrls: ['./userbooks.component.css']
})
export class UserbooksComponent implements OnInit {

  rbooks: any[] = [];

  constructor(public bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {

    const observable = this.bookservice.getBooksByAuthorId();
    observable.subscribe((rbooksFromServer: any) => {
      this.rbooks = rbooksFromServer;
    });
 }

}
