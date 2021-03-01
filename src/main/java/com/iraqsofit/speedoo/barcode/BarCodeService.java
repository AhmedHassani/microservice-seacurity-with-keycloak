package com.iraqsofit.speedoo.barcode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarCodeService {

    @Autowired
    private BarCodeRepository repository;

    public List<BarCode> FindAll() {
        return repository.findAll();
    }

    public BarCode getBarCode(long id) {
        return repository.findById(id).get();
    }

    public boolean deleteBarCode(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    public BarCode InsertBarCode(BarCode model) {
        return repository.save(model);
    }

    public BarCode updateBarCode(BarCode barCode, long id) {
        BarCode oldBarCode = repository.findById(id).get();
        barCode.setId(oldBarCode.getId());
        return repository.save(barCode);
    }


}
