package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.CardRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CardResponse;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Model.Card;
import com.example.ProjectKart.Model.Customer;
import com.example.ProjectKart.Repository.CardRepository;
import com.example.ProjectKart.Repository.CustomerRepository;
import com.example.ProjectKart.Service.CardService;
import com.example.ProjectKart.Transformer.DTOToEntity.DtoToCard;
import com.example.ProjectKart.Transformer.EntityToDTO.CardToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepo;
    @Autowired
    CustomerRepository custRepo;
    public CardResponse add(CardRequest cardReq) throws ParseException, CustomerNotFoundException {
        Customer cust=custRepo.findByNumber(cardReq.getContact());
        if(cust==null){
            throw new CustomerNotFoundException("Sorry! The contact number of the customer is not registered with us!");
        }
        Card card= DtoToCard.dtoToCard(cardReq,cust);
        cust.getCards().add(card);
        custRepo.save(cust);
        return CardToDto.cardToDto(card,"The above mentioned card has been added successfully to your account");
    }
}
