package com.sofcograha.market.model.service.impl;

import com.sofcograha.market.model.entity.Barang;
import com.sofcograha.market.model.entity.Pembeli;
import com.sofcograha.market.model.entity.Pesanan;
import com.sofcograha.market.model.repository.BarangRepository;
import com.sofcograha.market.model.repository.PembeliRepository;
import com.sofcograha.market.model.repository.PesananRepository;
import com.sofcograha.market.model.service.PesananService;
import com.sofcograha.market.model.service.exceptions.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

@Service
public class PesananServiceImpl implements PesananService{

    @Autowired
    PesananRepository repository;

    @Autowired
    PembeliRepository pembeliRepository;

    @Autowired
    BarangRepository barangRepository;

    @Override
    public Pesanan save(Pesanan pesanan) {

        Optional<Pembeli> pembeliOptional = pembeliRepository.findByIdAndIsDelete(pesanan.getIdPembeli().getId(),0);
        if (!pembeliOptional.isPresent()) {
            throw new NotFoundExceptions("Pembeli not found with id "+pesanan.getIdPembeli().getId());
        }

        Optional<Barang> barangOptional = barangRepository.findByIdAndIsDelete(pesanan.getIdBarang().getId(),0);
        if (!barangOptional.isPresent()){
            throw new NotFoundExceptions("Barang not found with id "+pesanan.getIdBarang().getId());
        }

        Pesanan pesananSave = repository.save(pesanan);

        return pesananSave;
    }

    @Override
    public Optional<Pesanan> findById(int id) {
        Optional<Pesanan> pesananOptional = repository.findByIdAndIsDelete(id,0);
        if (!pesananOptional.isPresent()){
            throw new NotFoundExceptions("Pesanan not found with id "+id);
        }
        return repository.findByIdAndIsDelete(id,0);
    }

    @Override
    public List<Pesanan> findAll() {
        return repository.findByIsDelete(0);
    }

    @Override
    public void delete(int id) {
        Optional<Pesanan> pesananOptional = repository.findByIdAndIsDelete(id, 0);
        if (!pesananOptional.isPresent()){
            throw new NotFoundExceptions("Pesanan not found with id "+id);
        }

        Pesanan pesanan = pesananOptional.get();
        pesanan.setIsDelete(1);
        repository.save(pesanan);
    }

    @Override
    public Optional<Pesanan> findByNomorRegistrasi(String nomorRegistrasi) {
        Optional<Pesanan> pesananOptional = repository.findByNomorRegistrasiAndIsDelete(nomorRegistrasi,0);
        if (!pesananOptional.isPresent()){
            throw new NotFoundExceptions("Pesanan not found with Nomor Registrasi "+nomorRegistrasi);
        }
        return pesananOptional;
    }
}
