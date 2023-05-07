package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Services.AdminServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    AdminServicesImpl adminService;

    @GetMapping("/Admin/addItems")
    public String getAllItems(Model model) {
        model.addAttribute("items",new Products());
        model.addAttribute("allItems",adminService.getAllItems());
        return "Admin_addItems";
    }


    @PostMapping("/Admin/addItems")
    public String takeInput(@ModelAttribute("items") Products items,Model model) {
        adminService.addItem(items);
        return "redirect:/Admin/addItems";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedData(@ModelAttribute Products data) {
        // save edited data to database
        return "redirect:/Admin/addItems";
    }

    @PostMapping("/delete/{id}")
    public String deleteData(@ModelAttribute Products data) {
        // save edited data to database
        return "redirect:/Admin/addItems";
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
