package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.ProductRequest;
import com.example.ProjectKart.DTO.ResponseDTO.ProductResponse;
import com.example.ProjectKart.Enum.Category;
import com.example.ProjectKart.Enum.ProductStatus;
import com.example.ProjectKart.Exception.SellerNotRegisteredException;
import com.example.ProjectKart.Model.Product;
import com.example.ProjectKart.Model.Seller;
import com.example.ProjectKart.Repository.ProductRepository;
import com.example.ProjectKart.Repository.SellerRepository;
import com.example.ProjectKart.Service.ProductService;
import com.example.ProjectKart.Transformer.DTOToEntity.DtoToProduct;
import com.example.ProjectKart.Transformer.EntityToDTO.ProductToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository prepo;
    @Autowired
    SellerRepository srepo;

    public List<ProductResponse> findByCategory(Category cat){
        List<Product> li=prepo.findByCategory(cat);
        List<ProductResponse> respList=new ArrayList<>();
        for(Product x: li){
            respList.add(ProductToDto.productToDto(x,"NA"));
        }
        return respList;
    }
    public ProductResponse add(ProductRequest dto)throws SellerNotRegisteredException{
        Product pro=null;
        Seller sell=srepo.findByContact(dto.getSellerContact());
        List<Product> proList=prepo.findByNameAndCategory(dto.getName(), dto.getCategory());
        for(Product x: proList){if(x.getSeller().getId()==sell.getId())pro=x;}
        if(sell==null){
            throw new SellerNotRegisteredException("The seller's contact number is not registered with us");
        }
        else {
            if(pro==null){
                pro=DtoToProduct.dtoToProduct(dto,sell);
//                System.out.print("helloo"+pro);
                sell.getProducts().add(pro);
            }
            else{
                pro.setQuantity(pro.getQuantity()+ dto.getQuantity());
                pro.setStatus(ProductStatus.IN_STOCK);
                for(Product x: sell.getProducts()){
                    if(x.getId()==pro.getId()){
                        sell.getProducts().remove(x);
                        sell.getProducts().add(pro);
                    }
                }
            }
        }
        srepo.save(sell);
        return ProductToDto.productToDto(pro,"Product has been successfully added to the inventory");
    }


}
