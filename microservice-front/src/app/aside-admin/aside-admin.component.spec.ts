import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsideAdminComponent } from './aside-admin.component';

describe('AsideAdminComponent', () => {
  let component: AsideAdminComponent;
  let fixture: ComponentFixture<AsideAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AsideAdminComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AsideAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
