package com.iraqsofit.speedoo.service;

import com.iraqsofit.speedoo.models.Orders;
import com.iraqsofit.speedoo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;
    public Orders initOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

}
