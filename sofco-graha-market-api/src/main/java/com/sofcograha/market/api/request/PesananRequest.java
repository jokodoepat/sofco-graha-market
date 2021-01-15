package com.sofcograha.market.api.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Joko on Jan, 2021
 */

@Data
public class PesananRequest {

//    @NotNull(message = "Id Barang can't null")
//    @NotEmpty(message = "Id Barang can't empty")
    private int idBarang;

//    @NotNull(message = "Id Pembeli can't null")
//    @NotEmpty(message = "Id Pembeli can't empty")
    private int idPembeli;

    private int total;

    @NotNull(message = "Keterangan can't null")
    @NotEmpty(message = "Keterangan can't empty")
    private String keterangan;


}
