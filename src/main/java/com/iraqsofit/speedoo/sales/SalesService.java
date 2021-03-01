package com.iraqsofit.speedoo.sales;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository repository;

    public List<Sales> FindAll() {
        return repository.findAll();
    }

    public Sales getSales(String id) {
        return repository.findById(id).get();
    }

    public boolean deleteSales(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    public Sales InsertSales(Sales model) {
        return repository.save(model);
    }

    public Sales updateSales(Sales model, String id) {
        Sales oldModel = repository.findById(id).get();
        model.setId(oldModel.getId());
        return repository.save(model);
    }


}
