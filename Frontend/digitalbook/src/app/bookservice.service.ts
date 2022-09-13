import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthorLogin } from './author-login';
import { Observable } from 'rxjs';
import { SignupComponent } from './signup/signup.component';
import { Buybook } from './buybook';
const URL ="http://localhost:8084/"
@Injectable({
  providedIn: 'root'
})
export class BookserviceService {
  save(book: any) {
    return this.http.post(URL + "book", book);
  }

  getbooks() {
    return this.http.get(URL+"books/all")
  }
  constructor(public http: HttpClient) { }

   loginAuthor(authorlogin :AuthorLogin):Observable<object>{
     return this.http.post(URL+"login",authorlogin);
   }
 
   registerAuthor(author : any):Observable<object>{
     return this.http.post(URL+"author",author);
   }

   buyBook(buyBook:Buybook):Observable<object>{
     return this.http.post(URL+"buy",buyBook)
   }

   getBooksByAuthorId()
   {
     return this.http.get(URL+"ByAuthorId/8");
   }

   getBooksByUserMailId()
   {
     return this.http.get(URL+"books/byMailId/virat@gmail.com");
   }
   

}
