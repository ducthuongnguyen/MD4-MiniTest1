package com.codegym.minitest1.controller;

import com.codegym.minitest1.model.Product;
import com.codegym.minitest1.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Iterable<Product>> findByName(@RequestParam String name) {
        List<Product> products = (List<Product>) productService.findAllByNameContaining(name);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

@GetMapping("/sort")
    public ResponseEntity<Iterable<Product>> sortByAscendingPrice(){
    List<Product> products = (List<Product>) productService.findAllByOrderByPriceAsc();
    if (products.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(products, HttpStatus.OK);
}

    @GetMapping("/top")
    public ResponseEntity<Iterable<Product>> sortById(){
        List<Product> products = (List<Product>) productService.find4NewestProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
