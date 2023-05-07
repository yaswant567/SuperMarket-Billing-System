package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Login;
import com.epam.supermarketbilling.Services.LoginServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

        @Autowired
        public LoginServicesImpl loginServices;

        @GetMapping("/Admin/addUser")
        public String getAllItems(Model model) {
        model.addAttribute("data",new Login());
        model.addAttribute("allData",loginServices.getAllData());
        return "Admin_addUser";
    }


        @PostMapping("/Admin/addUser")
        public String takeInput(@ModelAttribute("data") Login data, Model model) {
        loginServices.addData(data);
        return "redirect:/Admin/addUser";
    }

        @PostMapping("/addUser/edit/{id}")
        public String saveEditedData(@ModelAttribute Login data) {
        // save edited data to database
        return "redirect:/Admin/addUser";
    }

        @PostMapping("/addUser/delete/{id}")
        public String deleteData(@ModelAttribute Login data) {
        // save edited data to database
        return "redirect:/Admin/addUser";
    }

    }
