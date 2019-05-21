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
    private ManageOrderService manageOrderService;

    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> findAllOrders(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<OrderDetailDTO> orders = manageOrderService.getOrderDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",orders.size() + "");
        System.out.println(orders);
        return new ResponseEntity<List<OrderDetailDTO>>(orders,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:O\\d{3}}")
    public OrderDetailDTO findOrders(@PathVariable("id") String cId){
        OrderDetailDTO orderDetail = manageOrderService.findOrderDetail(cId);
        return orderDetail;
    }

    @DeleteMapping("/{id:O\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrders(@PathVariable("id") String cId){
        manageOrderService.deleteOrderDetail(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveOrders(@RequestBody OrderDetailDTO orderDetailDTO){
        manageOrderService.createOrderDetail(orderDetailDTO);
        return orderDetailDTO.getOrderId();
    }

    @PutMapping(value = "/{id:O\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrders(@PathVariable("id") String cId, @RequestBody OrderDetailDTO orderDetailDTO){
        if (cId.equals(orderDetailDTO.getOrderId())){
            manageOrderService.updateOrderDetail(orderDetailDTO);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
