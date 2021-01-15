package com.sofcograha.market.model.service.impl;

import com.sofcograha.market.model.entity.Barang;
import com.sofcograha.market.model.repository.BarangRepository;
import com.sofcograha.market.model.service.BarangService;
import com.sofcograha.market.model.service.exceptions.AlreadyUsedExceptions;
import com.sofcograha.market.model.service.exceptions.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    BarangRepository repository;

    @Override
    public Barang save(Barang barang) {

        Optional<Barang> barangOptional = repository.findByNamaAndIsDelete(barang.getNama(), 0);
        if (barangOptional.isPresent()){
            throw new AlreadyUsedExceptions("Nama barang already used "+barang.getNama());
        }

        Barang barangSave = repository.save(barang);

        return barangSave;
    }

    @Override
    public Optional<Barang> findById(int id) {

        Optional<Barang> barangOptional = repository.findByIdAndIsDelete(id, 0);
        if (!barangOptional.isPresent()){
            throw new NotFoundExceptions("Barang with id not found "+id);
        }

        return repository.findByIdAndIsDelete(id,0);
    }

    @Override
    public List<Barang> findAll() {
        return repository.findByIsDelete(0);
    }

    @Override
    public void delete(int id) {

        Optional<Barang> barangOptional = repository.findByIdAndIsDelete(id, 0);
        if (!barangOptional.isPresent()){
            throw new NotFoundExceptions("Barang with id not found "+id);
        }

        Barang barang = barangOptional.get();
        barang.setIsDelete(1);

        repository.save(barang);
    }
}
