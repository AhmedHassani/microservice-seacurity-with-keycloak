package com.iraqsofit.speedoo.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {

}
