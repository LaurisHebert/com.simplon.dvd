import {ComponentFixture, TestBed} from '@angular/core/testing';
import {MatDialogModule} from '@angular/material/dialog';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {DvdService} from '../../../services/dvd.service';
import {AdminDvdListComponent} from './admin-dvd-list.component';

describe('AdminDvdListComponent', () => {
  let component: AdminDvdListComponent;
  let fixture: ComponentFixture<AdminDvdListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminDvdListComponent],
      providers: [DvdService],
      imports: [MatDialogModule, HttpClientTestingModule],
    });

    fixture = TestBed.createComponent(AdminDvdListComponent);
    component = fixture.componentInstance;
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch DVDs on initialization', () => {
    const dvdService = TestBed.inject(DvdService);

    // Simulate a successful response from the service
    spyOn(dvdService, 'getAllDvds').and.returnValue(Promise.resolve([
      {
        id: 1,
        directedBy: 'Director 1',
        duration: 120,
        filmCover: 'cover1.jpg',
        genre: 'Action',
        isan: 'ISAN001',
        quantity: 5,
        releaseDate: new Date(),
        resume: 'A great movie',
        title: 'Movie 1',
        type: 'DVD'
      },
      {
        id: 2,
        directedBy: 'Director 2',
        duration: 110,
        filmCover: 'cover2.jpg',
        genre: 'Comedy',
        isan: 'ISAN002',
        quantity: 3,
        releaseDate: new Date(),
        resume: 'A funny movie',
        title: 'Movie 2',
        type: 'DVD'
      },
    ]));

    component.ngOnInit();

    fixture.whenStable().then(() => {
      expect(component.dvds.length).toBeGreaterThan(0); // Adjust this expectation as per your data.
    });
  });

  // Add more tests for other component methods, like openEditModal and deleteDvdById.
});
