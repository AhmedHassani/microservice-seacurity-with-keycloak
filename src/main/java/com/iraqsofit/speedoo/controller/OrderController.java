package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.LastOrder;
import com.iraqsofit.speedoo.models.Media;
import com.iraqsofit.speedoo.models.Orders;
import com.iraqsofit.speedoo.models.ProductsModel;
import com.iraqsofit.speedoo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/api/gemstone/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/initOrder")
    public ResponseEntity initOrder(@Valid Orders orders) {
        return new ResponseEntity(orderService.initOrder(orders), HttpStatus.CREATED);
    }


    @GetMapping(value = {"/lastOrder/{username}"})
    public ResponseEntity pushNotification(@PathVariable String username){
        List<ProductsModel> productsModelList = new ArrayList<>();
        Date date =null;
        Media media = new Media("https://upload.wikimedia.org/wikipedia/commons/b/b6/Ring_Ruby.jpg", "IMAGE");
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-28");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Media> mySet = new HashSet<>();
        mySet.add(media);
        productsModelList.add(new ProductsModel(1, "products1", "test products1 products1", date, "category", 5000.0, 3, 0.3, 3, mySet));
        productsModelList.add(new ProductsModel(2, "products1", "test products1 products1", date, "category", 5000.0, 3, 0.3, 3, mySet));
        productsModelList.add(new ProductsModel(3, "products1", "test products1 products1", date, "category", 5000.0, 3, 0.3, 3, mySet));
        List<LastOrder> lastOrder = new ArrayList();
        lastOrder.add(new LastOrder(1, username, 1, " بغداد - المنصور - ابوجعفر المنصور", "2023-02-28 16:22:27", 25000, 0.5, 24000, productsModelList, "لقد تم إكمال الطلب وتسليم المنتجات المطلوبة، شكرا لكم"));
        lastOrder.add(new LastOrder(3, username, 2, " بغداد - المنصور - ابوجعفر المنصور", "2023-02-28 16:22:27", 25000, 0.5, 24000, productsModelList, "لم يتم قبول الطلب وذلك بسبب عدم إكمال عملية الدفع"));
        lastOrder.add(new LastOrder(3, username, 0, " بغداد - المنصور - ابوجعفر المنصور", "2023-02-28 16:22:27", 25000, 0.5, 24000, productsModelList, "لقد تم إكمال الطلب وتسليم المنتجات المطلوبة، شكرا لكم"));
        return new ResponseEntity(lastOrder,HttpStatus.OK
        );
    }


}
