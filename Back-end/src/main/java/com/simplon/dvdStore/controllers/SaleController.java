package com.simplon.dvdStore.controllers;

import com.simplon.dvdStore.dto.SaleDTO;
import com.simplon.dvdStore.dto.SaleGetDTO;
import com.simplon.dvdStore.mapper.SaleMapper;
import com.simplon.dvdStore.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Sale controller.
 */
@RestController
@RequestMapping(path = "sales")
public class SaleController {
    private final SaleMapper dvdMapper = SaleMapper.INSTANCE;
    @Autowired
    private SaleService service;

    /**
     * Save.
     *
     * @param dvdDTO the dvd dto
     */
    @PostMapping
    public void save(@RequestBody SaleDTO dvdDTO) {
        service.save(dvdMapper.dtoToService(dvdDTO));
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<SaleGetDTO> findAll() {
        return dvdMapper.listServiceToGetDTO(service.findAll());
    }

    /**
     * Find by id sale get dto.
     *
     * @param id the id
     * @return the sale get dto
     */
    @GetMapping("{id}")
    public SaleGetDTO findById(@PathVariable long id) {
        return dvdMapper.serviceToGetDTO(service.findById(id));
    }

    /**
     * Update.
     *
     * @param id     the id
     * @param dvdDTO the dvd dto
     */
    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody SaleDTO dvdDTO) {
        service.update(dvdMapper.dtoToService(dvdDTO), id);
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
