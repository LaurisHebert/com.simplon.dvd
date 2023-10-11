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

/**
 * The interface Sale mapper.
 */
@Mapper
public interface SaleMapper {
    /**
     * The constant INSTANCE.
     */
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    /**
     * Dto to service sale service model.
     *
     * @param saleDTO the sale dto
     * @return the sale service model
     */
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client_id", source = "client")
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "dvd_id", source = "dvd")
    @Mapping(target = "dvd", ignore = true)
    SaleServiceModel dtoToService(SaleDTO saleDTO);

    /**
     * Service to repository sale repository model sql.
     *
     * @param clientRepositoryModelSQL the client repository model sql
     * @param dvdRepositoryModelSQL    the dvd repository model sql
     * @param quantity                 the quantity
     * @return the sale repository model sql
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", source = "clientRepositoryModelSQL")
    @Mapping(target = "dvd", source = "dvdRepositoryModelSQL")
    @Mapping(target = "quantity", source = "quantity")
    SaleRepositoryModelSQL serviceToRepository(ClientRepositoryModelSQL clientRepositoryModelSQL, DvdRepositoryModelSQL dvdRepositoryModelSQL, long quantity);

    /**
     * Service to repository update sale repository model sql.
     *
     * @param id                       the id
     * @param clientRepositoryModelSQL the client repository model sql
     * @param dvdRepositoryModelSQL    the dvd repository model sql
     * @param quantity                 the quantity
     * @return the sale repository model sql
     */
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

    /**
     * Repository to service sale service model.
     *
     * @param saleRepositoryModelSQL the sale repository model sql
     * @return the sale service model
     */
    @Mapping(target = "client_id", ignore = true)
    @Mapping(target = "dvd_id", ignore = true)
    SaleServiceModel repositoryToService(SaleRepositoryModelSQL saleRepositoryModelSQL);

    /**
     * Service to get dto sale get dto.
     *
     * @param saleServiceModel the sale service model
     * @return the sale get dto
     */
    SaleGetDTO serviceToGetDTO(SaleServiceModel saleServiceModel);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    /**
     * List repository to service list.
     *
     * @param saleRepositoryModelSQL the sale repository model sql
     * @return the list
     */
    List<SaleServiceModel> listRepositoryToService(List<SaleRepositoryModelSQL> saleRepositoryModelSQL);

    /**
     * List service to get dto list.
     *
     * @param saleServiceModel the sale service model
     * @return the list
     */
    List<SaleGetDTO> listServiceToGetDTO(List<SaleServiceModel> saleServiceModel);

    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------
}
