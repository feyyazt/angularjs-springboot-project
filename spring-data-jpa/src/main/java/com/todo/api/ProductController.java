package com.todo.api;

import com.todo.dto.ProductDto;
import com.todo.entity.Product;
import com.todo.service.ProductService;
import com.todo.util.TPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/pagination")
    public ResponseEntity<?> getAllPageable(Pageable pageable) {
        log.debug("getAllPageable çalıştı");
        Page<Product> products=productService.getAllPageable(pageable);
        TPage<ProductDto> respnose = new TPage<>();
        respnose.setStat(products, products.getContent().stream().map(ProductDto::new).collect(Collectors.toList()));
        return  ResponseEntity.ok(respnose);
    }

}
