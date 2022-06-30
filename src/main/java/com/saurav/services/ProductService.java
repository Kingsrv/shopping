package com.saurav.services;

import com.saurav.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    List<Product> list = new ArrayList<>();
    public Product createProduct(Product product){

        //create
        System.out.println(product.getProductName());
        list.add(product);
        return product;
    }

    //update


    //delete


    //get single product


    //get all products

    public List<Product> getAllProducts(){

        return list;
    }
}
