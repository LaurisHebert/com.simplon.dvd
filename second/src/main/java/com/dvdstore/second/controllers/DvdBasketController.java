package com.dvdstore.second.controllers;

import com.dvdstore.second.dtos.DvdBasketDTO;
import com.dvdstore.second.dtos.DvdBasketGetDTO;
import com.dvdstore.second.mappers.DvdBasketMapper;
import com.dvdstore.second.repositories.BasketRepository;
import com.dvdstore.second.services.DvdBasketService;
import com.dvdstore.second.services.DvdBasketServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "dvdbasket")
public class DvdBasketController {
    private final DvdBasketMapper dvdBasketMapper = DvdBasketMapper.INSTANCE;

    @Autowired
    private DvdBasketService service;

    @Autowired
    private BasketRepository basketRepository;
    @PostMapping
    public void save(@RequestBody DvdBasketDTO dvdBasketDTO) {
        DvdBasketServiceModel serviceModel = dvdBasketMapper.dtoToService(dvdBasketDTO, basketRepository.findById(dvdBasketDTO.basketId()).get());
        service.save(serviceModel);
    }

    @GetMapping("/{id}")
    public List<DvdBasketGetDTO> findAllByBasketId(@PathVariable Integer id) {
        return dvdBasketMapper.listServiceToGetDto(service.findAllByBasketId(id));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody DvdBasketDTO dvdBasketDTO) {
        DvdBasketServiceModel serviceModel = dvdBasketMapper.dtoToService(dvdBasketDTO, basketRepository.findById(dvdBasketDTO.basketId()).get());
        service.update(id, serviceModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
