package com.simplon.dvd.controllers;

import com.simplon.dvd.mapper.DvdMapper;
import com.simplon.dvd.services.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "dvd")
public class DvdController {

    @Autowired
    private DvdService service;

    @PostMapping
    public void save(@RequestBody DvdDTO dvdDTO) {
        service.save(DvdMapper.INSTANCE.dvdDTOToDvdService(dvdDTO),null);
    }

    @GetMapping("{id}")
    public DvdGetDTO findById(@PathVariable long id) {
        return DvdMapper.INSTANCE.dvdServiceToDvdGetDTO(service.findById(id));
    }

    @GetMapping
    public List<DvdGetDTO> findAll() {
        return DvdMapper.INSTANCE.listDvdServiceToDvdGetDTO(service.findAll());
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody DvdDTO dvdDTO) {service.save(DvdMapper.INSTANCE.dvdDTOToDvdService(dvdDTO), id);}

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
