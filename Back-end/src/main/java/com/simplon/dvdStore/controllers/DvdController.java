package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.DvdDTO;
import com.simplon.dvdStore.dto.DvdGetDTO;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.services.DvdService;
import com.simplon.dvdStore.services.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Dvd controller.
 */
@RestController
@RequestMapping(path = "dvd")
public class DvdController {
    private final DvdMapper dvdMapper = DvdMapper.INSTANCE;

    @Autowired
    private DvdService service;

    @PostMapping
    public void save(@RequestBody DvdDTO dvdDTO) {
        service.save(dvdMapper.dtoToService(dvdDTO));
    }

    @GetMapping
    public List<DvdGetDTO> findAll() {
        return dvdMapper.listServiceToGetDTO(service.findAll());
    }

    @GetMapping("{isan}")
    public DvdGetDTO findByIsan(@PathVariable String isan) {
        return dvdMapper.serviceToGetDTO(service.findByIsan(isan));
    }

    @PutMapping("{isan}")
    public DvdGetDTO update(@PathVariable String isan, @RequestBody DvdDTO dvdDTO) {
        DvdServiceModel dvd = dvdMapper.dtoToService(dvdDTO);
        DvdServiceModel dvdUpdated = service.updateByIsan(dvd, isan);
        return dvdMapper.serviceToGetDTO(dvdUpdated);
    }

    @DeleteMapping("{isan}")
    public void deleteByIsan(@PathVariable String isan) {
        service.deleteByIsan(isan);
    }
}
