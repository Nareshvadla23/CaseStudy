import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Bookcontent } from '../bookcontent';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  books:Bookcontent[]=[];

  refund={
     id: "",
     refundStatus:""
  }

  input = {
    mailId: "",
    paymentId: ""
  }

  constructor(public bookservice: BookserviceService, private router:Router) { }

  ngOnInit(): void {
  }

  bookByMailId() {
    console.log(this.input.mailId);
    const observable = this.bookservice.getBooksByUserMailId(this.input.mailId);
    observable.subscribe((booksFromServer: any) => {
      console.log(observable)
      this.books = booksFromServer;
    });
  }
  bookByPaymentId() {
    console.log(this.input.paymentId)
    const observable = this.bookservice.getBooksByPaymentId(this.input.paymentId)
    observable.subscribe((booksFromServer: any) => {
      this.books = booksFromServer;
    });
  }
  refundByPaymentId()
  {
    const observable = this.bookservice.refund(this.input.paymentId)
    observable.subscribe((refundFromServer: any) => {
      this.refund = refundFromServer;
    });
  }
}
