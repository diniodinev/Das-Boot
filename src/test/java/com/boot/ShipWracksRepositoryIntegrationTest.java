package com.boot;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwrackRepository;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ShipWracksRepositoryIntegrationTest {

    @Autowired
    ShipwrackRepository repository;

    @Test
    public void getFindAll() {
        List<Shipwreck> shipwrachks = repository.findAll();
        assertThat(shipwrachks.size(), greaterThanOrEqualTo(0));
    }
}
