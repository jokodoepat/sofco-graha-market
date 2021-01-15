package com.sofcograha.market.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Joko on Jan, 2021
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pembeli")
public class Pembeli {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "Nama")
    private String nama;

    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "Kota")
    private String  kota;

    @Column(name = "Kode_Pos")
    private String kodePos;

    @Column(name = "Is_Delete")
    private int isDelete;

}
