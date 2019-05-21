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
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private ManagePaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAllpayment(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<PaymentDTO> payment = paymentService.getPayments();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",payment.size() + "");
        System.out.println(payment);
        return new ResponseEntity<List<PaymentDTO>>(payment,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:P\\d{3}}")
    public PaymentDTO findpayment(@PathVariable("id") String cId){
        PaymentDTO payment = paymentService.findPayment(cId);
        return payment;
    }

    @DeleteMapping("/{id:P\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deletepayment(@PathVariable("id") String cId){
        paymentService.deletePayment(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String savepayment(@RequestBody PaymentDTO paymentDTO){
        paymentService.createPayment(paymentDTO);
        return paymentDTO.getId();
    }

    @PutMapping(value = "/{id:P\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatepaymentDTO(@PathVariable("id") String cId, @RequestBody PaymentDTO paymentDTO){
       if (cId.equals(paymentDTO.getId())){
           paymentService.updatePayment(paymentDTO);
           return new ResponseEntity(HttpStatus.OK);
       }else {
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/{id:C\\d{3}}")
    public ResponseEntity<List<PaymentDTO>> findpaymentForEachPerson(@PathVariable("id") String cId){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<PaymentDTO> payment = paymentService.findEachPayment(cId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",payment.size() + "");
        System.out.println(payment);
        return new ResponseEntity<List<PaymentDTO>>(payment,httpHeaders, HttpStatus.OK);
    }

}
