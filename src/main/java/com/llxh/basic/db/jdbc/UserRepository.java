package com.llxh.basic.db.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAll(){
        return jdbcTemplate.queryForList("select username,password,userphonenum from user");
    }
}
