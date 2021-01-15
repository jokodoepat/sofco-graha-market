package com.sofcograha.market.model.repository;

import com.sofcograha.market.model.entity.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface PesananRepository extends JpaRepository<Pesanan, String>{

    Optional<Pesanan> findByIdAndIsDelete (int id, int isDelete);

    List<Pesanan> findByIsDelete (int isDelete);

    Optional<Pesanan> findByNomorRegistrasiAndIsDelete (String nomorRegistrasi, int isDelete);
}
