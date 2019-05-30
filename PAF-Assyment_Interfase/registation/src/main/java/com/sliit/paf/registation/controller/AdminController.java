package com.sliit.paf.registation.controller;


import com.sliit.paf.registation.dto.Admindto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sliit.paf.registation.service.custom.adminService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping ("api/v1/admin")
public class AdminController {
    @Autowired
    private adminService AdminService;

    @GetMapping
    public ResponseEntity<List<Admindto>> findAllAdmins(){

        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<Admindto> admins = AdminService.getAdminDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", admins.size() + "");
        System.out.println(admins);
        return new ResponseEntity<List<Admindto>>(admins, httpHeaders, HttpStatus.OK);


    }

    @GetMapping("/{id:u\\d{3}}")
    public Admindto findAdmins(@PathVariable("id") String cId) {
        Admindto admin = AdminService.findAdminDetails(cId);
        return admin;
    }

    @DeleteMapping("/{id:u\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdmins(@PathVariable("id") String cId) {
        AdminService.deleteAdminDetails(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAdmin(@RequestBody Admindto Admindto) {
        AdminService.createAdminDetails(Admindto);
        return Admindto.getUserID();
    }

    @PutMapping(value = "/{id:u\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAdmins(@PathVariable("id") String cId, @RequestBody Admindto Admindto) {
        if (cId.equals(Admindto.getUserID())) {
            AdminService.updateAdminDetails(Admindto);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
