package com.simplon.dvdStore.mapper;

import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import com.simplon.dvdStore.dto.DvdDTO;
import com.simplon.dvdStore.dto.DvdGetDTO;
import com.simplon.dvdStore.services.DvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Dvd mapper.
 */
@Mapper
public interface DvdMapper {
    /**
     * The constant INSTANCE.
     */
    DvdMapper INSTANCE = Mappers.getMapper(DvdMapper.class);

    /**
     * Dvd dto to dvd service dvd service model.
     *
     * @param dvdDTO the dvd dto
     * @return the dvd service model
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    DvdServiceModel dvdDTOToDvdService(DvdDTO dvdDTO);

    /**
     * Dvd entity to dvd service dvd service model.
     *
     * @param dvdRepositoryModelSQL the dvd repository model sql
     * @return the dvd service model
     */
    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    DvdServiceModel dvdEntityToDvdService(DvdRepositoryModelSQL dvdRepositoryModelSQL);

    /**
     * Dvd service to dvd entity dvd repository model sql.
     *
     * @param dvdServiceModel the dvd service model
     * @return the dvd repository model sql
     */
    @Mapping(target = "recording", ignore = true)
    DvdRepositoryModelSQL dvdServiceToDvdEntity(DvdServiceModel dvdServiceModel);

    /**
     * Dvd service to dvd get dto dvd get dto.
     *
     * @param dvdServiceModel the dvd service model
     * @return the dvd get dto
     */
    DvdGetDTO dvdServiceToDvdGetDTO(DvdServiceModel dvdServiceModel);

    /**
     * List dvd entity to dvd service list.
     *
     * @param dvdRepositoryModelSQL the dvd repository model sql
     * @return the list
     */
    List<DvdServiceModel> listDvdEntityToDvdService(List<DvdRepositoryModelSQL> dvdRepositoryModelSQL);

    /**
     * List dvd service to dvd get dto list.
     *
     * @param dvdServiceModel the dvd service model
     * @return the list
     */
    List<DvdGetDTO> listDvdServiceToDvdGetDTO(List<DvdServiceModel> dvdServiceModel);
}
