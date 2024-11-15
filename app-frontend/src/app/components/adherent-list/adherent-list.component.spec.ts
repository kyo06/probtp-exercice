import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdherentListComponent } from './adherent-list.component';

describe('AdherentListComponent', () => {
  let component: AdherentListComponent;
  let fixture: ComponentFixture<AdherentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdherentListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdherentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
