package com.sofcograha.market.api.controller;

import com.sofcograha.market.api.request.OrderRequest;
import com.sofcograha.market.api.request.OrderTotalRequest;
import com.sofcograha.market.api.response.CodeError;
import com.sofcograha.market.api.response.ErrorHandling;
import com.sofcograha.market.api.response.Source;
import com.sofcograha.market.model.entity.Order;
import com.sofcograha.market.model.service.OrderService;
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
import java.util.UUID;

/**
 * Created by Joko on Jan, 2021
 */

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ResponseEntity listGet() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/listku")
    public ResponseEntity findByNamaPemesan(@RequestParam("namaPemesan") @Valid String namaPemesan) {
        return ResponseEntity.ok(orderService.findByNamaPemesan(namaPemesan));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteId(@RequestParam("id") @Valid String id) {

        orderService.delete(id);
        return new ResponseEntity("{\"status\":\"suscess\"}", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid OrderRequest request, Errors errors, HttpServletRequest httpServletRequest){
        CodeError<Order> response = new CodeError<>();
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

        Order order = new Order();
        order.setIsDelete(0);
        order.setNamaBarang(request.getNamaBarang());
        order.setKeterangan(request.getKeterangan());
        order.setJumlah(request.getJumlah());
        order.setNamaPemesan(request.getNamaPemesan());
        order.setAlamatPemesan(request.getAlamatPemesan());
        order.setTanggalPemesanan(request.getTanggalPemesanan());

        UUID uuid = UUID.randomUUID();

        order.setNomorRegistrasi(uuid.toString());

        try {
            Order cust = orderService.save(order);
            response.setData(cust);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Valid OrderRequest request, @RequestParam("nomorRegistrasi") String nomorRegistrasi, Errors errors, HttpServletRequest httpServletRequest) {

        CodeError<Order> response = new CodeError();
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

        Optional<Order> orderOptional = orderService.findByNomorRegistrasi(nomorRegistrasi);

        if (!orderOptional.isPresent()) {
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

        Order order = orderOptional.get();
        order.setNamaBarang(request.getNamaBarang());
        order.setKeterangan(request.getKeterangan());
        order.setJumlah(request.getJumlah());
        order.setNamaPemesan(request.getNamaPemesan());
        order.setAlamatPemesan(request.getAlamatPemesan());
        order.setTanggalPemesanan(request.getTanggalPemesanan());

        Order ref = orderService.save(order);
        response.setData(ref);
        return new ResponseEntity(response, HttpStatus.OK);

    }


    @PutMapping("/update/total")
    public ResponseEntity<Object> update(@RequestBody @Valid OrderTotalRequest request, @RequestParam("nomorRegistrasi") String nomorRegistrasi, Errors errors, HttpServletRequest httpServletRequest) {

        CodeError<Order> response = new CodeError();
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

        Optional<Order> orderOptional = orderService.findByNomorRegistrasi(nomorRegistrasi);

        if (!orderOptional.isPresent()) {
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

        Order order = orderOptional.get();
        order.setJumlah(request.getJumlah());

        Order ref = orderService.save(order);
        response.setData(ref);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
