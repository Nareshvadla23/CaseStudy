import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginrouteComponent } from './loginroute.component';

describe('LoginrouteComponent', () => {
  let component: LoginrouteComponent;
  let fixture: ComponentFixture<LoginrouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginrouteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginrouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
