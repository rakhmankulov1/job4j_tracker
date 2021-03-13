package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Петя");
        names.add("Иван");
        names.add("Степан");
        for (Object value : names) {
            System.out.println(value);
        }

    }
}
