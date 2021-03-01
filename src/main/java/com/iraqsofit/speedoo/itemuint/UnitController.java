package com.iraqsofit.speedoo.itemuint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iraqsoft/speedoo/api/v1/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/get")
    public ResponseEntity<List<Unit>> getAllUnits(){
        return new ResponseEntity<>(unitService.getAll(), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Unit> getUnit(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(unitService.getUnit(id), HttpStatus.OK);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<Boolean> DeleteUnit(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(unitService.deleteUnit(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Unit>  AddUnit(@RequestBody Unit unit){
        return new ResponseEntity(unitService.InsertUnit(unit),HttpStatus.OK);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<Unit>  updateUnit(@RequestBody  Unit unit,@PathVariable(value = "id") long id){
        return  new ResponseEntity<>(unitService.updateUnit(unit,id),HttpStatus.OK);
    }

    @GetMapping("itemcode/{code}")
    public ResponseEntity<List<Unit>> FindByItemCode(@PathVariable(value = "code") long code){
        return new ResponseEntity<>(unitService.getByItemCode(code),HttpStatus.OK);
    }

}
