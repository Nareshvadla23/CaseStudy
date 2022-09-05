import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const URL ="http://localhost:8084/"
@Injectable({
  providedIn: 'root'
})
export class BookserviceService {
  save(book: any) {
    return this.http.post(URL + "addbook", book);
  }

  getbooks() {
    return this.http.get(URL+"books/all")
  }
  constructor(public http: HttpClient) { }
}
