package com.simplon.dvdStore.services;

import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import com.simplon.dvdStore.enums.Genre;
import com.simplon.dvdStore.enums.Type;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.repositories.DvdRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DvdServiceTest {

    @InjectMocks
    private DvdService dvdService;

    @Mock
    private DvdRepository repository;

    @Test
    void save() {
        DvdServiceModel dvdServiceModel = createDvdServiceModel();
        DvdRepositoryModelSQL dvdRepositoryModelSQL = DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel);

        when(repository.save(any())).thenReturn(dvdRepositoryModelSQL);

        boolean result = dvdService.save(dvdServiceModel);

        assert (result);
        verify(repository, times(1)).save(any());
    }

    @Test
    void update() {
        DvdServiceModel dvdServiceModel = createDvdServiceModel();
        DvdRepositoryModelSQL dvdRepositoryModelSQL = DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel);

        when(repository.save(any())).thenReturn(dvdRepositoryModelSQL);

        boolean result = dvdService.update(dvdServiceModel, 1);
        assert (result);
        verify(repository, times(1)).save(any());
    }

    @Test
    void findById() {
        List<DvdRepositoryModelSQL> dvdRepositoryModelSQLList = createDvdRepositoryModelSQLList();
        when(repository.findAll()).thenReturn(dvdRepositoryModelSQLList);

        List<DvdServiceModel> result = dvdService.findAll();

        assertNotNull(result);
        assertEquals(dvdRepositoryModelSQLList.size(), result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findAll() {
        List<DvdRepositoryModelSQL> dvdRepositoryModelSQLList = createDvdRepositoryModelSQLList();
        when(repository.findAll()).thenReturn(dvdRepositoryModelSQLList);

        List<DvdServiceModel> result = dvdService.findAll();

        assertNotNull(result);
        assertEquals(dvdRepositoryModelSQLList.size(), result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deleteById() {
        int id = 1;

        assertTrue(dvdService.deleteById(id));
        verify(repository, times(1)).deleteById(id);
    }

    private DvdServiceModel createDvdServiceModel() {
        DvdServiceModel dvdServiceModel = new DvdServiceModel();
        dvdServiceModel.setIsan("ISAN123");
        dvdServiceModel.setTitle("Sample Title");
        dvdServiceModel.setDirectedBy("Sample Director");
        dvdServiceModel.setDuration(120);
        dvdServiceModel.setQuantity(10);
        dvdServiceModel.setResume("Sample Resume");
        dvdServiceModel.setFilmCover("sample_cover.jpg");
        dvdServiceModel.setReleaseDate(LocalDate.of(2022, 1, 1));
        dvdServiceModel.setType(Type.MOVIE);
        dvdServiceModel.setGenre(Genre.ACTION);
        return dvdServiceModel;
    }

    private DvdRepositoryModelSQL createDvdRepositoryModelSQL() {
        DvdRepositoryModelSQL dvdRepositoryModelSQL = new DvdRepositoryModelSQL();
        dvdRepositoryModelSQL.setId(1);
        dvdRepositoryModelSQL.setIsan("ISAN123");
        dvdRepositoryModelSQL.setTitle("Sample Title");
        dvdRepositoryModelSQL.setDirectedBy("Sample Director");
        dvdRepositoryModelSQL.setDuration(120);
        dvdRepositoryModelSQL.setQuantity(10);
        dvdRepositoryModelSQL.setResume("Sample Resume");
        dvdRepositoryModelSQL.setFilmCover("sample_cover.jpg");
        dvdRepositoryModelSQL.setReleaseDate(LocalDate.of(2022, 1, 1));
        dvdRepositoryModelSQL.setType(Type.MOVIE);
        dvdRepositoryModelSQL.setGenre(Genre.ACTION);
        return dvdRepositoryModelSQL;
    }

    private List<DvdRepositoryModelSQL> createDvdRepositoryModelSQLList() {
        List<DvdRepositoryModelSQL> dvdList = new ArrayList<>();
        dvdList.add(createDvdRepositoryModelSQL());
        return dvdList;
    }
}