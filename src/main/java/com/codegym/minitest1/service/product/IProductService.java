package com.codegym.minitest1.service.product;

import com.codegym.minitest1.model.Product;
import com.codegym.minitest1.service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByOrderByPriceAsc();
    Iterable<Product>find4NewestProducts();
}
