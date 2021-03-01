package com.iraqsofit.speedoo.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ItemRepository extends JpaRepository<Items,Integer> {
    Items findByItemBarcode(String  barcode);
    Items findById(int id);
}
