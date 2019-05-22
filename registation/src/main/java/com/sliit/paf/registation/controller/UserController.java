package com.sliit.paf.registation.controller;



import com.sliit.paf.registation.dto.Userdto;
import com.sliit.paf.registation.service.custom.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private userService UserService;

    @GetMapping
    public ResponseEntity<List<Userdto>> findAllUsers(){

        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<Userdto> users = UserService.getUserDetails();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", users.size() + "");
        System.out.println(users);
        return new ResponseEntity<List<Userdto>>(users, httpHeaders, HttpStatus.OK);

    }

    @GetMapping("/{id:u\\d{3}}")
    public Userdto findUsers(@PathVariable("id") String cId) {
        Userdto users = UserService.findUserDetails(cId);
        return users;
    }

    @DeleteMapping("/{id:u\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsers(@PathVariable("id") String cId) {
        UserService.deleteUserDetails(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody Userdto Userdto) {
        UserService.createUserDetails(Userdto);
        return Userdto.getUserID();
    }

    @PutMapping(value = "/{id:u\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUsers(@PathVariable("id") String cId, @RequestBody Userdto Userdto) {
        if (cId.equals(Userdto.getUserID())) {
            UserService.updateUserDetails(Userdto);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
