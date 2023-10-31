package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.CheckoutRequest;
import com.example.ProjectKart.DTO.RequestDTO.ItemRequest;
import com.example.ProjectKart.DTO.ResponseDTO.CartResponse;
import com.example.ProjectKart.DTO.ResponseDTO.ItemResponse;
import com.example.ProjectKart.DTO.ResponseDTO.OrderResponse;
import com.example.ProjectKart.Enum.ProductStatus;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Exception.EmptyCartException;
import com.example.ProjectKart.Exception.InvalidCardException;
import com.example.ProjectKart.Model.*;
import com.example.ProjectKart.Repository.*;
import com.example.ProjectKart.Service.CartService;
import com.example.ProjectKart.Service.OrderService;
import com.example.ProjectKart.Transformer.DTOToEntity.DtoToItem;
import com.example.ProjectKart.Transformer.EntityToDTO.CartToDto;
import com.example.ProjectKart.Transformer.EntityToDTO.ItemtoDto;
import com.example.ProjectKart.Transformer.EntityToDTO.OrderToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepo;

    @Autowired
    ProductRepository proRepo;
    @Autowired
    CustomerRepository custRepo;

    @Autowired
    CardRepository cardRepo;

    @Autowired
    OrderServiceImpl ordServ;

    @Autowired
    OrderRepository ordRepo;
    public Cart create(Customer cust){
        return Cart.builder()
                .cartTotal(0)
                .customer(cust)
                .build();
    }
    public CartResponse addItemToCart(Item item, ItemRequest itemReq){
        Customer cust=custRepo.findByNumber(itemReq.getCustContact());
        Product pro=proRepo.findById(itemReq.getProductId()).get();
        Cart cart=cust.getCart();
        cart.getItems().add(item);
        item.setCart(cart);
        item.setProduct(pro);
        List<ItemResponse> li=new ArrayList<>();
        for(Item x: cart.getItems()){
            li.add(ItemtoDto.itemToDto(x));
        }
        int cartTot=item.getReqQuantity()*item.getProduct().getPrice();
        cart.setCartTotal(cart.getCartTotal()+cartTot);
        Cart savedCart=cartRepo.save(cart);
        pro.getItems().add(savedCart.getItems().get(cart.getItems().size()-1));
        CartResponse cartResp=CartToDto.cartToDto(savedCart,item,li);
        return cartResp;
    }

    public OrderResponse checkout(CheckoutRequest checkout) throws CustomerNotFoundException, InvalidCardException, EmptyCartException {
        Customer cust=custRepo.findByNumber(checkout.getContact());
        if(cust==null){
            throw new CustomerNotFoundException("OOPS! unregistered customer, Please sign in or register with us.");
        }
        Card card=cardRepo.findByNumber(checkout.getCardNumber());
        Date date=new Date();
        if(card==null || !card.getCvv().equalsIgnoreCase(checkout.getCvv()) || date.after(card.getExp())){
            throw new InvalidCardException("Sorry! This card cannot be used.");
        }
        Cart cart=cust.getCart();
        if(cart.getItems().size()==0)throw new EmptyCartException("Sorry! The cart is empty");
        //List<ItemResponse> itemResp=new ArrayList<>();


        Ordered order= ordServ.order(card,cart);
        for(Item item: cart.getItems()){
            item.setOrdered(order);
        }
        resetCart(cart);
        Ordered created=ordRepo.save(order);
        cust.getOrders().add(created);

        return OrderToDto.orderToDto(order);
    }
    public void resetCart(Cart cart){
        cart.setCartTotal(0);
        for(Item item: cart.getItems()){
            item.setCart(null);
        }
        cart.setItems(new ArrayList<>());
    }
}
