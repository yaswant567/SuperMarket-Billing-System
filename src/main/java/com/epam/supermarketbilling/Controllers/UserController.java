package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Services.AdminServicesIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController
{
    @Autowired
    public AdminServicesIml adminService;
    @GetMapping("/User")
    public String getAllEItems(Model model) {
        model.addAttribute("items",new Products());
        model.addAttribute("allItems",adminService.getAllItems());
        return "user";
    }

    @GetMapping("/User/{id}")
    public Products getItem(@PathVariable("id") Products items)
    {
        
    }




}
