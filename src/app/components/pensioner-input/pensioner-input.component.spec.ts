import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PensionerInputComponent } from './pensioner-input.component';

describe('PensionerInputComponent', () => {
  let component: PensionerInputComponent;
  let fixture: ComponentFixture<PensionerInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PensionerInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PensionerInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
