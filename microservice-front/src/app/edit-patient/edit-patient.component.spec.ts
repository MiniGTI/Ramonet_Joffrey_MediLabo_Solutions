import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPatientComponent } from './edit-patient.component';

describe('EditComponent', () => {
  let component: EditPatientComponent;
  let fixture: ComponentFixture<EditPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditPatientComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
