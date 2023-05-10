package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Customer;
import com.epam.supermarketbilling.Model.Items;
import com.epam.supermarketbilling.Model.Login;
import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Services.AdminServicesImpl;
import com.epam.supermarketbilling.Services.CustomerServicesImpl;
import com.epam.supermarketbilling.Services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public CustomerServicesImpl customerServices;

    //--------------------------------------Add Products to Cart (User.html)------------------------------------------//

    @GetMapping("/User/addItem")
    public String getAllItems(Model model) {
        model.addAttribute("view",new Items());
        model.addAttribute("allItems",adminService.getAllItems());
        model.addAttribute("view",userServices.getAllItems());
        model.addAttribute("Sum", userServices.getSumOfColumn());
        return "User";
    }

    @GetMapping("/User/addItem/{id}")
    @ResponseBody
    public Products getItem(@PathVariable("id") Long id)
    {
        return adminService.getItemById(id);
    }

    @PostMapping("/User/addItem/addToUserTable")
    public String storeData(@RequestBody Products items)
    {
        userServices.addItem(items);
        return "redirect:/User/addItem";
    }

    @GetMapping("/User/addItem/delete/{id}")
    public String deleteData(@PathVariable("id") Long id) {
        userServices.deleteItem(id);
        return "redirect:/User/addItem";
    }
    @PostMapping("/User/addItem/edit/{id}")
    public String saveEditedData(@ModelAttribute Login data) {
        // save edited data to database
        return "redirect:/User/addItem";
    }

    @GetMapping("/User/addItem/deleteAll")
    public String deleteAllData()
    {
        userServices.deleteAll();
        return "redirect:/User/addItem";
    }

    // ----------------------------------------Generate Bill-----------------------------------------------------------//

    @GetMapping("/User/addItem/generateBill")
    public String generateBill(Model model)
    {
        userServices.getAllItems();
        model.addAttribute("items",new Customer());
        model.addAttribute("view",userServices.getAllItems());
        model.addAttribute("Sum", userServices.getSumOfColumn());

        return "GeneratedBill";
    }

    @PostMapping("/User/addItem/generateBill")
    public String takeInput(@ModelAttribute("items")Customer items,Model model) {
        customerServices.addCustomer(items);
        return "redirect:/User/addItem/generateBill";
    }

    // ------------------------------------------------Customer  Table---------------------------------------------- //



//    public static class MyCondition {
//        public boolean checkCondition(Long id) {
//            // Define your condition logic here
//            return true; // Example condition always returns true
//        }
//    }
//    When you use "@RequestBody", Spring expects the request to contain a JSON or XML payload that can be converted into the Products object. Since you're not sending any payload in your request, Spring might be throwing an error and not processing the redirect.

//    @GetMapping("/User/userItems")
//    public String viewData(Model model)
//    {
//        model.addAttribute("view",userServices.getAllItems());
//        return "redirect:/User";
//    }

}
