package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.DvdDTO;
import com.simplon.dvdStore.dto.DvdGetDTO;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.services.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "dvd")
public class DvdController {

    private final DvdMapper dvdMapper = DvdMapper.INSTANCE;
    @Autowired
    private DvdService service;

    @PostMapping
    public void save(@RequestBody DvdDTO dvdDTO) {
        service.save(dvdMapper.dvdDTOToDvdService(dvdDTO));
    }

    @GetMapping("{id}")
    public DvdGetDTO findById(@PathVariable long id) {
        return dvdMapper.dvdServiceToDvdGetDTO(service.findById(id));
    }

    @GetMapping
    public List<DvdGetDTO> findAll() {
        return dvdMapper.listDvdServiceToDvdGetDTO(service.findAll());
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody DvdDTO dvdDTO) {
        service.update(dvdMapper.dvdDTOToDvdService(dvdDTO), id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
