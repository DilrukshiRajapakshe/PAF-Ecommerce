package com.sliit.paf.registation.controller;


import com.sliit.paf.registation.dto.Customerdto;
import com.sliit.paf.registation.service.custom.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private customerService CoustomerService;

    @GetMapping
    public ResponseEntity<List<Customerdto>> findAllCustomers(){

        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<Customerdto> customers = CoustomerService.getCustomerDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", customers.size() + "");
        System.out.println(customers);
        return new ResponseEntity<List<Customerdto>>(customers, httpHeaders, HttpStatus.OK);


    }

    @GetMapping("/{id:u\\d{3}}")
    public Customerdto findCustomers(@PathVariable("id") String cId) {
        Customerdto customer = CoustomerService.findCustomerDetails(cId);
        return customer;
    }

    @DeleteMapping("/{id:u\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdmins(@PathVariable("id") String cId) {
        CoustomerService.deleteCustomerDetails(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody Customerdto Customerdto) {
        CoustomerService.createCustomerDetails(Customerdto);
        return Customerdto.getUserID();
    }

    @PutMapping(value = "/{id:u\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomers(@PathVariable("id") String cId, @RequestBody Customerdto Customerdto) {
        if (cId.equals(Customerdto.getUserID())) {
            CoustomerService.updateCustomerDetails(Customerdto);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
