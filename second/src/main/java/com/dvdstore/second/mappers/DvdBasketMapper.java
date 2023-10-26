package com.dvdstore.second.mappers;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.domains.DvdBasketRepositoryModelPostgreSQL;
import com.dvdstore.second.dtos.DvdBasketDTO;
import com.dvdstore.second.dtos.DvdBasketGetDTO;
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
    DvdBasketServiceModel dvdBasketDtoToDvdBasketServiceModel(DvdBasketDTO dvdBasketDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "basketId", source = "basket")
    DvdBasketRepositoryModelPostgreSQL dvdBasketServiceModelToDvdBasketRepositoryModelPostgreSQL(DvdBasketServiceModel dvdBasketServiceModel, BasketRepositoryModelPostgreSQL basket);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    List<DvdBasketGetDTO> listDvdBasketServiceModelToDvdBasketGetDto(List<DvdBasketServiceModel> allByBasketId);

    List<DvdBasketServiceModel> listDvdBasketRepositoryModelPostgreSQLToDvdServiceModel(List<DvdBasketRepositoryModelPostgreSQL> allByBasketId);

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
