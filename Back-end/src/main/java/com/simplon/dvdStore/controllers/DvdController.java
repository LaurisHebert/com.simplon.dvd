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
@RequestMapping(path = "dvd")
public class DvdController {

    private final DvdMapper dvdMapper = DvdMapper.INSTANCE;
    @Autowired
    private DvdService service;

    /**
     * Save.
     *
     * @param dvdDTO the dvd dto
     */
    @PostMapping
    public void save(@RequestBody DvdDTO dvdDTO) {
        service.save(dvdMapper.dvdDTOToDvdService(dvdDTO));
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<DvdGetDTO> findAll() {
        return dvdMapper.listDvdServiceToDvdGetDTO(service.findAll());
    }

    /**
     * Find by id dvd get dto.
     *
     * @param id the id
     * @return the dvd get dto
     */
    @GetMapping("{id}")
    public DvdGetDTO findById(@PathVariable long id) {
        return dvdMapper.dvdServiceToDvdGetDTO(service.findById(id));
    }

    /**
     * Update.
     *
     * @param id     the id
     * @param dvdDTO the dvd dto
     */
    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody DvdDTO dvdDTO) {
        service.update(dvdMapper.dvdDTOToDvdService(dvdDTO), id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
