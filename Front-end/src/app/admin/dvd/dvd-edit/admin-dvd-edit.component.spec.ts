import {ComponentFixture, TestBed, waitForAsync} from '@angular/core/testing';
import {MAT_DIALOG_DATA, MatDialogModule} from '@angular/material/dialog';
import {AdminDvdEditComponent} from './admin-dvd-edit.component';
import {DvdService} from '../../../services/dvd.service';

describe('AdminDvdEditComponent', () => {
  let component: AdminDvdEditComponent;
  let fixture: ComponentFixture<AdminDvdEditComponent>;
  let dvdService: DvdService;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [AdminDvdEditComponent],
      providers: [
        DvdService,
        {provide: MAT_DIALOG_DATA, useValue: {}}, // You can provide mock data here
      ],
      imports: [MatDialogModule],
    }).compileComponents();

    fixture = TestBed.createComponent(AdminDvdEditComponent);
    component = fixture.componentInstance;
    dvdService = TestBed.inject(DvdService);
  }));

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize dvd data from MAT_DIALOG_DATA', () => {
    const mockDvdData = {
      id: 1,
      directedBy: 'Director',
      duration: 120,
      filmCover: 'cover.jpg',
      genre: 'Action',
      isan: 'ISAN123',
      quantity: 5,
      releaseDate: new Date(),
      resume: 'A movie',
      title: 'Movie',
      type: 'DVD',
    };
    component.ngOnInit();

    expect(component.dvd).toEqual(mockDvdData);
  });

  it('should update DVD', () => {
    spyOn(dvdService, 'updateDvd').and.returnValue(Promise.resolve('Success'));

    component.dvd = {
      id: 1,
      directedBy: 'Director',
      duration: 120,
      filmCover: 'cover.jpg',
      genre: 'Action',
      isan: 'ISAN123',
      quantity: 5,
      releaseDate: new Date(),
      resume: 'A movie',
      title: 'Movie',
      type: 'DVD',
    };

    component.updateDvd();

    fixture.detectChanges(); // Detect changes to resolve the promise

    fixture.whenStable().then(() => {
      expect(console.log).toHaveBeenCalledWith('lala'); // Check if the updateDvd method logs 'lala'
    });
  });
});
