package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixToListConvertion {
    public static List<Integer> convert(int[][] matrix) {

        return Stream.of(matrix)
                .flatMapToInt(IntStream::of)
                .boxed()
                .collect(Collectors.<Integer>toList());
    }
}
