package com.simplon.dvdStore.mapper;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import com.simplon.dvdStore.domain.SaleRepositoryModelSQL;
import com.simplon.dvdStore.dto.SaleDTO;
import com.simplon.dvdStore.dto.SaleGetDTO;
import com.simplon.dvdStore.services.SaleServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SaleMapper {
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client_id", source = "client")
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "dvd_id", source = "dvd")
    @Mapping(target = "dvd", ignore = true)
    SaleServiceModel dtoToService(SaleDTO saleDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", source = "clientRepositoryModelSQL")
    @Mapping(target = "dvd", source = "dvdRepositoryModelSQL")
    @Mapping(target = "quantity", source = "quantity")
    SaleRepositoryModelSQL serviceToRepository(ClientRepositoryModelSQL clientRepositoryModelSQL, DvdRepositoryModelSQL dvdRepositoryModelSQL, long quantity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "client", source = "clientRepositoryModelSQL")
    @Mapping(target = "dvd", source = "dvdRepositoryModelSQL")
    @Mapping(target = "quantity", source = "quantity")
    SaleRepositoryModelSQL serviceToRepositoryUpdate(long id, ClientRepositoryModelSQL clientRepositoryModelSQL, DvdRepositoryModelSQL dvdRepositoryModelSQL, long quantity);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    @Mapping(target = "client_id", ignore = true)
    @Mapping(target = "dvd_id", ignore = true)
    SaleServiceModel repositoryToService(SaleRepositoryModelSQL saleRepositoryModelSQL);

    SaleGetDTO serviceToGetDTO(SaleServiceModel saleServiceModel);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    List<SaleServiceModel> listRepositoryToService(List<SaleRepositoryModelSQL> saleRepositoryModelSQL);

    List<SaleGetDTO> listServiceToGetDTO(List<SaleServiceModel> saleServiceModel);

    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------
}
