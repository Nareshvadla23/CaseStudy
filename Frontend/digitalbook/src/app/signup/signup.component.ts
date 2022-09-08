import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  author = {
    name: "",
    mailId: "",
    password: ""
  }

  constructor(private bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  registerAuthor() {

    console.log(this.author);


    this.bookservice.registerAuthor(this.author).subscribe(data => {

      alert("Login Successfull")
      this.router.navigate(['/author'])
    }, error => alert("Wrong Credentials")

    )


  }

}
