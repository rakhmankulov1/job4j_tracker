package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiaFunction {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        double x = 0;
        for (int i = start; i < end; i++) {
            x = i;
            rsl.add(func.apply(x));
        }
        return rsl;
    }
}
