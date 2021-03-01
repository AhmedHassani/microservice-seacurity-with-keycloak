package com.iraqsofit.speedoo.buydetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/buydetails")
public class BuyDetailsController {

    @Autowired
    private BuyDetailsService service;

    @GetMapping("/get")
    public ResponseEntity<List<BuyDetails>> getAll() {
        return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BuyDetails> getBuyDetails(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.getBuyDetails(id), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteBuyDetails(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.deleteBuyDetails(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<BuyDetails> AddBuyDetails(@RequestBody BuyDetails model) {
        return new ResponseEntity<>(service.InsertBuyDetails(model), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BuyDetails> updateBuyDetails(@RequestBody BuyDetails model, @PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.updateBuyDetails(model, id), HttpStatus.OK);
    }


}
