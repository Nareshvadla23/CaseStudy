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

  searchType = {
    "author": "",
    "category": "",
    "title": "",
    "price": ""

  }

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

  booksByAuthor() {

    if (this.searchType.author == "") {
      alert("Please enter author name")
    }
    else {
      const observable = this.bookservice.getBooksByAuthor(this.searchType.author);
      observable.subscribe((booksFromServer: any) => {
        this.rbooks = booksFromServer;
      });
    }
  }
  booksByCategory() {
    if (this.searchType.category == "") {
      alert("Please enter category type")
    }
    else {
      const observable = this.bookservice.getBooksByCategory(this.searchType.category)
      observable.subscribe((booksFromServer: any) => {
        this.rbooks = booksFromServer;
      });
    }
  }
  booksByPrice() {
    if (this.searchType.price == "") {
      alert("Please enter amount details")
    }
    else {
      const observable = this.bookservice.getBooksByPrice(this.searchType.price)
      observable.subscribe((booksFromServer: any) => {
        this.rbooks = booksFromServer;
      });
    }
  }




}




function rbooksFromServer(rbooksFromServer: any, any: any) {
  throw new Error('Function not implemented.');
}

