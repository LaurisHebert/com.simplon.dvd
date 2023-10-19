package com.dvdstore.second.controllers;

import com.dvdstore.second.dtos.BasketDTO;
import com.dvdstore.second.dtos.BasketGetDTO;
import com.dvdstore.second.mappers.BasketMapper;
import com.dvdstore.second.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;

    @Autowired
    private BasketService service;

    @PostMapping
    public void save(@RequestBody BasketDTO basketDTO) {
        service.save(basketMapper.dtoToService(basketDTO));
    }

    @GetMapping
    public List<BasketGetDTO> findAll(){
        return basketMapper.ListServiceToGetDto(service.findAll());
    }

    @GetMapping("/{id}")
    public BasketGetDTO findById(@PathVariable Integer id) {
        return basketMapper.serviceToGetDto(service.findById(id));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody BasketDTO basketDTO) {
        service.update(id, basketMapper.dtoToService(basketDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
