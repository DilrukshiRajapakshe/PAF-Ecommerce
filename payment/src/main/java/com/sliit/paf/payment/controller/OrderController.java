package com.sliit.paf.payment.controller;

import com.sliit.paf.payment.dto.OrderDetailDTO;
import com.sliit.paf.payment.service.custom.ManageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private ManageOrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> findAllOrders(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<OrderDetailDTO> customers = orderService.getOrderDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",customers.size() + "");
        System.out.println(customers);
        return new ResponseEntity<List<OrderDetailDTO>>(customers,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:C\\d{3}}")
    public OrderDetailDTO findOrders(@PathVariable("id") String cId){
        OrderDetailDTO customer = orderService.findOrderDetail(cId);
        return customer;
    }

    @DeleteMapping("/{id:C\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrders(@PathVariable("id") String cId){
        orderService.deleteOrderDetail(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody OrderDetailDTO customerDTO){
        orderService.createOrderDetail(customerDTO);
        return customerDTO.getOrderId();
    }

    @PutMapping(value = "/{id:C\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrders(@PathVariable("id") String cId, @RequestBody OrderDetailDTO orderDTO){
       if (cId.equals(orderDTO.getOrderId())){
           orderService.updateOrderDetail(orderDTO);
           return new ResponseEntity(HttpStatus.OK);
       }else {
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    }

}
