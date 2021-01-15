package com.sofcograha.market.api.controller;

import com.sofcograha.market.api.request.PembeliRequest;
import com.sofcograha.market.api.response.CodeError;
import com.sofcograha.market.api.response.ErrorHandling;
import com.sofcograha.market.api.response.Source;
import com.sofcograha.market.model.entity.Pembeli;
import com.sofcograha.market.model.service.PembeliService;
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
@RequestMapping("/pembeli")
public class PembeliController {

    @Autowired
    private PembeliService pembeliService;

    @GetMapping("/list")
    public ResponseEntity listGet() {
        return ResponseEntity.ok(pembeliService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteId(@RequestParam("id") @Valid int id) {

        pembeliService.delete(id);
        return new ResponseEntity("{\"status\":\"suscess\"}", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid PembeliRequest request, Errors errors, HttpServletRequest httpServletRequest){
        CodeError<Pembeli> response = new CodeError<>();
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
        pembeli.setIsDelete(0);
        pembeli.setNama(request.getNama());
        pembeli.setAlamat(request.getAlamat());
        pembeli.setKodePos(request.getKodePos());
        pembeli.setKota(request.getKota());

        try {
            Pembeli cust = pembeliService.save(pembeli);
            response.setData(cust);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Valid PembeliRequest request, @RequestParam("id") int id, Errors errors, HttpServletRequest httpServletRequest) {

        CodeError<Pembeli> response = new CodeError();
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

        Optional<Pembeli> pembeliOptional = pembeliService.findById(id);

        if (!pembeliOptional.isPresent()) {
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

        Pembeli pembeli = pembeliOptional.get();
        pembeli.setNama(request.getNama());
        pembeli.setAlamat(request.getAlamat());
        pembeli.setKodePos(request.getKodePos());
        pembeli.setKota(request.getKota());

        Pembeli ref = pembeliService.save(pembeli);
        response.setData(ref);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
