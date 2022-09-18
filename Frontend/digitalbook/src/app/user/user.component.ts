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

  books: Bookcontent = new Bookcontent();

  refund = {
    bookId: "",
    mailId: ""
  }
  refundstatus = {
    refundStatus: "",
    purchaseDate: ""
  }

  input = {
    mailId: "",
    paymentId: ""
  }

  constructor(public bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  bookByMailId() {

    localStorage.setItem('usermail', this.input.mailId)
    localStorage.setItem('paymentId', this.input.paymentId)

    this.router.navigate(['/userbooks'])

  }
  refundByPaymentId() {
    const observable = this.bookservice.refund(this.refund)
    observable.subscribe((refundFromServer: any) => {
      this.refundstatus = refundFromServer;
      alert(this.refundstatus.refundStatus)
    }, error => alert("Please provide correct mailId or BookId ")
       
    );
  }
}
