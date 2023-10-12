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
    DvdServiceModel dtoToService(DvdDTO dvdDTO);

    /**
     * Dvd repository to dvd service dvd service model.
     *
     * @param dvdRepositoryModelSQL the dvd repository model sql
     * @return the dvd service model
     */
    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd/MM/yyyy")
    DvdServiceModel repositoryToService(DvdRepositoryModelSQL dvdRepositoryModelSQL);

    /**
     * Dvd service to dvd repository dvd repository model sql.
     *
     * @param dvdServiceModel the dvd service model
     * @return the dvd repository model sql
     */
    @Mapping(target = "recording", ignore = true)
    DvdRepositoryModelSQL serviceToRepository(DvdServiceModel dvdServiceModel);

    /**
     * Dvd service to dvd get dto dvd get dto.
     *
     * @param dvdServiceModel the dvd service model
     * @return the dvd get dto
     */
    DvdGetDTO serviceToGetDTO(DvdServiceModel dvdServiceModel);

    /**
     * List dvd repository to dvd service list.
     *
     * @param dvdRepositoryModelSQL the dvd repository model sql
     * @return the list
     */
    List<DvdServiceModel> listRepositoryToService(List<DvdRepositoryModelSQL> dvdRepositoryModelSQL);

    /**
     * List dvd service to dvd get dto list.
     *
     * @param dvdServiceModel the dvd service model
     * @return the list
     */
    List<DvdGetDTO> listServiceToGetDTO(List<DvdServiceModel> dvdServiceModel);
}
