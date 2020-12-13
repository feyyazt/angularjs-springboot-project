package com.todo.dto;

import com.todo.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private double price;
    private Boolean status;

    public ProductDto(Product product){
        this.id=product.getId();
        this.status=product.getStatus();
        this.name=product.getName();
        this.price=product.getPrice();
    }

}
