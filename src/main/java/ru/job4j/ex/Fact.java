package ru.job4j.ex;

public class Fact {
    public static int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Parametr of the calc"
                    + " method should be more than '0'");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
