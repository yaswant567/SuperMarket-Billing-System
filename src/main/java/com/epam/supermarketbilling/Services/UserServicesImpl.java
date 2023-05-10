package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Model.Items;
import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Repositories.AdminRepository;
import com.epam.supermarketbilling.Repositories.CustomerRepository;
import com.epam.supermarketbilling.Repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.lang.model.type.NullType;
import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

    @Autowired
    public UserRepository userRepo;
    @Autowired
    public AdminServicesImpl adminServices;

    @Autowired
    public CustomerRepository customerRepo;

    @Autowired
    public EntityManager entityManager;


    public boolean isUserExists(Long id) {
        return userRepo.existsById(id);
    }
    public List<Items> getAllItems()
    {
        return userRepo.findAll();
    }
    public Items getItemById(Long id)
    {
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found with id " + id));
    }

    @Override
    public void addItem(Products items)
    {
        if(items.getQty() != 0)
        {
            items = adminServices.getItemById(items.getId());
            items.setQty(items.getQty() - 1);
        }

        if(isUserExists(items.getId()))
        {
            Items cItems = getItemById(items.getId());
            cItems.setQty(cItems.getQty() + 1);
            cItems.setTotalPrice(cItems.getTotalPrice() + cItems.getPrice());
            userRepo.save(cItems);
        }
        else
        {
            Items cProducts = new Items();
            cProducts.setId(items.getId());
            cProducts.setName(items.getName());
            cProducts.setQty(1);
            cProducts.setPrice(items.getPrice());
            cProducts.setTotalPrice(items.getPrice());
            userRepo.save(cProducts);
        }
    }

    //    public void updateItem(Products entity);

    public void deleteItem(Long id)
    {
        Products cProduct = adminServices.getItemById(id);
        Items cItem = getItemById(id);
        cProduct.setQty(cProduct.getQty() + cItem.getQty());
        userRepo.deleteById(id);
    }

    public void deleteAll(){
        userRepo.deleteAll();
        resetIdentityKey("Items");
    }
    public void resetIdentityKey(String tableName) {
        Query query = entityManager.createNativeQuery("ALTER TABLE " + tableName + " AUTO_INCREMENT=1");
        query.executeUpdate();
    }

    public Long getSumOfColumn(){
        return userRepo.getSumOfColumn();
    }

    //------------------------------------------Customr--------------------------------------------------------//

    @Override
    public void addCustomer(Customer cust)
    {
        customerRepo.save(cust);
    }
}
