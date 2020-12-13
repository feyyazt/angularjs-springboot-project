package com.todo.service.impl;

import com.todo.entity.Product;
import com.todo.repository.ProductRepository;
import com.todo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> getAllPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
