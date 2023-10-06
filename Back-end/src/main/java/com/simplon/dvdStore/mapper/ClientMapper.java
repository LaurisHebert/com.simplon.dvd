package com.simplon.dvdStore.mapper;


import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.dto.ClientDTO;
import com.simplon.dvdStore.dto.ClientGetDTO;
import com.simplon.dvdStore.services.ClientServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    ClientServiceModel dtoToService(ClientDTO clientDTO);

    @Mapping(target = "recording", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    ClientRepositoryModelSQL serviceToRepository(ClientServiceModel clientServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    List<ClientServiceModel> listDtoToService(List<ClientDTO> clientDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    List<ClientRepositoryModelSQL> serviceToRepository(List<ClientServiceModel> clientServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    ClientServiceModel repositoryToService(ClientRepositoryModelSQL clientRepositoryModelSQL);

    ClientGetDTO serviceToGetDTO(ClientServiceModel clientServiceModel);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    List<ClientServiceModel> listRepositoryToService(List<ClientRepositoryModelSQL> clientRepositoryModelSQL);

    List<ClientGetDTO> listServiceToGetDTO(List<ClientServiceModel> clientServiceModel);

    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------
}
