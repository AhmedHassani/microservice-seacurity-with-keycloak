package com.iraqsofit.speedoo.sales;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/sales")
public class SalesController {

    @Autowired
    private SalesService service;

    @GetMapping("/get")
    public ResponseEntity<List<Sales>> getAll() {
        return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Sales> getSales(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(service.getSales(id), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteSales(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(service.deleteSales(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Sales> AddSales(@RequestBody Sales model) {
        return new ResponseEntity<>(service.InsertSales(model), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Sales> updateSales(@RequestBody Sales model, @PathVariable(value = "id") String id) {
        return new ResponseEntity<>(service.updateSales(model, id), HttpStatus.OK);
    }


}
