package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.OrderRequest;
import com.example.ProjectKart.DTO.ResponseDTO.OrderResponse;
import com.example.ProjectKart.Enum.ProductStatus;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Exception.InvalidCardException;
import com.example.ProjectKart.Exception.ProductNotFoundException;
import com.example.ProjectKart.Exception.StockShortageException;
import com.example.ProjectKart.Model.*;
import com.example.ProjectKart.Repository.CustomerRepository;
import com.example.ProjectKart.Repository.OrderRepository;
import com.example.ProjectKart.Repository.ProductRepository;
import com.example.ProjectKart.Service.CustomerService;
import com.example.ProjectKart.Service.OrderService;
import com.example.ProjectKart.Service.ProductService;
import com.example.ProjectKart.Transformer.DTOToEntity.DtoToOrder;
import com.example.ProjectKart.Transformer.DTOToEntity.OrderDTOToItemEntity;
import com.example.ProjectKart.Transformer.EntityToDTO.OrderToDto;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    CustomerRepository custRepo;

    @Autowired
    ProductRepository prodRepo;
    @Autowired
    OrderRepository ordRepo;
    public OrderResponse order(OrderRequest orderReq) throws CustomerNotFoundException, ProductNotFoundException, InvalidCardException, StockShortageException {
        //System.out.println(orderReq.getCustomerContact());
        Customer cust=custRepo.findByNumber(orderReq.getCustomerContact());
        if(cust==null){
            throw new CustomerNotFoundException("OOPs! You are not registered with us!");
        }
        Optional<Product> optProd=prodRepo.findById(orderReq.getProductId());
        if(optProd.isEmpty()){
            throw new ProductNotFoundException("Sorry! Invalid product requested");
        }
        Card cardUsed=null;
        boolean flag=false;
        for(Card card: cust.getCards()){
            //System.out.println("=========+++++++++========================="+card.getNumber());
            if(card.getNumber().equalsIgnoreCase(orderReq.getCardNumber())){
                flag=true;
                //System.out.println("=========+++++++++========================="+flag);
                if(card.getCvv().equalsIgnoreCase(orderReq.getCvv())){
                    cardUsed=card;
                }
                else{
                    throw new InvalidCardException("Sorry! The card cannot be used");
                }
            }
        }
        if(!flag){
            throw new InvalidCardException("Sorry! The card cannot be used");
        }
        Date date=new Date();
        if(date.after(cardUsed.getExp()))throw new InvalidCardException("Sorry! The card cannot be used");

        Product prod=optProd.get();
        if(prod.getQuantity()<orderReq.getQuantity())throw new StockShortageException("Sorry! we dont have the required quantity in stock.");
        int newQuant=prod.getQuantity()-orderReq.getQuantity();
        prod.setQuantity(newQuant);
        if(prod.getQuantity()==0)prod.setStatus(ProductStatus.OUT_OF_STOCK);

        List<Item> items=new ArrayList<>();
        Item item=OrderDTOToItemEntity.orderDTOToItemEntity(orderReq,prod);
        items.add(item);
        Ordered order= DtoToOrder.DtoToOrder(orderReq,prod,cardUsed,items,cust);
        item.setOrdered(order);
        Ordered savedOrder=ordRepo.save(order);
        cust.getOrders().add(savedOrder);
        prod.getItems().add(savedOrder.getItems().get(0));
        return OrderToDto.orderToDto(savedOrder);
    }

    public Ordered order(Card card, Cart cart){
        String cardUsed="XXXX XXXX XXXX ";
        String temp[]=card.getNumber().split(" ");
        cardUsed+=temp[3];
        int grandTotal=0,grandQuant=0;
        for(Item item:cart.getItems()){
            Product prod=item.getProduct();
            grandTotal+=(item.getReqQuantity()* prod.getPrice());
            grandQuant+= item.getReqQuantity();
            int newQuant=prod.getQuantity()-item.getReqQuantity();
            prod.setQuantity(newQuant);
            if(prod.getQuantity()==0)prod.setStatus(ProductStatus.OUT_OF_STOCK);
            //proRepo.save(prod);
//            itemResp.add(ItemtoDto.itemToDto(item));
        }
        Ordered order=Ordered.builder()
                .orderNumber(UUID.randomUUID().toString())
                .total(grandTotal)
                .quantity(grandQuant)
                .items(cart.getItems())
                .customer(cart.getCustomer())
                .cardUsed(cardUsed)
                .build();
        return order;
    }
}
