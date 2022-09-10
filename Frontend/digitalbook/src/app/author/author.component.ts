import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  addBook() {
    this.router.navigate(['/createbook']);
  }


}
