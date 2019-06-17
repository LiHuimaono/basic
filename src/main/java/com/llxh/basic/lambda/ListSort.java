package com.llxh.basic.lambda;

import java.util.Date;
import java.util.Random;

public class ListSort {
    public static void main(String[] args) {
        Random random = new Random();
        random.nextInt();
    }
}

class Example {
    private String property;
    private Date createDate;
    private int sumNum;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getSumNum() {
        return sumNum;
    }

    public void setSumNum(int sumNum) {
        this.sumNum = sumNum;
    }
}
