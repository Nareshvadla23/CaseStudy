import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorComponent } from './author/author.component';
import { AuthorbooksComponent } from './authorbooks/authorbooks.component';
import { BookListComponent } from './book-list/book-list.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { SignupComponent } from './signup/signup.component';
import { UserbooksComponent } from './userbooks/userbooks.component';

const routes: Routes = [
  { path: 'booklist', component: BookListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'home', component: HomeComponent }, {
    path: 'author', component: AuthorComponent},
  { path: 'createbook', component: CreatebookComponent },
  { path: 'editbook', component: CreatebookComponent },
  { path: 'buybook', component: PaymentComponent },
  {path: 'authorbooks', component: AuthorbooksComponent },
  {path: 'userbooks', component: UserbooksComponent}]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
