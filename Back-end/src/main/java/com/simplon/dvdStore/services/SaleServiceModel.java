package com.simplon.dvdStore.services;

import com.simplon.dvdStore.repositories.ClientRepositoryModelSQL;
import com.simplon.dvdStore.repositories.DvdRepositoryModelSQL;
import lombok.Data;

@Data
public class SaleServiceModel {
    private long id;
    private ClientRepositoryModelSQL client;
    private DvdRepositoryModelSQL dvd;
    private int quantity;
    private long client_id;
    private long dvd_id;

}
