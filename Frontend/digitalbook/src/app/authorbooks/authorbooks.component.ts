import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authorbooks',
  templateUrl: './authorbooks.component.html',
  styleUrls: ['./authorbooks.component.css']
})
export class AuthorbooksComponent implements OnInit {

  rbooks: any[] = [];

  constructor(public bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {
    let data = localStorage.getItem('value');

    const observable = this.bookservice.getBooksByAuthorMailId(data)
    observable.subscribe((rbooksFromServer: any) => {
      this.rbooks = rbooksFromServer;
    });
 }
  Edit() {
    this.router.navigate(['/editbook']);
  }
}
