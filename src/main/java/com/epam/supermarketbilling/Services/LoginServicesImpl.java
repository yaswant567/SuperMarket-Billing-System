package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Login;
import com.epam.supermarketbilling.Repositories.LoginRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServicesImpl implements LoginServices
{
    @Autowired
    public LoginRepository loginRepo;


    @Override
    public Login getDataById(Long id) {
        return loginRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found with id " + id));
    }

    public boolean isIdExists(Long id)
    {
        return loginRepo.existsById(id);
    }

    public void addData(Login data)
    {
        loginRepo.save(data);
    }

    @Override
    public List<Login> getAllData() {
        return loginRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        loginRepo.deleteById(id);
    }

    @Override
    public Login getUserById(Long id) {
        return loginRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found with id " + id));
    }
}
