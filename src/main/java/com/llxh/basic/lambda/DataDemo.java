package com.llxh.basic.lambda;

import java.util.ArrayList;
import java.util.List;

public class DataDemo {
    public static List<Game> games = new ArrayList<>();
    static {
        games.add(new Game("LOL","riot"));
        games.add(new Game("Dota2","iceFrog"));
        games.add(new Game("minecraft","Mojang AB，4J Studios"));
        games.add(new Game("天涯明月刀","腾讯北极光工作室"));
        games.add(new Game("QQ飞车","腾讯"));
    }
}
