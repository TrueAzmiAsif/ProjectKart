package com.example.ProjectKart.Controller;

import com.example.ProjectKart.DTO.RequestDTO.CardRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CardResponse;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardServ;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CardRequest cardReq){
        CardResponse cardrResp=null;
        try{
            cardrResp=cardServ.add(cardReq);
        }
        catch(CustomerNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_ACCEPTABLE);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity(cardrResp, HttpStatus.CREATED);
    }
}
