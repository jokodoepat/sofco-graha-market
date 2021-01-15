package com.sofcograha.market.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created by Joko on Jan, 2021
 */

@Data
public class BarangRequest {

    @NotNull(message = "Name can't null")
    @NotEmpty(message = "Name can't empty")
    private String nama;

    private int harga;

}
