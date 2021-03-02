package com.iraqsofit.speedoo.items;
import com.iraqsofit.speedoo.exception.BadRequest;
import com.iraqsofit.speedoo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ItemService {
    @Autowired
    private  ItemRepository repository;

    public List<Items> getAll(){
        return repository.findAll();
    }

    public Items getItem(int id){
        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException exception){
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        }
    }

    public Items getItemByBarCode(String  barcode){
        return repository.findByItemBarcode(barcode);
    }

    public Items addItem(Items items){
        return repository.save(items);
    }

    public  boolean  deleteItem(int id){
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            }
        }catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        }catch (HttpClientErrorException.BadRequest exception){
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    public Items updateItem(int id,Items items){
        Items uItem = null;
        try {
            uItem=repository.findById(id).get();
        }catch (NoSuchElementException exception){
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        }
        items.setItemCode(uItem.getItemCode());
        return repository.save(items);
    }




}
