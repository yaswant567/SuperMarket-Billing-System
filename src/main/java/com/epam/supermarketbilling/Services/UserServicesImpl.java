package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Items;
import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Repositories.AdminRepository;
import com.epam.supermarketbilling.Repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

    @Autowired
    public UserRepository userRepo;


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

        if(isUserExists(items.getId()))
        {
            Items cProducts = getItemById(items.getId());
            cProducts.setQty(cProducts.getQty() + 1);
            cProducts.setTotalPrice(cProducts.getTotalPrice() + cProducts.getPrice());
            userRepo.save(cProducts);
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
        userRepo.deleteById(id);
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }
}
