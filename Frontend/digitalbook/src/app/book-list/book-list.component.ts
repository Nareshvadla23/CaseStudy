import { Component, OnInit } from '@angular/core';
import { Responsebook } from '../responsebook';
import { BookserviceService } from '../bookservice.service';
import { RbookComponent } from '../rbook/rbook.component';
import { Buybook } from '../buybook';
import { Router } from '@angular/router';


@Component({
  selector: 'book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  rbooks: any[] = [];

  constructor(public bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {

    const observable = this.bookservice.getbooks();
    observable.subscribe((rbooksFromServer: any) => {
      this.rbooks = rbooksFromServer;
    });
 }
  Buy() {
    this.router.navigate(['/buybook']);
  }




}




function rbooksFromServer(rbooksFromServer: any, any: any) {
  throw new Error('Function not implemented.');
}

