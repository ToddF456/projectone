import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemSaveComponent } from './item-save.component';

describe('ItemSaveComponent', () => {
  let component: ItemSaveComponent;
  let fixture: ComponentFixture<ItemSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemSaveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
