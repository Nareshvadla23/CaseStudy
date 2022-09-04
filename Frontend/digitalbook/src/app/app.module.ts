import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserformComponent } from './userform/userform.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookListComponent } from './book-list/book-list.component';
import { RbookComponent } from './rbook/rbook.component';
import { RouterModule, Routes } from '@angular/router';

const routes : Routes =[{path : 'createbook',component: CreatebookComponent},
{path : 'booklist',component:BookListComponent}]

@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    CreatebookComponent,
    BookListComponent,
    RbookComponent,
  
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
