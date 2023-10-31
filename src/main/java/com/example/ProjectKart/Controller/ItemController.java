package com.example.ProjectKart.Controller;

import com.example.ProjectKart.DTO.RequestDTO.ItemRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CartResponse;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Exception.ProductIsOutOfStockException;
import com.example.ProjectKart.Exception.ProductNotFoundException;
import com.example.ProjectKart.Exception.StockShortageException;
import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Item;
import com.example.ProjectKart.Service.CartService;
import com.example.ProjectKart.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemServ;

    @Autowired
    CartService cartServ;
    @PostMapping("/add")
    public ResponseEntity addItemToCart(@RequestBody ItemRequest itemReq){
        Item item=null;
        try{
            item=itemServ.addItemToCart(itemReq);
        }
        catch(CustomerNotFoundException e){
            return new ResponseEntity(e, HttpStatus.FORBIDDEN);
        } catch (StockShortageException e) {
            return new ResponseEntity(e, HttpStatus.FORBIDDEN);
        } catch (ProductIsOutOfStockException e) {
            return new ResponseEntity(e, HttpStatus.FORBIDDEN);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(cartServ.addItemToCart(item,itemReq), HttpStatus.CREATED);
    }
}
