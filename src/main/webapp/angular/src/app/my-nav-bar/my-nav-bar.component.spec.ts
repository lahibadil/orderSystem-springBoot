import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyNavBarComponent } from './my-nav-bar.component';

describe('MyNavBarComponent', () => {
  let component: MyNavBarComponent;
  let fixture: ComponentFixture<MyNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
