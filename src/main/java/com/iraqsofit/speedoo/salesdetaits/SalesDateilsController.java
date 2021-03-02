package com.iraqsofit.speedoo.salesdetaits;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/salesdetails")
public class SalesDateilsController {

    @Autowired
    private SalesDateilsService service;

    @GetMapping("/get")
    public ResponseEntity<List<SalesDetails>> getAll() {
        return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SalesDetails> get(@PathVariable(value = "id") long id) {
        return new ResponseEntity<SalesDetails>(service.getSalesDateils(id), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.deleteSalesDateils(id), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/post")
    public ResponseEntity<SalesDetails> Add(@RequestBody SalesDetails model) {
        return new ResponseEntity<>(service.InsertSalesDateils(model), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<SalesDetails> update(@RequestBody SalesDetails model, @PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.updateSalesDateils(model, id), HttpStatus.CREATED);
    }


}
