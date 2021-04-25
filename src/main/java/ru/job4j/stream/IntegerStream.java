package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerStream {
    public static void main(String[] args) {
        List<Integer> intStream = new ArrayList<>();
        intStream.add(-1);
        intStream.add(0);
        intStream.add(1);
        List<Integer> positive = intStream.stream()
                .filter(ints -> ints > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
