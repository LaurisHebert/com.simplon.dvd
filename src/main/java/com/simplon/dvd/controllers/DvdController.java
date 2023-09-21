package com.simplon.dvd.controllers;

import com.simplon.dvd.services.DvdService;
import com.simplon.dvd.services.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "dvd")
public class DvdController {

    @Autowired
    private DvdService service;

    @PostMapping
    public void save(@RequestBody DvdDTO dvdDTO) {
        service.save(new DvdServiceModel(dvdDTO));
    }

    @GetMapping("{/id}")
    public DvdGetDTO findById(@PathVariable long id) {
        DvdServiceModel dvd = service.findById(id);
        return new DvdGetDTO(dvd);
    }

    @GetMapping
    public List<DvdGetDTO> findAll() {
        List<DvdGetDTO> dvds = new ArrayList<>();

        for (DvdServiceModel dvd : service.findAll()) {
            dvds.add(new DvdGetDTO(dvd));
        }
        return dvds;
    }

    @PostMapping("{/id}")
    public void update(@PathVariable long id, @RequestBody DvdDTO dvdDTO) {service.save(new DvdServiceModel(id, dvdDTO));}

    @DeleteMapping("{/id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
