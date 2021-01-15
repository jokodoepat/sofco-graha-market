package com.sofcograha.market.model.repository;

import com.sofcograha.market.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface OrderRepository extends JpaRepository<Order, String> {

    Optional<Order> findByIdAndIsDelete (String id, int isDelete);

    List<Order> findByIsDelete (int isDelete);

    List<Order> findByNamaPemesanAndIsDelete (String namaPemesan, int isDelete);

    Optional<Order> findByNomorRegistrasiAndIsDelete (String nomorRegistrasi, int isDelete);

}
