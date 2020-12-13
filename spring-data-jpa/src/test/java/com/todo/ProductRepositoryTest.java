package com.todo;

import com.todo.entity.Product;
import com.todo.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testFindByName() {
        Product entity=repository.save(new Product("Elma",5,""));
        assertTrue(entity.getId()>0);
    }

}
