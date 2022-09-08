import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookListComponent } from './book-list/book-list.component';
import { RbookComponent } from './rbook/rbook.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AuthorComponent } from './author/author.component';
import { BooksbypriceComponent } from './booksbyprice/booksbyprice.component';
import { BooksbyauthorComponent } from './booksbyauthor/booksbyauthor.component';
import { BooksbycategoryComponent } from './booksbycategory/booksbycategory.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const routes: Routes = [{ path: 'createbook', component: CreatebookComponent },
{ path: 'booklist', component: BookListComponent }]

@NgModule({
  declarations: [
    AppComponent,
    CreatebookComponent,
    BookListComponent,
    RbookComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    AuthorComponent,
    BooksbypriceComponent,
    BooksbyauthorComponent,
    BooksbycategoryComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
