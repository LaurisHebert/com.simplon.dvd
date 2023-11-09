package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.DvdDTO;
import com.simplon.dvdStore.dto.DvdGetDTO;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.services.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Dvd controller.
 */
@RestController
@RequestMapping(path = "dvds")
public class DvdController {

    private final DvdMapper dvdMapper = DvdMapper.INSTANCE;
    @Autowired
    private DvdService service;

    @PostMapping
    public void save(@RequestBody DvdDTO dvdDTO) {
        System.out.println(dvdDTO);
        service.save(dvdMapper.dvdDTOToDvdService(dvdDTO));
    }

    @GetMapping
    public List<DvdGetDTO> findAll() {
        return dvdMapper.listDvdServiceToDvdGetDTO(service.findAll());
    }

    @GetMapping("{id}")
    public DvdGetDTO findById(@PathVariable int id) {
        return dvdMapper.dvdServiceToDvdGetDTO(service.findById(id));
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody DvdDTO dvdDTO) {
        service.update(dvdMapper.dvdDTOToDvdService(dvdDTO), id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
}
