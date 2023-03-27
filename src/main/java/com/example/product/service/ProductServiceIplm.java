package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIplm implements ProductService{

    @Autowired
    private ProductRepository repository ;
    @Override
    public List<Product> getAllProduct() {
        List<Product> lists = repository.findAll();
        if(lists != null){
            return lists;
        }
        return null;
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }



    @Override
    public Product getById(Integer id) {
        Product product = repository.getById(id);
        if(product != null){
            return product;
        }
        return null;
    }

    @Override
    public void deleteViaId(Integer id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else {
            System.out.println("khong xoa duoc");
        }

    }

    @Override
    public void update(Integer id, Product product) {
        if(product != null) {
            Product product1 = repository.getById(id);
            product1.setName(product.getName());
            product1.setHanSp(product.getHanSp());
            product1.setSoLuong(product.getSoLuong());
            product1.setImg_product(product.getImg_product());
            product1.setDa_ban(product.getDa_ban());
            product1.setNha_cung_cap(product.getNha_cung_cap());
            product1.setGioi_thieu(product.getGioi_thieu());

            repository.save(product1);
        }else {
                System.out.println("khong ton tai san pham");
            }
        }
    }
