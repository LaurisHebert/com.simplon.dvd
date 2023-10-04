package com.simplon.dvdStore.controllers;

import com.simplon.dvdStore.repositories.ClientRepositoryModelSQL;
import com.simplon.dvdStore.repositories.DvdRepositoryModelSQL;
import lombok.Data;

@Data
public class SaleGetDTO {
    private long id;
    private ClientRepositoryModelSQL client;
    private DvdRepositoryModelSQL dvd;
    private int quantity;
}
