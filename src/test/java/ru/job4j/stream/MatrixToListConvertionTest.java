package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListConvertionTest {

    @Test
    public void whenConvertMatrixToList() {
        Integer[][] matrix = new Integer[][]{{0, 0}, {0, 0}};
        List<Integer> rsl = MatrixToListConvertion.convert(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(0);
        assertThat(rsl, is(expected));
    }
}