package com.simplon.dvd.mapper;

import com.simplon.dvd.controllers.ClientDTO;
import com.simplon.dvd.controllers.ClientGetDTO;
import com.simplon.dvd.repositories.ClientRepositoryModelSQL;
import com.simplon.dvd.services.ClientServiceModel;
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
