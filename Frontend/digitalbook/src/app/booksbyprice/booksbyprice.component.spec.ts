import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksbypriceComponent } from './booksbyprice.component';

describe('BooksbypriceComponent', () => {
  let component: BooksbypriceComponent;
  let fixture: ComponentFixture<BooksbypriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BooksbypriceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BooksbypriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
