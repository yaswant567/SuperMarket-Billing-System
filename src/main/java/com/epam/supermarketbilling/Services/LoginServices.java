package com.epam.supermarketbilling.Services;

import com.epam.supermarketbilling.Model.Login;

public interface LoginServices {

    public Login getDataById(Login data);
    public boolean isIdExists(Long id);
}
