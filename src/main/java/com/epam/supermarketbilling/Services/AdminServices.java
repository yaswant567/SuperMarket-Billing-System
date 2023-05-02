package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdminServices {
    public List<Products> getAllItems();

    public Products getItemById(Long id);

    public void addItem(Products entity);

//    public void updateItem(Products entity);

    public void deleteItem(Long id);
}
