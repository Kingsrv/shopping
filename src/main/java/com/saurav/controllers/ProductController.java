package com.saurav.controllers;

import com.saurav.models.Product;
import com.saurav.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    //If yoy want to extend the URL then use the annotation request mapping on top of the class as well.
    //localhost:8081/product/create-product
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/create-product",method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
//
//        Product prod = new Product();
//        prod.setProductId(1234);
//        prod.setProductName("iphone");
//        prod.setProductPrice(10000.55);
//        prod.setProductDesc("This is very mehnga phone");

        Product createdProduct = productService.createProduct(product);
        System.out.println("Product created");
        return createdProduct;
    }

    @RequestMapping(value = "/list-product", method = RequestMethod.GET)
    public List<Product> listAllProducts(){

        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }
}
