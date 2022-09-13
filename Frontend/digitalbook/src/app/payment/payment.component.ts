import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Buybook } from '../buybook';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  buyBook : Buybook = new Buybook();

  constructor(private bookservice :BookserviceService) { }

  ngOnInit(): void {
  }
  buyBooks()
  {
    this.buyBook.paymentDate= new Date(this.buyBook.paymentDate);
    this.bookservice.buyBook(this.buyBook).subscribe(data => {
      alert("payment has done sucessfull")
    }, error => alert("payment has not done, please try once again")
    )
  }
}
