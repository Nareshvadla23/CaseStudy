import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rbook',
  templateUrl: './rbook.component.html',
  styleUrls: ['./rbook.component.css']
})
export class RbookComponent implements OnInit {

  rbook = {

    author: "",
    title: "",
    category: "",
    publisher: "",
    publisherdate: Date,
    price: "",
    image: ""

  }

  rbooks : any[]=[];

  constructor() { }

  ngOnInit(): void {
  }

}
