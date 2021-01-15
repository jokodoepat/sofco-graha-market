package com.sofcograha.market.api.controller;

import com.sofcograha.market.api.request.PesananRequest;
import com.sofcograha.market.api.request.PesananUpdateRequest;
import com.sofcograha.market.api.response.CodeError;
import com.sofcograha.market.api.response.ErrorHandling;
import com.sofcograha.market.api.response.Source;
import com.sofcograha.market.model.entity.Barang;
import com.sofcograha.market.model.entity.Pembeli;
import com.sofcograha.market.model.entity.Pesanan;
import com.sofcograha.market.model.service.PesananService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Joko on Jan, 2021
 */

@Slf4j
@RestController
@RequestMapping("/pesanan")
public class PesananController {

    @Autowired
    private PesananService pesananService;

    @GetMapping("/list")
    public ResponseEntity listGet() {
        return ResponseEntity.ok(pesananService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteId(@RequestParam("id") @Valid int id) {

        pesananService.delete(id);
        return new ResponseEntity("{\"status\":\"suscess\"}", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid PesananRequest request, Errors errors, HttpServletRequest httpServletRequest){
        CodeError<Pesanan> response = new CodeError<>();
        Map<String,Object> disctonories = new HashMap<>();
        response.setDictionaries(disctonories);
        if (errors.hasErrors()){
            errors.getAllErrors().forEach(err ->{
                ErrorHandling errorHandling = new ErrorHandling();
                errorHandling.setCode(err.getObjectName());
                errorHandling.setTitle("Bad Request");
                errorHandling.setDescription(err.getDefaultMessage());

                Source source = new Source();
                source.setParameter("");
                source.setPointer(httpServletRequest.getRequestURI());

                errorHandling.setSource(source);
                errorHandling.setStatus("Bad Request");

                response.getErrors().add(errorHandling);
            });
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

        }

        Pembeli pembeli = new Pembeli();
        pembeli.setId(request.getIdPembeli());

        Barang barang = new Barang();
        barang.setId(request.getIdBarang());

        Pesanan pesanan = new Pesanan();
        pesanan.setIsDelete(0);
        pesanan.setKeterangan(request.getKeterangan());
        pesanan.setIdBarang(barang);
        pesanan.setIdPembeli(pembeli);
        pesanan.setTotal(request.getTotal());

        try {
            Pesanan cust = pesananService.save(pesanan);
            response.setData(cust);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Valid PesananUpdateRequest request, @RequestParam("nomorRegistrasi") String nomorRegistrasi, Errors errors, HttpServletRequest httpServletRequest) {

        CodeError<Pesanan> response = new CodeError();
        Map<String, Object> disctonories = new HashMap<>();
        response.setDictionaries(disctonories);
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(err -> {
                ErrorHandling errorHandling = new ErrorHandling();
                errorHandling.setCode(err.getObjectName());
                errorHandling.setTitle("Bad Request");
                errorHandling.setDescription(err.getDefaultMessage());

                Source source = new Source();
                source.setParameter("");
                source.setPointer(httpServletRequest.getRequestURI());

                errorHandling.setSource(source);
                errorHandling.setStatus("Bad Request");

                response.getErrors().add(errorHandling);
            });
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

        }

        Optional<Pesanan> pesananOptional = pesananService.findByNomorRegistrasi(nomorRegistrasi);

        if (!pesananOptional.isPresent()) {
            ErrorHandling errorHandling = new ErrorHandling();
            errorHandling.setCode("5000");
            errorHandling.setTitle("Data Not Found");
            errorHandling.setDescription("Data Not Found");

            Source source = new Source();
            source.setParameter("");
            source.setPointer(httpServletRequest.getRequestURI());

            errorHandling.setSource(source);
            errorHandling.setStatus("Data Not Found");

            response.getErrors().add(errorHandling);
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }

        Pembeli pembeli = new Pembeli();
        pembeli.setId(request.getIdPembeli());

        Barang barang = new Barang();
        barang.setId(request.getIdBarang());

        Pesanan pesanan = pesananOptional.get();
        pesanan.setKeterangan(request.getKeterangan());
        pesanan.setIdBarang(barang);
        pesanan.setIdPembeli(pembeli);
        pesanan.setTotal(request.getTotal());

        Pesanan ref = pesananService.save(pesanan);
        response.setData(ref);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
