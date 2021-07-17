package com.ada.aerolineaf.aerolineaV1.repository;
import com.ada.aerolineaf.aerolineaV1.model.Base;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BaseRepositoryTest {

    @Autowired
    private BaseRepository baseRepository;

    @Test
    void guardarBaseTest() {
        Base base = new Base();
        base.setCity("New York, US");

        baseRepository.save(base);

        System.out.println("***" + base.getId_base());

        assertTrue(base.getId_base() > 0);


    }
}
