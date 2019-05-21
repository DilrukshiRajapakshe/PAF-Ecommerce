package com.sliit.paf.wishlist.control;

import com.sliit.paf.wishlist.DTObject.wishlistDTO;
import com.sliit.paf.wishlist.service.custom.ManageWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/wish")
public class wishController {
    @Autowired
    private ManageWishlistService orderService;

    @GetMapping
    public ResponseEntity<List<wishlistDTO>> findAllOrders(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<wishlistDTO> customers = orderService.getwishlistDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",customers.size() + "");
        System.out.println(customers);
        return new ResponseEntity<List<wishlistDTO>>(customers,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{Icode:W\\d{3}}")
    public wishlistDTO findOrders(@PathVariable("Icode") String Icode){
        wishlistDTO customer = orderService.findWishlistDetails(Icode);
        return customer;
    }

    @DeleteMapping("/{id:W\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrders(@PathVariable("id") String cId){
        orderService.deletewishlistDetails(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody wishlistDTO customerDTO){
        orderService.createwishlistDetails(customerDTO);
        return customerDTO.getItemCode();
    }

    @PutMapping(value = "/{id:W\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrders(@PathVariable("id") String cId, @RequestBody wishlistDTO orderDTO){
        if (cId.equals(orderDTO.getItemCode())){
            orderService.updatewishlistDetails(orderDTO);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
