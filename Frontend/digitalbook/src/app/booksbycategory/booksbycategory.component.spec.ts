import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksbycategoryComponent } from './booksbycategory.component';

describe('BooksbycategoryComponent', () => {
  let component: BooksbycategoryComponent;
  let fixture: ComponentFixture<BooksbycategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksbycategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BooksbycategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
