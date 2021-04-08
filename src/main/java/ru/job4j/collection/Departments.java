package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            StringBuilder start = new StringBuilder();
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start.append(el).append("/");
            }
        }
        List<String> result = new ArrayList<>(tmp);
        sortAsc(result);
        return result;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
