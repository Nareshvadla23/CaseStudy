import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookserviceService } from '../bookservice.service';
import { Buybook } from '../buybook';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  buyBook: Buybook = new Buybook();

  constructor(private bookservice: BookserviceService,private router:Router) { }

  ngOnInit(): void {
    this.buyBook.title="RDPD"
  }
  buyBooks() {
    if (this.buyBook.title == null) {
      alert("Please provide the title")
    }
    else if (this.buyBook.name==null) {
      alert("Please provide the user name")
    }
    else if (this.buyBook.mailId==null) {
      alert("Please provide the user mail")
    }
    else if (this.buyBook.paymentMode==null) {
      alert("Please provide the paymentmode")
    }
    else if (this.buyBook.paymentDate==null) {
      alert("please provide the paymentdate")
    }
    else {
      this.buyBook.paymentDate = new Date(this.buyBook.paymentDate);
      this.bookservice.buyBook(this.buyBook).subscribe(data => {
        alert("payment has done sucessfull")
        this.router.navigate(["/booklist"])
      
      }, error => alert("payment has not done, please try once again")
      )
    }
  }
}
