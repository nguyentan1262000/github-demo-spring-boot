package com.example.product.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblproducts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String Name;
    @Column
    private String hanSp;
    @Column
    private Integer soLuong;

    @Column
    private String nha_cung_cap;

    @Column
    private Integer da_ban;

    @Column
    private String img_product;

    @Column
    private String Gioi_thieu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Product(String name, String hanSp, Integer soLuong, User user) {
        Name = name;
        this.hanSp = hanSp;
        this.soLuong = soLuong;
        this.user = user;
    }

    public Product(String name, String hanSp, Integer soLuong) {
        this.Name = name;
        this.hanSp = hanSp;
        this.soLuong = soLuong;
    }




    public Product(String name, String hanSp, Integer soLuong, String nha_cung_cap, Integer da_ban, String img_product, String gioi_thieu, User user) {
        Name = name;
        this.hanSp = hanSp;
        this.soLuong = soLuong;
        this.nha_cung_cap = nha_cung_cap;
        this.da_ban = da_ban;
        this.img_product = img_product;
        Gioi_thieu = gioi_thieu;
        this.user = user;
    }

    public Product() {
    }
    public String getGioi_thieu() {
        return Gioi_thieu;
    }

    public void setGioi_thieu(String gioi_thieu) {
        Gioi_thieu = gioi_thieu;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getHanSp() {
        return hanSp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHanSp(String hanSp) {
        this.hanSp = hanSp;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }


    public String getNha_cung_cap() {
        return nha_cung_cap;
    }

    public void setNha_cung_cap(String nha_cung_cap) {
        this.nha_cung_cap = nha_cung_cap;
    }

    public Integer getDa_ban() {
        return da_ban;
    }

    public void setDa_ban(Integer da_ban) {
        this.da_ban = da_ban;
    }

    public String getImg_product() {
        return img_product;
    }

    public void setImg_product(String img_product) {
        this.img_product = img_product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", hanSp='" + hanSp + '\'' +
                ", soLuong=" + soLuong +
                ", nha_cung_cap='" + nha_cung_cap + '\'' +
                ", da_ban=" + da_ban +
                ", img_product=" + img_product +
                ", user=" + user +
                '}';
    }
}
