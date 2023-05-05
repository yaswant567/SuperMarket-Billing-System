package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Items;
import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Services.AdminServicesImpl;
import com.epam.supermarketbilling.Services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController
{
    @Autowired
    public AdminServicesImpl adminService;
    @Autowired
    public UserServicesImpl userServices;
    @GetMapping("/User")
    public String getAllEItems(Model model) {
        model.addAttribute("view",new Items());
        model.addAttribute("allItems",adminService.getAllItems());
        model.addAttribute("view",userServices.getAllItems());
        return "user";
    }

    @GetMapping(value = "/User/{id}")
    @ResponseBody
    public Products getItem(@PathVariable("id") Long id)
    {
        return adminService.getItemById(id);
    }

    @PostMapping("/User/addToUserTable")
    public String storeData(@RequestBody Products items)
    {
        userServices.addItem(items);
//        return new ResponseEntity<>("Data stored successfully", HttpStatus.OK);
        return "redirect:/User";
    }

//    When you use "@RequestBody", Spring expects the request to contain a JSON or XML payload that can be converted into the Products object. Since you're not sending any payload in your request, Spring might be throwing an error and not processing the redirect.

//    @GetMapping("/User/userItems")
//    public String viewData(Model model)
//    {
//        model.addAttribute("view",userServices.getAllItems());
//        return "redirect:/User";
//    }

}
