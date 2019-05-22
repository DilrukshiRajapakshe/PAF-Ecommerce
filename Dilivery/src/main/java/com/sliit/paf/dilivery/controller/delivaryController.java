package com.sliit.paf.dilivery.controller;

import com.sliit.paf.dilivery.dto.delivaryDTO;
import com.sliit.paf.dilivery.service.custom.ManageDelivaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/Deliver")
public class delivaryController {

    @Autowired
    private ManageDelivaryService delivaryService;
    @GetMapping
    public ResponseEntity<List<delivaryDTO>> findAlldelivarys(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<delivaryDTO> delivarys = delivaryService.getdelivarys();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",delivarys.size() + "");
        System.out.println(delivarys);
        return new ResponseEntity<List<delivaryDTO>>(delivarys,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:D\\d{3}}")
    public delivaryDTO finddelivary(@PathVariable("id") String cId){
        delivaryDTO delivary = delivaryService.finddelivary(cId);
        return delivary;
    }

    @DeleteMapping("/{id:D\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deletedelivary(@PathVariable("id") String cId){
        delivaryService.deletedelivary(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public int savedelivary(@RequestBody delivaryDTO delivaryDTO){
        delivaryService.createdelivary(delivaryDTO);
        return delivaryDTO.getDelivary_id();
    }

    @PutMapping(value = "/{id:D\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatedelivary(@PathVariable("id") String cId, @RequestBody delivaryDTO delivaryDTO){
        if (cId.equals(delivaryDTO.getDelivary_id())){
            delivaryService.updatedelivary(delivaryDTO);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
