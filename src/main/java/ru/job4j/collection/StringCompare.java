package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char chfl = left.charAt(i);
            char chfr = right.charAt(i);
            if (chfl != chfr) {
                return Integer.compare(chfl, chfr);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}