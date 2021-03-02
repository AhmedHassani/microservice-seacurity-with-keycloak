package com.iraqsofit.speedoo.barcode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/barcode")
public class Controller {

    @Autowired
    private BarCodeService service;

    @GetMapping("/get")
    public ResponseEntity<List<BarCode>> getAll() {
        return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BarCode> getBarCode(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.getBarCode(id), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteBarCode(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.deleteBarCode(id), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/post")
    public ResponseEntity<BarCode> AddBarCode(@RequestBody BarCode model) {
        return new ResponseEntity<>(service.InsertBarCode(model), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BarCode> updateBarCode(@RequestBody BarCode model, @PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.updateBarCode(model, id), HttpStatus.CREATED);
    }

}
