package com.sofcograha.market.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by Joko on Jan, 2021
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderku")
public class Order {

    @Id
    @GeneratedValue(generator  = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAMA_BARANG")
    private String namaBarang;

    @Column(name = "KET")
    private String keterangan;

    @Column(name = "JUMLAH")
    private int jumlah;

    @Column(name = "NAMA_PEMESAN")
    private String namaPemesan;

    @Column(name = "ALAMAT_PEMESAN")
    private String alamatPemesan;

    @Column(name = "TANGGAL_PESAN")
    private LocalDate tanggalPemesanan;

    @Column(name = "NO_REGISTRASI")
    private String nomorRegistrasi;

    @Column(name = "IS_DELETE")
    private int isDelete;
}
