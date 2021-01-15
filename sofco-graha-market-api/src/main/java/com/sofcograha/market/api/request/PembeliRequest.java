package com.sofcograha.market.api.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Joko on Jan, 2021
 */

@Data
public class PembeliRequest {

    @NotNull(message = "Name can't null")
    @NotEmpty(message = "Name can't empty")
    private String nama;

    @NotNull(message = "Alamat can't null")
    @NotEmpty(message = "Alamat can't empty")
    private String alamat;

    @NotNull(message = "Kota can't null")
    @NotEmpty(message = "Kota can't empty")
    private String kota;

    @NotNull(message = "Kode Pos can't null")
    @NotEmpty(message = "Kode Pos can't empty")
    private String kodePos;
}
