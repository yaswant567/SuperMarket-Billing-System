package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices{
    @Autowired
    public CustomerRepository customerRepo;

    @Override
    public void addCustomer(Customer cust) {
        customerRepo.save(cust);

    }
}
