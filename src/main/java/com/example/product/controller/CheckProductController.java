package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "check")
public class CheckProductController {
    @Autowired
    private ProductServiceIplm serviceIplm;


    @GetMapping("/")
    public List<Product> getAll(){
        List<Product> list= serviceIplm.getAllProduct();
        return list;
    }

    @PutMapping("/update")
    public String saveEmployee(@RequestParam("id") Integer id, @RequestBody Product product) {
        serviceIplm.update(id,product);
        return "redirect:/";
    }

    @DeleteMapping("/delete_employee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        serviceIplm.deleteViaId(id);
        return "redirect:/v1/product/";
    }
}
