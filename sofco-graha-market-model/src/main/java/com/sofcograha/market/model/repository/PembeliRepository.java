package com.sofcograha.market.model.repository;

import com.sofcograha.market.model.entity.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface PembeliRepository extends JpaRepository<Pembeli, String>{

    Optional<Pembeli> findByIdAndIsDelete (int id, int isDelete);

    List<Pembeli> findByIsDelete (int isDelete);
}
