package com.iraqsofit.speedoo.repository;

import com.iraqsofit.speedoo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  OrdersRepository extends JpaRepository<Orders, Long> {

}
