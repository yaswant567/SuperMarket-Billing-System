package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerServices
{
    public void addCustomer(Customer cust);

}
