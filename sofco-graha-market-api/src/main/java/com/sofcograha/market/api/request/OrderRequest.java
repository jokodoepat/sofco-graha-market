package com.sofcograha.market.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Joko on Jan, 2021
 */

@Data
public class OrderRequest {

    @NotNull(message = "Nama Barang can't null")
    @NotEmpty(message = "Nama Barang can't empty")
    private String namaBarang;

    @NotNull(message = "Keterangan can't null")
    @NotEmpty(message = "Keterangan can't empty")
    private String keterangan;

    private int jumlah;

    @NotNull(message = "Nama Pemesan can't null")
    @NotEmpty(message = "Nama Pemesan can't empty")
    private String namaPemesan;

    @NotNull(message = "Alamat Pemesan can't null")
    @NotEmpty(message = "Alamat Pemesan can't empty")
    private String alamatPemesan;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Tanggal Pemesanan can't null")
    private LocalDate tanggalPemesanan;

}
