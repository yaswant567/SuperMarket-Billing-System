package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Products;
import com.epam.supermarketbilling.Services.AdminServicesImpl;
import com.epam.supermarketbilling.Services.CustomerServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    AdminServicesImpl adminService;
    @Autowired
    CustomerServicesImpl customerServices;

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

    @GetMapping("/Admin/addItems/edit/{id}")
    public ModelAndView editData(@PathVariable Long id)
    {
        Products item = adminService.getItemById(id);
        ModelAndView modelAndView = new ModelAndView("Admin_addItems");
        modelAndView.addObject("items", item);
        return modelAndView;
    }

      @GetMapping("/Admin/addItems/delete/{id}")
      public String deleteData(@PathVariable("id") Long id) {
             adminService.deleteItem(id);
             return "redirect:/Admin/addItems";
      }

      @GetMapping("/Admin/addItems/deleteAllItems")
      public String deleteAll()
      {
          adminService.deleteAllItem();
          return "redirect:/Admin/addItems";
      }

      //-------------------------------------------Manage Customer Record---------------------------------------------//
      @GetMapping("/Admin/addCust")
      public String getCustomer(Model model)
      {
          model.addAttribute("cust",customerServices.getAllCustomers());
          return "Admin_addCustomer";
      }

      @GetMapping("/Admin/addCust/delete/{id}")
      public String deleteCustomer(@PathVariable("id") Long id) {
          customerServices.delCustomer(id);
          return "redirect:/Admin/addCust";
      }

      @GetMapping("/Admin/addItems/deleteAll")
      public String deleteAllCustomer()
      {
          customerServices.delAllCustomer();
          return "redirect:/Admin/addCust";
      }

}
