package com.sofcograha.market.model.service;

import com.sofcograha.market.model.entity.Pembeli;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface PembeliService {

    Pembeli save(Pembeli pembeli);

    Optional<Pembeli> findById (int id);

    List<Pembeli> findAll();

    void delete(int id);

}
