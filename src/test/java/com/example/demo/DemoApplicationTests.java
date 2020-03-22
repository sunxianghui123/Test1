package com.example.demo;

import com.example.demo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Person person;
    @Test
    void contextLoads() {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("追踪");
    }

}
