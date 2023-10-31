package com.example.ProjectKart.Controller;

import com.example.ProjectKart.DTO.RequestDTO.CustomerRequest;
import com.example.ProjectKart.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService cServ;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CustomerRequest reqDTO){
        return new ResponseEntity(cServ.add(reqDTO), HttpStatus.CREATED);
    }
}
