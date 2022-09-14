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
    if(this.author.mailId=="")
    {
      alert("Please enter userName");
    }
    else if (this.author.name=="")
    {
      alert("Please enter userMail");
    }
    else if (this.author.password=="")
    {
      alert("Please enter password");
    }
    else{
    this.bookservice.registerAuthor(this.author).subscribe(data => {
      alert("Registration Successfull")
      this.router.navigate(['/author'])
    }, error => alert("Registration not sucessfull please provide correct details")
    )
  }
  }
}
