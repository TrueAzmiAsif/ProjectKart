package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.CustomerRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CustomerResponse;
import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Customer;
import com.example.ProjectKart.Repository.CustomerRepository;
import com.example.ProjectKart.Service.CartService;
import com.example.ProjectKart.Service.CustomerService;
import com.example.ProjectKart.Transformer.DTOToEntity.DTOToCustomer;
import com.example.ProjectKart.Transformer.EntityToDTO.CustomerToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository cusRep;
    @Autowired
    CartService cartserv;
    public CustomerResponse add(CustomerRequest cReqDTO){
        Customer customer=DTOToCustomer.dTOToCustomer(cReqDTO);
        //customer=cusRep.save(customer);
        customer.setCart(cartserv.create(customer));
        return CustomerToDTO.customerToDTO(cusRep.save(customer));
    }
}
