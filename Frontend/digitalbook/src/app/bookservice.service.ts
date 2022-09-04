import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const URL ="http://localhost:8084/"
@Injectable({
  providedIn: 'root'
})
export class BookserviceService {
  save(book: any) {
    return this.http.post(URL + "createbook", book);
  }

  getbooks() {
    return this.http.get(URL+"allbooks")
  }
  constructor(public http: HttpClient) { }
}
