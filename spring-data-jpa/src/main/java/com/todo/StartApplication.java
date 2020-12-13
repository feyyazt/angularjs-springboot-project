package com.todo;

import com.todo.entity.Product;
import com.todo.entity.User;
import com.todo.repository.ProductRepository;
import com.todo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        userRepository.save(new User("user1","1234","Ahmet Taşçı","test@hotmail.com"));
        for(int i=0;i<20;i++) {
            productRepository.save(new Product("ürün" + i, i, "test açıklama" + i));
        }

    }

}