package com.sliit.paf.payment.controller;

import com.sliit.paf.payment.dto.OrderDetailDTO;
import com.sliit.paf.payment.dto.PaymentDTO;
import com.sliit.paf.payment.service.custom.ManageOrderService;
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
        public ResponseEntity<List<PaymentDTO>> findAllPayments(){
            System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
            List<PaymentDTO> payments = paymentService.getPayments();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-Count",payments.size() + "");
            System.out.println(payments);
            return new ResponseEntity<List<PaymentDTO>>(payments,httpHeaders, HttpStatus.OK);
        }

        @GetMapping("/{id:O\\d{3}}")
        public PaymentDTO findPayments(@PathVariable("id") String cId){
            PaymentDTO paymentDTO = paymentService.findPayment(cId);
            return paymentDTO;
        }

        @DeleteMapping("/{id:O\\d{3}}")
        @ResponseStatus(HttpStatus.OK)
        public void deletePayment(@PathVariable("id") String cId){
            paymentService.deletePayment(cId);
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.CREATED)
        public String savePayment(@RequestBody PaymentDTO paymentDTO){
            paymentService.createPayment(paymentDTO);
            return paymentDTO.getId();
        }

        @PutMapping(value = "/{id:O\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity updatePayment(@PathVariable("id") String cId, @RequestBody PaymentDTO paymentDTO){
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
