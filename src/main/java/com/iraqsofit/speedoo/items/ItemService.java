package com.iraqsofit.speedoo.items;
import com.iraqsofit.speedoo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return repository.findById(id);
    }

    public Items getItemByBarCode(String  barcode){
        return repository.findByItemBarcode(barcode);
    }

    public Items addItem(Items items){
        return repository.save(items);
    }

    public  boolean  deleteItem(int id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Items updateItem(int id,Items items){
        Items uItem=repository.findById(id);
        items.setItemCode(uItem.getItemCode());
        return repository.save(items);
    }




}
