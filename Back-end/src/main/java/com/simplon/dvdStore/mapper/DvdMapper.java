package com.simplon.dvdStore.mapper;

import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import com.simplon.dvdStore.dto.DvdDTO;
import com.simplon.dvdStore.dto.DvdGetDTO;
import com.simplon.dvdStore.services.DvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DvdMapper {
    DvdMapper INSTANCE = Mappers.getMapper(DvdMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    DvdServiceModel dvdDTOToDvdService(DvdDTO dvdDTO);

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    DvdServiceModel dvdEntityToDvdService(DvdRepositoryModelSQL dvdRepositoryModelSQL);

    @Mapping(target = "recording", ignore = true)
    DvdRepositoryModelSQL dvdServiceToDvdEntity(DvdServiceModel dvdServiceModel);

    DvdGetDTO dvdServiceToDvdGetDTO(DvdServiceModel dvdServiceModel);

    List<DvdServiceModel> listDvdEntityToDvdService(List<DvdRepositoryModelSQL> dvdRepositoryModelSQL);

    List<DvdGetDTO> listDvdServiceToDvdGetDTO(List<DvdServiceModel> dvdServiceModel);
}
