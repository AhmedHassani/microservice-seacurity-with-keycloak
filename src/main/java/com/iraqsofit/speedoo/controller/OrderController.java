package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.service.NotificationService;
import com.iraqsofit.speedoo.service.OrderService;
import com.iraqsofit.speedoo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/gemstone/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    S3Service s3Service ;
    @PostMapping(value = "/initOrder")
    // Initializing an order.
    public ResponseEntity initOrder(@RequestBody  RequestInitOrders requestInitOrders,@RequestHeader("playerId") String playerId) {
        if(!playerId.isEmpty()){
            notificationService.sentNotification(playerId,false);
        }
        return  new ResponseEntity(orderService.initOrder(requestInitOrders),HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<Orders> upload(@RequestParam("file") MultipartFile multipartFile,@RequestParam("id") long id) {
        System.out.println("HIT -/upload | File Name : "+ multipartFile.getOriginalFilename());
        String uri = s3Service.upload(multipartFile);
        return new ResponseEntity<>(orderService.updateOrderPayment(uri,id),HttpStatus.OK);
    }



    @GetMapping(value = {"/cancel/{id}"})
    public ResponseEntity cancel(@PathVariable long id){
         return new ResponseEntity<>(orderService.updateOrderCancel(id),HttpStatus.OK);
    }


    @GetMapping(value = {"/lastOrder/{username}"})
    // A method that returns the last order of a user.
    public ResponseEntity lastOrder(
            @PathVariable String username,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity(orderService.ListOrder(username,pageNo,pageSize,sortBy),HttpStatus.OK);
    }


    @DeleteMapping(value = {"/delete/{id}"})
    // Deleting an order.
    public ResponseEntity delete(@PathVariable long id){
        return new ResponseEntity<>(orderService.deleteOrder(id),HttpStatus.OK);
    }
}
