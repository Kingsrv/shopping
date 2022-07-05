package com.saurav.services;

import com.saurav.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    List<Product> list = new ArrayList<>();

    //create a product
    public Product createProduct(Product product) {
        System.out.println(product.getProductName());
        list.add(product);
        return product;
    }

    //update a product
    public Product updateProduct(Product newProduct, int productId) {
        List<Product> updatedList = list.stream().map(p -> {
            if (p.getProductId() == productId) {
                //updated product
                p.setProductName(newProduct.getProductName());
                p.setProductDesc(newProduct.getProductDesc());
                p.setProductPrice(newProduct.getProductPrice());
                p.setStock(newProduct.isStock());

                return p;
            } else {
                //old product
                return p;
            }
        }).collect(Collectors.toList());

        list = updatedList;
        newProduct.setProductId(productId);
        return newProduct;
    }

    //delete a product
    public void deleteProduct(int productId) {
        List<Product> newList = list.stream().filter(p -> p.getProductId() != productId).collect(Collectors.toList());
        list = newList;
    }

    //get a product
    public Product getProduct(int productId) {
        Product product = list.stream().filter(p -> p.getProductId() == productId).findFirst().get();
        System.out.println(product.getProductName());
        return product;
    }

    //get all products
    public List<Product> getAllProducts() {
        return list;
    }
}
