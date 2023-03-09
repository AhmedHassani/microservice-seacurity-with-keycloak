package com.iraqsofit.speedoo.repository;

import com.iraqsofit.speedoo.models.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByUsername(String username, Pageable pageable);
}
