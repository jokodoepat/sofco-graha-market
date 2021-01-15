package com.sofcograha.market.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "Nama")
    private String nama;

    @Column(name = "Harga")
    private int harga;

    @Column(name = "Is_Delete")
    private int isDelete;

}
