package com.llxh.basic.lambda;

import lombok.Data;

@Data
public class Game {
    private String name;
    private String company;

    public Game(String name,String company){
        this.name = name;
        this.company = company;
    }
    public boolean isCompany(String company){
        return this.company.equals(company);
    }
}
