import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

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
    publishedDate: new Date(),
    price: "",
    content: "",
    status: ""

  }

  books: any[] = [];
  constructor(public bookservice: BookserviceService, private router: Router) { }

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
    else if (this.book.price == "") {
      alert("please provide the price of the book")
    }
    else if (this.book.content == "") {
      alert("please provide the content of the book")
    }
    else if (this.book.status == "") {
      alert("please provide the status of the book")
    }
    else {
      let image1 = this.book.image.split('/');
      this.book.image = image1[image1.length - 1]
      this.book.publishedDate = new Date(this.book.publishedDate);
      const observable = this.bookservice.save(this.book);
      observable.subscribe((responseBody: any) => {
        alert("Book Added Successfully..!!")
        this.router.navigate(['/author'])
        this.books.push(responseBody);
      },
        (error: any) => {
          alert("Book not added please try once again..!!")
          console.log(error);
        }
      );
    }
  }
  ngOnInit(): void {
  
  }

}

