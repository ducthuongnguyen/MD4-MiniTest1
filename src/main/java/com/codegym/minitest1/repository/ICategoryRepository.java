package com.codegym.minitest1.repository;

import com.codegym.minitest1.model.Category;
import com.codegym.minitest1.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
