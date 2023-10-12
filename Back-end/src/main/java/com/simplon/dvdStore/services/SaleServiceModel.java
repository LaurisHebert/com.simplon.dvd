package com.simplon.dvdStore.services;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import lombok.Data;

/**
 * The type Sale service model.
 */
@Data
public class SaleServiceModel {
    private Integer id;
    private ClientRepositoryModelSQL client;
    private DvdRepositoryModelSQL dvd;
    private Integer quantity;
    private Integer client_id;
    private Integer dvd_id;

}
