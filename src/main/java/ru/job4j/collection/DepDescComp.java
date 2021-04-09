package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] array1 = o1.split("/");
        String[] array2 = o2.split("/");
        int result = 0;
        result = array2[0].compareTo(array1[0]);
        if (result == 0) {
            int size = Math.min(array1.length, array2.length);
            if (array1.length == array2.length) {
                for (int index = 0; index < size; index++) {
                    result = array1[index].compareTo(array2[index]);
                }
                return result;
            } else {
                return Integer.compare(array1.length, array2.length);
            }
        }
        return result;
    }
}
