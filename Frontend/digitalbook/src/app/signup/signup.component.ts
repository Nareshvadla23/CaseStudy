import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'signup',
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
    if(this.author.name=="" || this.author.name.trim()=="")
    {
      alert("Please enter userName");
    }
    else if (this.author.mailId=="" || this.author.mailId.trim()=="")
    {
      alert("Please enter userMail");
    }
    else if (this.author.password==""|| this.author.password.trim()=="")
    {
      alert("Please enter password");
    }
    else{
    this.bookservice.registerAuthor(this.author).subscribe(data => {
      alert("Registration Successfull")
      this.router.navigate(['/author'])
    }, error => alert("User Mail already exist please try with another ")
    )
  }
  }
}
