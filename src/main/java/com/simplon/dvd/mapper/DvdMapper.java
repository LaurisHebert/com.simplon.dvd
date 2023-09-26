package com.simplon.dvd.mapper;

import com.simplon.dvd.controllers.DvdDTO;
import com.simplon.dvd.controllers.DvdGetDTO;
import com.simplon.dvd.repositories.DvdRepositoryModelSQL;
import com.simplon.dvd.services.DvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DvdMapper {
    DvdMapper INSTANCE = Mappers.getMapper(DvdMapper.class);

    DvdServiceModel dvdDTOToDvdService(DvdDTO dvdDTO);

    DvdServiceModel dvdEntityToDvdService(DvdRepositoryModelSQL dvdRepositoryModelSQL);

    DvdRepositoryModelSQL dvdServiceToDvdEntity(DvdServiceModel dvdServiceModel);

    DvdGetDTO dvdServiceToDvdGetDTO(DvdServiceModel dvdServiceModel);

    List<DvdServiceModel> listDvdEntityToDvdService(List<DvdRepositoryModelSQL> dvdRepositoryModelSQL);

    List<DvdGetDTO> listDvdServiceToDvdGetDTO(List<DvdServiceModel> dvdServiceModel);
}
