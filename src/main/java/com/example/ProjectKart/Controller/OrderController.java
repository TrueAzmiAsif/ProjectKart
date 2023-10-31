package com.example.ProjectKart.Controller;

import com.example.ProjectKart.DTO.RequestDTO.CheckoutRequest;
import com.example.ProjectKart.DTO.RequestDTO.OrderRequest;
import com.example.ProjectKart.DTO.ResponseDTO.OrderResponse;
import com.example.ProjectKart.Exception.*;
import com.example.ProjectKart.Service.CartService;
import com.example.ProjectKart.Service.Implementation.CartServiceImpl;
import com.example.ProjectKart.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderServ;

    @Autowired
    CartServiceImpl cartServ;
    @PostMapping("/buynow")
    public ResponseEntity buyNow(@RequestBody OrderRequest dto){
        //System.out.println("In controller "+dto.getCustomerContact());
        OrderResponse ordResp=null;
        try{
            ordResp=orderServ.order(dto);
        } catch (StockShortageException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (InvalidCardException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity(ordResp, HttpStatus.ACCEPTED);
    }

    @PostMapping("/checkout")
    public ResponseEntity checkout(@RequestBody CheckoutRequest dto){
        OrderResponse ordResp=null;
        try{
            ordResp=cartServ.checkout(dto);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.FORBIDDEN);
        } catch (InvalidCardException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.FORBIDDEN);
        } catch (EmptyCartException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(ordResp,HttpStatus.CREATED);
    }
}
