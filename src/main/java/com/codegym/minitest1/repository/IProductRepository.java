package com.codegym.minitest1.repository;

import com.codegym.minitest1.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByOrderByPriceAsc();
    @Query(value = " select * from products order by id desc LIMIT 4", nativeQuery = true)
    Iterable<Product>find4NewestProducts();
}
