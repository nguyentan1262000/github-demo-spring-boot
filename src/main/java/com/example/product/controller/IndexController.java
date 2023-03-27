package com.example.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//http://127.0.0.1:8080/
public class IndexController {

    //http://127.0.0.1:8080/
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getItemJSP(Model model){
        model.addAttribute("name","Nguyen An");
        model.addAttribute("age",18);
        System.out.println("pleaseeeeee........");

        //data to html
        return "index";
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(Model model){
        model.addAttribute("name","Nguyen An");
        model.addAttribute("age",18);
        System.out.println("pleaseeeeee........");

        //data to html
        return "test";
    }
}
