package com.iraqsofit.speedoo.service;

import com.iraqsofit.speedoo.exception.NotFoundException;
import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.repository.OrdersRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductsService productsService;


    public Orders initOrder(RequestInitOrders initOrders) {
        List<ProductsModel> productsModels  =new ArrayList<>();
        double totalPrice = 0.0 ;
        double price = 0.0;
        if(initOrders.getUsername().isEmpty()){
            throw new NotFoundException("username not found !");
        }
        if(initOrders.getOrderItemList().isEmpty()){
            throw new NotFoundException("empty order ");
        }
        Orders orders = new Orders();
        orders.setUsername(initOrders.getUsername());
        orders.setStatesOrder("1");
        orders.setAddressId(initOrders.getAddressId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-DD-MM HH:MM:SS");
        String date = simpleDateFormat.format(initOrders.getDate());
        orders.setDate(date);
        orders.setDiscountCode(initOrders.getDiscountCode());
        orders.setNote(initOrders.getNote());
        orders.setMassage("الطلب قيد المراجعة، شكرا");
        for (OrderItem orderItem : initOrders.getOrderItemList()){
            ProductsModel product = productsService.getProduct(orderItem.getProductId());
            price += (product.getPrice() * (1-product.getDiscount())) * orderItem.getQuantityItemInOrder();
            totalPrice += product.getPrice() * orderItem.getQuantityItemInOrder();
            productsModels.add(product);
        }
        if(checkCode(initOrders.getDiscountCode())==true){
            totalPrice = totalPrice * (1-0.50);
            orders.setTotalPrice(totalPrice);
        }else {
            orders.setTotalPrice(totalPrice);
        }
        orders.setPrice(price);
        orders.setOrderItems(initOrders.getOrderItemList());
        return ordersRepository.save(orders);
    }

    private boolean checkCode(String code) {
        ArrayList codes = new ArrayList();
        codes.add("0.50TX");
        codes.add("0.65TX");
        codes.add("0.25TX");
        if(codes.contains(code)){
            return true;
        }
        return false;
    }

    public  List<Orders> ListOrder(String username,Integer pageNo, Integer pageSize, String sortBy){
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return  ordersRepository.findAllByUsername(username,pageable);
    }

    public boolean deleteOrder(long id){
        if(ordersRepository.existsById(id)){
            ordersRepository.delete(ordersRepository.findById(id).get());
            return true;
        }
        return false;
    }

        public Orders updateOrderPayment(String path,long id){
        if(ordersRepository.existsById(id)){
            Orders order = ordersRepository.findById(id).get();
            order.setPaymentType("ZAINCASH");
            order.setZcImage(path);
            order.setStatesOrder("2");
            return ordersRepository.save(order);
        }else {
            throw new NotFoundException("this order not found !");
        }
    }


    public Orders updateOrderCancel(long id) {
        if(ordersRepository.existsById(id)){
            Orders order = ordersRepository.findById(id).get();
            order.setStatesOrder("0");
            return ordersRepository.save(order);
        }else {
            throw new NotFoundException("this order not found !");
        }
    }
}
