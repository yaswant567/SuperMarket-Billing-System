package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerServices
{
    public void addCustomer(Customer cust);
    public List<Customer> getAllCustomers();
    public void delCustomer(Long id);
    public void delAllCustomer();

}
