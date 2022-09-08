import { Component, OnInit } from '@angular/core';
import { AuthorLogin } from '../author-login';
import { AuthorComponent } from '../author/author.component';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  authorlogin: AuthorLogin = new AuthorLogin

  constructor(private bookserice: BookserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  loginAuthor() {

    console.log(this.authorlogin)
    this.bookserice.loginAuthor(this.authorlogin).subscribe(data => {

      alert("Login Successfull")
      this.router.navigate(['/author'])
    }, error => alert("Wrong Credentials")

    )

  }


}
