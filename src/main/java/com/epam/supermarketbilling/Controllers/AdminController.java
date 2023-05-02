package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Services.AdminServicesIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminServicesIml adminService;

    @GetMapping("/Admin")
    public String getAllEItems(Model model) {
        model.addAttribute("items",new Products());
        List<Products> AllItems = adminService.getAllItems();
        model.addAttribute("allItems",adminService.getAllItems());
        return "admin";
    }



    @PostMapping("/Admin")
    public String takeInput(@ModelAttribute("items") Products items,Model model) {
        adminService.addItem(items);
        return "redirect:/Admin";
    }

    //    @GetMapping("/{id}")
//    public Products getItemById(@PathVariable("id") Long id) {
//        return adminService.getItemById(id);
//    }

//    @PutMapping("/")
//    public void updateEntity(@RequestBody MyEntity entity) {
//        entityService.updateEntity(entity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteEntity(@PathVariable("id") Long id) {
//        entityService.deleteEntity(id);
//    }
}
