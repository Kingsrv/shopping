package com.saurav.services;

import com.saurav.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product newProduct, int productId);
    void deleteProduct(int productId);
    Product getProduct(int productId);
    List<Product> getAllProducts();
}
