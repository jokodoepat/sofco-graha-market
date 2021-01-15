package com.sofcograha.market.model.service;

import com.sofcograha.market.model.entity.Order;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

public interface OrderService {

    Order save(Order order);

    Optional<Order> findById(String id);

    List<Order> findAll();

    void delete(String id);

    Optional<Order> findByNomorRegistrasi(String nomorRegistrasi);

    List<Order> findByNamaPemesan(String namaPemesan);

}
