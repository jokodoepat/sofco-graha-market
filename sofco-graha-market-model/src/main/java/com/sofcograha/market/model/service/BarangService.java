package com.sofcograha.market.model.service;

import com.sofcograha.market.model.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface BarangService {

    Barang save(Barang barang);

    Optional<Barang> findById (int id);

    List<Barang> findAll();

    void delete(int id);

}
