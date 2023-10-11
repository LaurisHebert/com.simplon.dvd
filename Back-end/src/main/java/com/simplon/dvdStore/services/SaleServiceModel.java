package com.simplon.dvdStore.services;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import lombok.Data;

/**
 * The type Sale service model.
 */
@Data
public class SaleServiceModel {
    private long id;
    private ClientRepositoryModelSQL client;
    private DvdRepositoryModelSQL dvd;
    private int quantity;
    private long client_id;
    private long dvd_id;

}
