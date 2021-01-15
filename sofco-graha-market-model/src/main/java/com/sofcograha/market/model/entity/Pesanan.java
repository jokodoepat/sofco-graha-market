package com.sofcograha.market.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.math.BigInteger;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Joko on Jan, 2021
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pesanan")
public class Pesanan {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Id_Barang", foreignKey = @ForeignKey(name = "fk_barang"))
    private Barang idBarang;

    @ManyToOne
    @JoinColumn(name = "Id_Pembeli", foreignKey = @ForeignKey(name = "fk_pembeli"))
    private Pembeli idPembeli;

    @Column(name = "Total")
    private int total;

    @Column(name = "Keterangan")
    private String keterangan;

    @GeneratedValue(generator  = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Nomor_Registrasi")
    private String nomorRegistrasi;

    @Column(name = "Is_Delete")
    private int isDelete;

}
