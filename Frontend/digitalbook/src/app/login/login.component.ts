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
    if (this.authorlogin.mailId == null || this.authorlogin.mailId.trim() == "") {
      alert("Please Enter Mail Address")
    }
    else if (this.authorlogin.password == null || this.authorlogin.password.trim() == "") {
      alert("Please Enter password")
    }
    else {
      this.bookserice.loginAuthor(this.authorlogin).subscribe(data => {

        alert("Login Successfull")
        localStorage.setItem('value', this.authorlogin.mailId)
        this.router.navigate(['/author'])
      }, error => alert("Wrong Credentials")

      )
    }

  }
}



