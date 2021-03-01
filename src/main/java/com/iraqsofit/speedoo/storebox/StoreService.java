package com.iraqsofit.speedoo.storebox;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public List<StoreBox> FindAll(){
        return repository.findAll();
    }

    public StoreBox getStoreBox(long id){
        return repository.findById(id).get();
    }

    public boolean deleteStoreBox(long id){
        if (repository.existsById(id)){repository.deleteById(id);return true;}
        return false;
    }


    public StoreBox InsertStoreBox(StoreBox storeBox){
        return repository.save(storeBox);
    }

    public StoreBox updateStoreBox(StoreBox storeBox , long id){
        StoreBox oldStoreBox=repository.findById(id).get();
        storeBox.setId(oldStoreBox.getId());
        return repository.save(storeBox);
    }



}
