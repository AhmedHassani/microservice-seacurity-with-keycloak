package com.iraqsofit.speedoo.itemuint;


import com.iraqsofit.speedoo.items.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UnitService {
    @Autowired
    private UnitRepository repository;

    public List<Unit> getAll(){
        return repository.findAll();
    }

    public List<Unit>getByItemCode(long item_code){
        return repository.findByItemCode(item_code);
    }

    public Unit getUnit(long id){
        return repository.findById(id).get();
    }

    public boolean deleteUnit(long id){
        if (repository.existsById(id)){repository.deleteById(id);return true;}
        return false;
    }

    public Unit InsertUnit(Unit unit){
        return repository.save(unit);
    }


    public Unit updateUnit(Unit unit ,long uintId){
        Unit oldUnit=repository.findById(uintId).get();
        unit.setUNIT_GUID(oldUnit.getUNIT_GUID());
        return repository.save(unit);
    }




}
