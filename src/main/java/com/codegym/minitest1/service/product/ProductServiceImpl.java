package com.codegym.minitest1.service.product;

import com.codegym.minitest1.model.Product;
import com.codegym.minitest1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public Iterable<Product> find4NewestProducts() {
        return productRepository.find4NewestProducts();
    }

}
