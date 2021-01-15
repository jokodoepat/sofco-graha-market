package com.sofcograha.market.model.service.impl;

import com.sofcograha.market.model.entity.Pembeli;
import com.sofcograha.market.model.repository.PembeliRepository;
import com.sofcograha.market.model.service.PembeliService;
import com.sofcograha.market.model.service.exceptions.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

@Service
public class PembeliServiceImpl implements PembeliService{

    @Autowired
    PembeliRepository repository;

    @Override
    public Pembeli save(Pembeli pembeli) {
        return repository.save(pembeli);
    }

    @Override
    public Optional<Pembeli> findById(int id) {
        Optional<Pembeli> pembeliOptional = repository.findByIdAndIsDelete(id,0);
        if (!pembeliOptional.isPresent()){
            throw new NotFoundExceptions("Pembeli not found with id "+id);
        }

        return repository.findByIdAndIsDelete(id,0);
    }

    @Override
    public List<Pembeli> findAll() {
        return repository.findByIsDelete(0);
    }

    @Override
    public void delete(int id) {
        Optional<Pembeli> pembeliOptional = repository.findByIdAndIsDelete(id,0);
        if (!pembeliOptional.isPresent()){
            throw new NotFoundExceptions("Pembeli not found with id "+id);
        }

        Pembeli pembeli = pembeliOptional.get();
        pembeli.setIsDelete(1);
        repository.save(pembeli);
    }
}
