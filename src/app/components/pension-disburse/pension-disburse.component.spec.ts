import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PensionDisburseComponent } from './pension-disburse.component';

describe('PensionDisburseComponent', () => {
  let component: PensionDisburseComponent;
  let fixture: ComponentFixture<PensionDisburseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PensionDisburseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PensionDisburseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
