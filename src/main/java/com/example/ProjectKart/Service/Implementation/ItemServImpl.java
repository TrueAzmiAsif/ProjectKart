package com.example.ProjectKart.Service.Implementation;

import com.example.ProjectKart.DTO.RequestDTO.ItemRequest;
import com.example.ProjectKart.Exception.CustomerNotFoundException;
import com.example.ProjectKart.Exception.ProductIsOutOfStockException;
import com.example.ProjectKart.Exception.ProductNotFoundException;
import com.example.ProjectKart.Exception.StockShortageException;
import com.example.ProjectKart.Model.Cart;
import com.example.ProjectKart.Model.Customer;
import com.example.ProjectKart.Model.Item;
import com.example.ProjectKart.Model.Product;
import com.example.ProjectKart.Repository.CustomerRepository;
import com.example.ProjectKart.Repository.ItemRepository;
import com.example.ProjectKart.Repository.ProductRepository;
import com.example.ProjectKart.Service.CustomerService;
import com.example.ProjectKart.Service.ItemService;
import com.example.ProjectKart.Transformer.DTOToEntity.DtoToItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServImpl implements ItemService {
    @Autowired
    CustomerRepository custRepo;
    @Autowired
    ProductRepository proRepo;
    @Autowired
    ItemRepository itemRepo;
    public Item addItemToCart(ItemRequest itemReq) throws CustomerNotFoundException, ProductNotFoundException, ProductIsOutOfStockException, StockShortageException {
        Customer cust=custRepo.findByNumber(itemReq.getCustContact());
        if(cust==null){
            throw new CustomerNotFoundException("The entered contact is not registered with us!");
        }
        Optional<Product> optPro=proRepo.findById(itemReq.getProductId());
        if(optPro.isEmpty()){
            throw new ProductNotFoundException("The Product being added is invalid!");
        }
        Product pro=optPro.get();
        if(pro.getQuantity()==0){
            throw new ProductIsOutOfStockException("The product is currently out of stock");
        }
        if(itemReq.getReqQuantity()>pro.getQuantity()){
            throw new StockShortageException("OOPS! the requested quantity is more than the product in stock!");
        }
        Cart cart=cust.getCart();
        System.out.println("cart=="+cart.getCartTotal());
        Item item= DtoToItem.dtoToItem(itemReq,cart,pro);
        //pro.getItems().add(item);
        //proRepo.save(pro);

        return item;
    }
}
