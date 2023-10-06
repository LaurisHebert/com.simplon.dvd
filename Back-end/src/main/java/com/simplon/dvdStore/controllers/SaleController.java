package com.simplon.dvdStore.controllers;

import com.simplon.dvdStore.dto.SaleDTO;
import com.simplon.dvdStore.dto.SaleGetDTO;
import com.simplon.dvdStore.mapper.SaleMapper;
import com.simplon.dvdStore.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sales")
public class SaleController {
    private final SaleMapper dvdMapper = SaleMapper.INSTANCE;
    @Autowired
    private SaleService service;

    @PostMapping
    public void save(@RequestBody SaleDTO dvdDTO) {
        service.save(dvdMapper.dtoToService(dvdDTO));
    }

    @GetMapping("{id}")
    public SaleGetDTO findById(@PathVariable long id) {
        return dvdMapper.serviceToGetDTO(service.findById(id));
    }

    @GetMapping
    public List<SaleGetDTO> findAll() {
        return dvdMapper.listServiceToGetDTO(service.findAll());
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody SaleDTO dvdDTO) {
        service.update(dvdMapper.dtoToService(dvdDTO), id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
