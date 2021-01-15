package com.sofcograha.market.model.service.impl;

import com.sofcograha.market.model.entity.Order;
import com.sofcograha.market.model.repository.OrderRepository;
import com.sofcograha.market.model.service.OrderService;
import com.sofcograha.market.model.service.exceptions.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Optional<Order> findById(String id) {
        Optional<Order> orderOptional = repository.findByIdAndIsDelete(id, 0);
        if (!orderOptional.isPresent())
            throw new NotFoundExceptions("Order not found with id "+id);

        return orderOptional;
    }

    @Override
    public List<Order> findAll() {
        return repository.findByIsDelete(0);
    }

    @Override
    public void delete(String id) {
        Optional<Order> orderOptional = repository.findByIdAndIsDelete(id, 0);
        if (!orderOptional.isPresent())
            throw new NotFoundExceptions("Order not found with id "+id);

        Order order = orderOptional.get();
        order.setIsDelete(1);

        repository.save(order);
    }

    @Override
    public Optional<Order> findByNomorRegistrasi(String nomorRegistrasi) {
        Optional<Order> orderOptional = repository.findByNomorRegistrasiAndIsDelete(nomorRegistrasi,0);
        if (!orderOptional.isPresent())
            throw new NotFoundExceptions("Order not found with Nomor Registration "+nomorRegistrasi);
        return orderOptional;
    }


    @Override
    public List<Order> findByNamaPemesan(String namaPemesan) {
        return repository.findByNamaPemesanAndIsDelete(namaPemesan, 0);
    }
}
