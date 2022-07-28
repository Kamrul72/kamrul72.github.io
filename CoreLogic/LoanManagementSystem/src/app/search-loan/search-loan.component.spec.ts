import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchLoanComponent } from './search-loan.component';

describe('SearchLoanComponent', () => {
  let component: SearchLoanComponent;
  let fixture: ComponentFixture<SearchLoanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchLoanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
