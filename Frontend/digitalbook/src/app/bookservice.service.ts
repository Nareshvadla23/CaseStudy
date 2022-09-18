import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthorLogin } from './author-login';
import { Observable } from 'rxjs';
import { SignupComponent } from './signup/signup.component';
import { Buybook } from './buybook';
import { Book } from './book';
const URL = "http://localhost:8084/digitalbooks/"
const getURL = "https://4fgesl7lk3.execute-api.us-west-2.amazonaws.com/prod"
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

  loginAuthor(authorlogin: AuthorLogin): Observable<object> {
    return this.http.post(URL + "login", authorlogin);
  }
  registerAuthor(author: any): Observable<object> {
    return this.http.post(URL + "author", author);
  }
  buyBook(buyBook: Buybook): Observable<object> {
    return this.http.post(URL + "buy", buyBook)
  }

  updateBook(book: Book): Observable<object> {
    return this.http.put(URL + "book/" + book.id, book)
  }

  refund(user: any): Observable<object> {
    return this.http.get(URL + "refund/" + user.bookId + "/mail/" + user.mailId)
  }

  getBooksByAuthorId() {
    return this.http.get(URL + "ByAuthorId/8");
  }
  getBooksByUserMailId(mailId: any,paymentId:any) {
    return this.http.get(URL + "books/byMailId/" + mailId + "/paymentId/" + paymentId);
  }
  getBooksByPaymentId(paymentId: any) {
    return this.http.get(URL + "books/byPaymentId/" + paymentId);
  }
  getBooksByAuthor(author: any) {
    return this.http.get(URL + "books/byAuthor/" + author);
  }
  getBooksByCategory(category: any) {
    return this.http.get(URL + "books/byCategory/" + category)
  }
  getBooksByPrice(price: any) {
    return this.http.get(URL + "books/byPrice/" + price)
  }
  getBookById(update: any) {
    return this.http.get(URL + "ByBookId/" + update.id + "/mail/" + update.mail)
  }

  getBooksByAuthorMailId(mailId: any) {
    return this.http.get(URL + "ByAuthorMailId/" + mailId);
  }













}
