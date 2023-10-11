package com.simplon.dvdStore.dto;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import lombok.Data;

/**
 * The type Sale get dto.
 */
@Data
public class SaleGetDTO {
    private long id;
    private ClientRepositoryModelSQL client;
    private DvdRepositoryModelSQL dvd;
    private int quantity;
}
