package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSpl = left.split("\\.");
        String leftNum = leftSpl[0];
        String[] rightSpl = right.split("\\.");
        String rightNum = rightSpl[0];
        return Integer.compare(Integer.parseInt(leftNum), Integer.parseInt(rightNum));
    }
}