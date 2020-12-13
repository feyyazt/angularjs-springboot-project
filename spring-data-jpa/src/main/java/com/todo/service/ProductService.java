package com.todo.service;

import com.todo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    Page<Product> getAllPageable(Pageable pageable);

}
