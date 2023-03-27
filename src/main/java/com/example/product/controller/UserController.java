package com.example.product.controller;


import com.example.product.model.Product;
import com.example.product.model.User;
import com.example.product.service.UserServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "Login")
public class UserController {

    @Autowired
    private UserServiceIplm serviceIplm;

    @GetMapping("/testindex")
    public String getindextest(Model model){
        return "index_test";
    }
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String getPageLogin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }
    @GetMapping("/signup/")
    public String addNewProduct(Model model) {
        User user = new User();
        model.addAttribute("new_user", user);
        return "sign_up";
    }

    @PostMapping("/adduser/save")
    public String saveUser(@ModelAttribute("user") User user,Model model) {

        if(serviceIplm.check_user(user)){
            serviceIplm.save(user);
        }else {
            String message = "Dang ki khong thanh cong...";
            model.addAttribute("message",message);
            return "redirect:/Login/signup/";
        }
        return "redirect:/Login/";
    }

    @PostMapping("/showFormUpdate/update/{id}")
    public String updateUser(@PathVariable(value = "id") Integer id,@ModelAttribute("user") User user) {
        serviceIplm.update(id,user);
        System.out.println("update thanh cong............");
        return "redirect:/Login/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        User user = serviceIplm.getById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        serviceIplm.deleteViaId(id);
        return "redirect:/Login/";
    }

    @PostMapping("/checklogin/")
    public String checkLogin(@ModelAttribute("user") User user,Model model){
        int check = 0;
        List<User> data_user = serviceIplm.getAllUser();
        for (int i = 0; i < data_user.size(); i++) {
            if(user.getUsername().equals(data_user.get(i).getUsername()) &&
                    user.getPassword().equals(data_user.get(i).getPassword())){
                check = 1;
                data_user.get(i).setIslogin(true);
                break;
            }
        }
        if(check == 0){
            return  "redirect:/Login/";
        }else {
            model.addAttribute("user",user);
            return "redirect:/index";
        }
    }

    @GetMapping("/forgotPass/")
    public String forgotPassword(Model model){
        return "form_forgot_pass";
    }

}
