package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Repositories.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdminServicesIml implements AdminServices {

    @Autowired
    private AdminRepository adminRepo;


    @Override
    public List<Products> getAllItems() {
        return adminRepo.findAll();
    }

    @Override
    public Products getItemById(Long id) {
        return adminRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found with id " + id));
    }

    @Override
    public void addItem(Products item) {
        adminRepo.save(item);
    }

//    @Override
//    public void updateItem(Products item) {
//        adminRepo.save(item);
//    }

    @Override
    public void deleteItem(Long id) {
        adminRepo.deleteById(id);
    }
}
