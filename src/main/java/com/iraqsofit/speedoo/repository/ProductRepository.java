package com.iraqsofit.speedoo.repository;

import com.iraqsofit.speedoo.models.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductsModel, Long> {
    List<ProductsModel> findByName(String name);
}
