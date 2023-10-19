package com.dvdstore.second.mappers;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.dtos.BasketDTO;
import com.dvdstore.second.dtos.BasketGetDTO;
import com.dvdstore.second.services.BasketServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BasketMapper {

    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //       DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    BasketServiceModel dtoToService(BasketDTO basketDTO);

    @Mapping(target = "id", ignore = true)
    BasketRepositoryModelPostgreSQL serviceToRepository(BasketServiceModel basketServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    BasketServiceModel repositoryToService(BasketRepositoryModelPostgreSQL basketRepositoryModelPostgreSQL);

    BasketGetDTO serviceToGetDto(BasketServiceModel byId);

    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------

    List<BasketServiceModel> listRepositoryToService(Iterable<BasketRepositoryModelPostgreSQL> all);

    List<BasketGetDTO> ListServiceToGetDto(List<BasketServiceModel> all);



    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------

}
