package com.sofcograha.market.api.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Joko on Jan, 2021
 */

@Data
public class PesananUpdateRequest {

    private int idBarang;

    private int idPembeli;

    @NotNull(message = "Keterangan can't null")
    @NotEmpty(message = "Keterangan can't empty")
    private String keterangan;

    @NotNull(message = "Nomor Registrasi can't null")
    @NotEmpty(message = "Nomor Registrasi can't empty")
    private String nomorRegistrasi;

    private int total;
}
