import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import {
  Router
} from '@angular/router';
import { Bookcontent } from '../bookcontent';

@Component({
  selector: 'app-userbooks',
  templateUrl: './userbooks.component.html',
  styleUrls: ['./userbooks.component.css']
})
export class UserbooksComponent implements OnInit {


  rbook: Bookcontent= new Bookcontent();
  input = {
    mailId: "",
    paymentId: ""
  }


  constructor(public bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {
    let mailId = localStorage.getItem('usermail');
    console.log(mailId)
    let paymentId = localStorage.getItem('paymentId');
    const observable = this.bookservice.getBooksByUserMailId(mailId,paymentId).
      subscribe((booksFromServer: any) => {
        console.log("hello")
        this.rbook = booksFromServer;
      }, (error: any) => {
        alert("Please provide correct Mail Id or BookId")
         this.router.navigate(['/user'])
      }
      );

  }


}
