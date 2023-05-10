package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Login;

import java.util.List;

public interface LoginServices {

    Login getDataById(Long id);

    public boolean isIdExists(Long id);

    public void addData(Login data);
    public List<Login> getAllData();
    public void deleteById(Long id);
    public Login getUserById(Long id);

}
