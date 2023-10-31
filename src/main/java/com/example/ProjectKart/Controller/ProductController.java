package com.example.ProjectKart.Controller;

import com.example.ProjectKart.DTO.RequestDTO.ProductRequest;
import com.example.ProjectKart.DTO.ResponseDTO.ProductResponse;
import com.example.ProjectKart.Enum.Category;
import com.example.ProjectKart.Exception.SellerNotRegisteredException;
import com.example.ProjectKart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService pserv;
    @GetMapping("/findByCategory")
    public ResponseEntity findByCategory(@RequestParam("category") Category cat){
        return new ResponseEntity(pserv.findByCategory(cat),HttpStatus.CREATED);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ProductRequest dto){
        ProductResponse pres=null;
        try{
            pres=pserv.add(dto);
        }
        catch(SellerNotRegisteredException e){
            return new ResponseEntity(e, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(pres, HttpStatus.CREATED);
    }


}
