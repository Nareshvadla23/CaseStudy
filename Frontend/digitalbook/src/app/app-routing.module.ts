import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [{ path: 'createbook', component: CreatebookComponent },
{ path: 'booklist', component: BookListComponent },
{ path: 'login', component: LoginComponent},
{ path: 'signup', component: SignupComponent },
 {path: 'home', component: HomeComponent }];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
