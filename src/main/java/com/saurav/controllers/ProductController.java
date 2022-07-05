package com.saurav.controllers;

import com.saurav.models.Product;
import com.saurav.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    //If yoy want to extend the URL then use the annotation request mapping on top of the class as well.
    //localhost:8081/product/create-product
    @Autowired
    private ProductServiceImpl productService;

    List<Product> list = new ArrayList<>();

    //create a product
//    @RequestMapping(value = "/create-product", method = RequestMethod.POST)
    @PostMapping("/create-product")
    public Product createProduct(@RequestBody Product product) {

//        Product prod = new Product();
//        prod.setProductId(1234);
//        prod.setProductName("iphone");
//        prod.setProductPrice(10000.55);
//        prod.setProductDesc("This is very mehnga phone");

        Product createdProduct = productService.createProduct(product);
        System.out.println("Product created");
        return createdProduct;
    }

    //list all products
//    @RequestMapping(value = "/list-product", method = RequestMethod.GET)
    @GetMapping("/list-product")
    public List<Product> listAllProducts() {

        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }

    //update a product
//    @RequestMapping(value = "/update-product/{productId}", method = RequestMethod.PUT)
    @PutMapping("/update-product/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product newProduct) {
        Product updatedProduct = productService.updateProduct(newProduct, productId);
        return updatedProduct;
    }

    //delete a product
//    @RequestMapping(value = "/delete-product/{productId}", method = RequestMethod.DELETE)
    @DeleteMapping("/delete-product/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return "Product dleted successfully";
    }

    //get a product
//    @RequestMapping(value = "/get-product/{productId}", method = RequestMethod.GET)
    @GetMapping("/get-product/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product product = productService.getProduct(productId);
        return product;
    }
}
