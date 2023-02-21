package com.iraqsofit.speedoo.repository;
import com.iraqsofit.speedoo.models.ProductsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductsModel, Long> {
    List<ProductsModel> findByName(String name);
    Page<ProductsModel> findByCategory(String category, Pageable pageable);
    //Native Query
    List<ProductsModel> findByDiscountGreaterThan(Double discount,Pageable pageable);
    List<ProductsModel> findByNameContaining(String name, Pageable pageable);


}
