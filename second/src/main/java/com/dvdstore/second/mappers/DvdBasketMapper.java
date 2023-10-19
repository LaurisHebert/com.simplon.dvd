package com.dvdstore.second.mappers;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.domains.DvdBasketRepositoryModelPostgreSQL;
import com.dvdstore.second.dtos.BasketDTO;
import com.dvdstore.second.dtos.BasketGetDTO;
import com.dvdstore.second.dtos.DvdBasketDTO;
import com.dvdstore.second.dtos.DvdBasketGetDTO;
import com.dvdstore.second.services.BasketServiceModel;
import com.dvdstore.second.services.DvdBasketServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DvdBasketMapper {
    DvdBasketMapper INSTANCE = Mappers.getMapper(DvdBasketMapper.class);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "basketId", source = "basketRepositoryModelPostgreSQL")
    DvdBasketServiceModel dtoToService(DvdBasketDTO dvdBasketDTO, BasketRepositoryModelPostgreSQL basketRepositoryModelPostgreSQL);

    @Mapping(target = "id", ignore = true)
    DvdBasketRepositoryModelPostgreSQL serviceToEntity(DvdBasketServiceModel dvdBasketServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    List<DvdBasketServiceModel> listRepositoryToService(List<DvdBasketRepositoryModelPostgreSQL> allByBasketId);

    List<DvdBasketGetDTO> listServiceToGetDto(List<DvdBasketServiceModel> allByBasketId);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------

}
