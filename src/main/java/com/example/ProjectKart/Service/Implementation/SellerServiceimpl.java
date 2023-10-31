package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.SellerRequest;
import com.example.ProjectKart.DTO.ResponseDTO.SellerResponse;
import com.example.ProjectKart.Repository.SellerRepository;
import com.example.ProjectKart.Service.SellerService;
import com.example.ProjectKart.Transformer.DTOToEntity.DtoToSeller;
import com.example.ProjectKart.Transformer.EntityToDTO.SellerToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceimpl implements SellerService {
    @Autowired
    SellerRepository srep;
    public SellerResponse add(SellerRequest dto){
        return SellerToDto.sellerToDto(srep.save(DtoToSeller.dtoToSeller(dto)));
    }
}
