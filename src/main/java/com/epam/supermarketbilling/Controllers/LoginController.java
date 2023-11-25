package com.epam.supermarketbilling.Controllers;

import com.epam.supermarketbilling.Model.Login;
import com.epam.supermarketbilling.Services.LoginServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

        @Autowired
        public LoginServicesImpl loginServices;

//-------------------------------------------Login Page Handling----------------------------------------------------------------------//

        @GetMapping("/")
        public String loginPage()
        {
            return "Login";
        }

    @PostMapping("/")
    public String login(@RequestParam Long id, @RequestParam String password, @RequestParam String role, HttpSession session) {
         Login user = loginServices.getUserById(id);
         boolean flag = true;
        if (user != null && id.equals(user.getId()) && password.equals(user.getPassword()) && role.equals("Admin")) {
//            session.setAttribute("id", id);
            flag = true;
            return "redirect:/Admin";
        }
        else if(user != null && id.equals(user.getId()) && password.equals(user.getPassword()) && role.equals("Employee")) {
            flag = false;
            return "redirect:/User";
        }
        return (flag) ? "redirect:/Admin/addItems" : "redirect:/User/addItem";
    }

        @GetMapping("/User")
        public String user()
        {
            return "redirect:/User/addItem";
        }

        @GetMapping("/Admin")
        public String admin()
        {
            return "redirect:/Admin/addItems";
        }





 //----------------------------------------------User Data Handling in Admin--------------------------------------------------------//


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

        @PostMapping("/Admin/addUser/edit/{id}")
        public String saveEditedData(@ModelAttribute Login data) {
        // save edited data to database
        return "redirect:/Admin/addUser";
    }

        @GetMapping("/Admin/addUser/delete/{id}")
        public String deleteData(@PathVariable("id") Long id) {
            loginServices.deleteById(id);
            return "redirect:/Admin/addUser";
    }
    @GetMapping("/Admin/addUser/deleteAll")
    public String delAllEmp()
    {
        loginServices.deleteAllEmp();
        return "redirect:/Admin/addUser";
    }

    }
