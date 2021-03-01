package com.iraqsofit.speedoo.storebox;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping("/get")
    public ResponseEntity<List<StoreBox>> getAll(){
        return new  ResponseEntity<>(service.FindAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StoreBox> getStore(@PathVariable(value = "id") long id){
        return  new ResponseEntity<>(service.getStoreBox(id),HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteStore(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(service.deleteStoreBox(id),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<StoreBox> AddStoreBox(@RequestBody StoreBox storeBox){
        return new ResponseEntity<>(service.InsertStoreBox(storeBox),HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<StoreBox> updateStoreBox(@RequestBody StoreBox storeBox,@PathVariable(value = "id") long id){
        return new ResponseEntity<>(service.updateStoreBox(storeBox,id),HttpStatus.OK);
    }



}
