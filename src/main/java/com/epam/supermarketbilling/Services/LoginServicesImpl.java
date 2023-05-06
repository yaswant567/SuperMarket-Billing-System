package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Login;
import com.epam.supermarketbilling.Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServicesImpl implements LoginServices
{
    @Autowired
    public LoginRepository LoginRepo;


    @Override
    public Login getDataById(Login data) {
        return null;
    }

    @Override
    public boolean isIdExists(Long id) {
        return false;
    }
}
