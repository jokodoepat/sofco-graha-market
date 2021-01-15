package com.sofcograha.market.model.repository;

import com.sofcograha.market.model.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface BarangRepository extends JpaRepository<Barang, String>{

    List<Barang> findByIsDelete (int isDelete);

    Optional<Barang> findByIdAndIsDelete (int id, int isDelete);

    Optional<Barang> findByNamaAndIsDelete (String nama, int isDelete);
}
