package com.sofcograha.market.model.service;

import com.sofcograha.market.model.entity.Pesanan;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface PesananService {

    Pesanan save(Pesanan pesanan);

    Optional<Pesanan> findById(int id);

    List<Pesanan> findAll();

    void delete(int id);

    Optional<Pesanan> findByNomorRegistrasi(String nomorRegistrasi);
}
