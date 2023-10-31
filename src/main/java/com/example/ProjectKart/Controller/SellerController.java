package com.example.ProjectKart.Controller;

import com.example.ProjectKart.DTO.RequestDTO.CustomerRequest;
import com.example.ProjectKart.DTO.RequestDTO.SellerRequest;
import com.example.ProjectKart.Service.CustomerService;
import com.example.ProjectKart.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sServ;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody SellerRequest dto){
        return new ResponseEntity(sServ.add(dto), HttpStatus.CREATED);
    }
}
