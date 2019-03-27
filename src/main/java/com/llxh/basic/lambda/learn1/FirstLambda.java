package com.llxh.basic.lambda.learn1;

import com.llxh.basic.lambda.DataDemo;
import com.llxh.basic.lambda.Game;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;

public class FirstLambda {
    private void aVoid(){
        LongBinaryOperator a =  (x, y) -> x + y;
        a.applyAsLong(1,2);
    }

    public static void main(String[] args) {
        List<Game> games = DataDemo.games;
        long count = games.stream().filter(game -> game.isCompany("腾讯")).count();

        System.out.println(count);
    }
}
