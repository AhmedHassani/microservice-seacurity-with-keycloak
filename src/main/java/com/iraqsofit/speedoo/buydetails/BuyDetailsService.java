package com.iraqsofit.speedoo.buydetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyDetailsService {

    @Autowired
    private BuyDetailsRepository repository;

    public List<BuyDetails> FindAll() {
        return repository.findAll();
    }

    public BuyDetails getBuyDetails(long id) {
        return repository.findById(id).get();
    }

    public boolean deleteBuyDetails(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    public BuyDetails InsertBuyDetails(BuyDetails model) {
        return repository.save(model);
    }

    public BuyDetails updateBuyDetails(BuyDetails model, long id) {
        BuyDetails oldModel = repository.findById(id).get();
        model.setId(oldModel.getId());
        return repository.save(model);
    }


}
