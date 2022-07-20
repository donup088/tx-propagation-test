package com.tx.propagation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OuterServiceTest {
    @Autowired
    OuterService outerService;

    @Test
    public void txTest(){
        outerService.txTest();
    }
}