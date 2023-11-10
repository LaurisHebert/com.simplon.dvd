import {ComponentFixture, fakeAsync, TestBed, tick} from '@angular/core/testing';
import {MatDialog} from '@angular/material/dialog';
import {DvdService} from '../../../services/dvd.service';
import {AdminDvdListComponent} from './admin-dvd-list.component';
import {Dvd} from "../../../interface/dvd";
import {of} from "rxjs";

describe('AdminDvdListComponent', () => {
    let component: AdminDvdListComponent;
    let fixture: ComponentFixture<AdminDvdListComponent>;
    let dvdService: jasmine.SpyObj<DvdService>;
    let dialog: jasmine.SpyObj<MatDialog>;

    let mockDvds: Dvd[] = [{
        id: 1, directedBy: 'Director', duration: 120, filmCover: 'cover.jpg', genre: 'Action', isan: 'ISAN123', quantity: 5, releaseDate: new Date(), resume: 'A movie', title: 'Movie', type: 'DVD',
    }, {
        id: 2, directedBy: 'Director', duration: 120, filmCover: 'cover.jpg', genre: 'Action', isan: 'ISAN123', quantity: 5, releaseDate: new Date(), resume: 'A movie', title: 'Movie', type: 'DVD',
    }]

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [AdminDvdListComponent], providers: [{
                provide: DvdService, useValue: jasmine.createSpyObj('DvdService', ['getAllDvds', 'deleteDvdById'])
            }, {provide: MatDialog, useValue: jasmine.createSpyObj('MatDialog', ['open'])}]
        });

        fixture = TestBed.createComponent(AdminDvdListComponent);
        component = fixture.componentInstance;
        dvdService = TestBed.inject(DvdService) as jasmine.SpyObj<DvdService>;
        dialog = TestBed.inject(MatDialog) as jasmine.SpyObj<MatDialog>;

    });


    it('should create the component', () => {
        expect(component).toBeTruthy();
    });

    it('should fetch DVDs on initialization', fakeAsync(() => {

        dvdService.getAllDvds.and.returnValue(Promise.resolve(mockDvds));

        component.ngOnInit();

        tick();

        fixture.detectChanges();

        expect(component.dvds).toEqual(mockDvds);
        expect(dvdService.getAllDvds).toHaveBeenCalled();
    }));

    it('should delete a DVD', fakeAsync(() => {
        dvdService.getAllDvds.and.returnValue(Promise.resolve(mockDvds));
        dvdService.deleteDvdById.and.returnValue(Promise.resolve());

        component.ngOnInit()
        tick()
        fixture.detectChanges()

        const dvd = mockDvds[0]
        component.deleteDvdById(dvd)
        tick()

        expect(dvdService.deleteDvdById).toHaveBeenCalledWith(dvd.id)

        const indexInDvds = component.dvds.findIndex(item => item.id === dvd.id);
        expect(indexInDvds).toBe(-1);

    }));

    it ('should open the edit modal', fakeAsync(() => {
        const dvdToEdit : Dvd = mockDvds[0]

        const dialogRefSpyObj = jasmine.createSpyObj({
            afterClosed : of()
        })

    }))


});
