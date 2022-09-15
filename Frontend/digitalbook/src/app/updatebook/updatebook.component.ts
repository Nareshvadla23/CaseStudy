import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookserviceService } from '../bookservice.service';

@Component({
  selector: 'app-updatebook',
  templateUrl: './updatebook.component.html',
  styleUrls: ['./updatebook.component.css']
})
export class UpdatebookComponent implements OnInit {

  book: Book = new Book();

  constructor(private bookservice: BookserviceService) { }

  ngOnInit(): void {
  }
  saveBook() {

    if (this.book.title == "") {
      alert("please provide the title of the book")
    }
    else if (this.book.author == "") {
      alert("please provide the author name")
    }
    else if (this.book.category == "") {
      alert("please provide the category type")
    }
    else if (this.book.publisher == "") {
      alert("please provide the publisher name")
    }
    else if (this.book.publishedDate == null) {
      alert("please provide the published date")
    }
    else if (this.book.price == null) {
      alert("please provide the price of the book")
    }
    else if (this.book.content == "") {
      alert("please provide the content of the book")
    }
    else if (this.book.status == "") {
      alert("please provide the status of the book")
    }
    else {

      this.book.publishedDate = new Date(this.book.publishedDate);
      const observable = this.bookservice.save(this.book);
      observable.subscribe((responseBody: any) => {
        alert("Book Added Successfully..!!")
        console.log(responseBody);

      },
        (error: any) => {
          alert("Book not added please try once again..!!")
          console.log(error);
        }
      );
    }
  }
  getBook() {
    const observable = this.bookservice.getBookById(this.book.id).
      subscribe((booksFromServer: any) => {
        this.book = booksFromServer;
      });
  }
  updateBook()
  {
    this.book.publishedDate = new Date(this.book.publishedDate);
      const observable = this.bookservice.updateBook(this.book)
      observable.subscribe((responseBody: any) => {
        alert("Book Added Successfully..!!")
        console.log(responseBody);

      },
        (error: any) => {
          alert("Book not added please try once again..!!")
          console.log(error);
        }
      );
  }
}
