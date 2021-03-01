package com.iraqsofit.speedoo.salesdetaits;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesDateilsService {

    @Autowired
    private SalesDetailsRepository repository;

    public List<SalesDetails> FindAll() {
        return repository.findAll();
    }

    public SalesDetails getSalesDateils(long id) {
        return repository.findById(id).get();
    }

    public boolean deleteSalesDateils(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    public SalesDetails InsertSalesDateils(SalesDetails model) {
        return repository.save(model);
    }

    public SalesDetails updateSalesDateils(SalesDetails model, long id) {
        SalesDetails oldModel = repository.findById(id).get();
        model.setId(oldModel.getId());
        return repository.save(model);
    }


}
