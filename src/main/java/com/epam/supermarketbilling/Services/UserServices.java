package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Model.Items;
import com.epam.supermarketbilling.Model.Products;

import java.util.List;

public interface UserServices {
    public boolean isUserExists(Long id);
    public List<Items> getAllItems();
    public Items getItemById(Long id);
    public void addItem(Products entity);

    //    public void updateItem(Products entity);

    public void deleteItem(Long id);
    public void deleteAll();


    public void addCustomer(Customer cust);
}
