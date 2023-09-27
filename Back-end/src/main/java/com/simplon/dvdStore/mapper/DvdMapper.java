package com.simplon.dvdStore.mapper;

import com.simplon.dvdStore.controllers.DvdDTO;
import com.simplon.dvdStore.controllers.DvdGetDTO;
import com.simplon.dvdStore.repositories.DvdRepositoryModelSQL;
import com.simplon.dvdStore.services.DvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DvdMapper {
    DvdMapper INSTANCE = Mappers.getMapper(DvdMapper.class);

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "id", ignore = true)
    DvdServiceModel dvdDTOToDvdService(DvdDTO dvdDTO);

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    DvdServiceModel dvdEntityToDvdService(DvdRepositoryModelSQL dvdRepositoryModelSQL);

    DvdRepositoryModelSQL dvdServiceToDvdEntity(DvdServiceModel dvdServiceModel);

    DvdGetDTO dvdServiceToDvdGetDTO(DvdServiceModel dvdServiceModel);

    List<DvdServiceModel> listDvdEntityToDvdService(List<DvdRepositoryModelSQL> dvdRepositoryModelSQL);

    List<DvdGetDTO> listDvdServiceToDvdGetDTO(List<DvdServiceModel> dvdServiceModel);
}
