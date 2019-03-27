package com.llxh.basic.db.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Test
    public void findAll() throws Exception {
        List<Map<String, Object>> list = userRepository.findAll();
        list.forEach(map -> map.forEach((k,v)->{
            System.out.println(v);
        }));
    }

}