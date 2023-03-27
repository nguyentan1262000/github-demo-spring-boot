package com.example.product.controller;


import com.example.product.model.Product;
import com.example.product.service.ProductServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "v1/product")
public class ProductController {

    @Autowired
    private ProductServiceIplm serviceIplm;

    @GetMapping("/")
    public String getAllProduct(Model model) {
        model.addAttribute("productlist", serviceIplm.getAllProduct());
        System.out.println("Get all Product from database!");
        return "product_list";
    }

    @GetMapping("/addnew")
    public String addNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("new_product", product);
        return "add_product";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("product") Product product) {
        serviceIplm.save(product);
        return "redirect:/v1/product/";
    }

    @PostMapping("/update/{id}")
    public String saveEmployee(@PathVariable(value = "id") Integer id,@ModelAttribute("product") Product product) {
        serviceIplm.update(id,product);
        System.out.println("update thanh cong............");
        return "redirect:/v1/product/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        Product product = serviceIplm.getById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @GetMapping("/delete_employee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        serviceIplm.deleteViaId(id);
        return "redirect:/v1/product/";
    }

}

