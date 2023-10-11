package com.simplon.dvdStore.mapper;


import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.dto.ClientDTO;
import com.simplon.dvdStore.dto.ClientGetDTO;
import com.simplon.dvdStore.services.ClientServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Client mapper.
 */
@Mapper
public interface ClientMapper {

    /**
     * The constant INSTANCE.
     */
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * Dto to service client service model.
     *
     * @param clientDTO the client dto
     * @return the client service model
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    ClientServiceModel dtoToService(ClientDTO clientDTO);

    /**
     * Service to repository client repository model sql.
     *
     * @param clientServiceModel the client service model
     * @return the client repository model sql
     */
    @Mapping(target = "recording", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    ClientRepositoryModelSQL serviceToRepository(ClientServiceModel clientServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * List dto to service list.
     *
     * @param clientDTO the client dto
     * @return the list
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    List<ClientServiceModel> listDtoToService(List<ClientDTO> clientDTO);

    /**
     * Service to repository list.
     *
     * @param clientServiceModel the client service model
     * @return the list
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    List<ClientRepositoryModelSQL> serviceToRepository(List<ClientServiceModel> clientServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    /**
     * Repository to service client service model.
     *
     * @param clientRepositoryModelSQL the client repository model sql
     * @return the client service model
     */
    ClientServiceModel repositoryToService(ClientRepositoryModelSQL clientRepositoryModelSQL);

    /**
     * Service to get dto client get dto.
     *
     * @param clientServiceModel the client service model
     * @return the client get dto
     */
    ClientGetDTO serviceToGetDTO(ClientServiceModel clientServiceModel);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    /**
     * List repository to service list.
     *
     * @param clientRepositoryModelSQL the client repository model sql
     * @return the list
     */
    List<ClientServiceModel> listRepositoryToService(List<ClientRepositoryModelSQL> clientRepositoryModelSQL);

    /**
     * List service to get dto list.
     *
     * @param clientServiceModel the client service model
     * @return the list
     */
    List<ClientGetDTO> listServiceToGetDTO(List<ClientServiceModel> clientServiceModel);

    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------
}
