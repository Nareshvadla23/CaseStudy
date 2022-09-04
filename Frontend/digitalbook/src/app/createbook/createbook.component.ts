import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';

@Component({
  selector: 'createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent implements OnInit {

  book = {
    image: "",
    author: "",
    title: "",
    category: "",
    publisher: "",
    publisherdate: new Date,
    price: "",
    content: "",
    status: ""

  }
  books: any[] = [];
  constructor(public bookservice: BookserviceService) { }

  saveBook() {

    const observable = this.bookservice.save(this.book);
    observable.subscribe((responseBody: any) => {
      console.log(responseBody);
      this.books.push(responseBody);
    },
      (error: any) => {
        console.log(error);
      }
    );
  }
  ngOnInit(): void {
  }

}
