package com.iraqsofit.speedoo.items;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/items")
public class ItemController {
    @Autowired
    private ItemService service;
    @GetMapping(value = {"","/"})
    public ResponseEntity  getAll(){
        return  new ResponseEntity(service.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Items getItem(@PathVariable(value = "id") int id){
        return  service.getItem(id);
    }
    @GetMapping("/barcode/{barcode}")
    public ResponseEntity getItemByBarCode(@PathVariable(value = "barcode") String barcode){
        return new ResponseEntity(service.getItemByBarCode(barcode),HttpStatus.OK);
    }
    @PostMapping(value ={"","/"})
    public ResponseEntity SaveItem(@RequestBody Items items){
        return new ResponseEntity(service.addItem(items),HttpStatus.CREATED);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteItem(@PathVariable(value = "id" ) int id){
        return new ResponseEntity(service.deleteItem(id),HttpStatus.NO_CONTENT);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity updateItem(@RequestBody Items items,@PathVariable(value = "id" ) int id){
        return new ResponseEntity(service.updateItem(id,items),HttpStatus.CREATED);
    }



}
