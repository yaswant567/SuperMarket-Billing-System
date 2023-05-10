package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices{
    @Autowired
    public CustomerRepository customerRepo;

    @Override
    public void addCustomer(Customer cust) {
        customerRepo.save(cust);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void delCustomer(Long id) {
        customerRepo.deleteById(id);
    }
    public void delAllCustomer()
    {
        customerRepo.deleteAll();
    }
}
