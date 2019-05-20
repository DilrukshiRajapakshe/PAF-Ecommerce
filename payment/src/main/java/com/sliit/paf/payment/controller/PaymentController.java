package com.sliit.paf.payment.controller;

import com.sliit.paf.payment.dto.PaymentDTO;
import com.sliit.paf.payment.service.custom.ManagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
public class PaymentController {

    @Autowired
    private ManagePaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAllCustomers() {
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<PaymentDTO> customers = paymentService.getPayments();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", customers.size() + "");
        System.out.println(customers);
        return new ResponseEntity<List<PaymentDTO>>(customers, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:C\\d{3}}")
    public PaymentDTO findCustomer(@PathVariable("id") String cId) {
        PaymentDTO customer = paymentService.findPayment(cId);
        return customer;
    }

    @DeleteMapping("/{id:C\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") String cId) {
        paymentService.deletePayment(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody PaymentDTO customerDTO) {
        paymentService.createPayment(customerDTO);
        return customerDTO.getId();
    }

    @PutMapping(value = "/{id:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable("id") String cId, @RequestBody PaymentDTO paymentDTO) {
        if (cId.equals(paymentDTO.getId())) {
            paymentService.updatePayment(paymentDTO);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
