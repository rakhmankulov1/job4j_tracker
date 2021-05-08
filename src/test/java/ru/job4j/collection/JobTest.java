package ru.job4j.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityNatOrder() {
        Comparator<Job> cmpNamePriority = new JobIncsByName().thenComparing(
                new JobIncsByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortNaturalOrderByPriority() {
        Job item1 = new Job("alfa", 1);
        Job item2 = new Job("beta", 2);
        Job item3 = new Job("gamma", 3);
        List<Job> input = Arrays.asList(item3, item1, item2);
        List<Job> expected = List.of(item1, item2, item3);
        input.sort(new JobIncsByPriority());
        assertEquals(expected, input);

    }

    @Test
    public void whenSortNaturalOrderByName() {
        Job item1 = new Job("alfa", 1);
        Job item2 = new Job("beta", 2);
        Job item3 = new Job("gamma", 3);
        List<Job> input = Arrays.asList(item3, item1, item2);
        List<Job> expected = List.of(item1, item2, item3);
        input.sort(new JobIncsByName());
        assertEquals(expected, input);

    }

    @Test
    public void whenSortReverseOrderByPriority() {
        Job item1 = new Job("alfa", 1);
        Job item2 = new Job("beta", 2);
        Job item3 = new Job("gamma", 3);
        List<Job> input = Arrays.asList(item3, item1, item2);
        List<Job> expected = List.of(item3, item2, item1);
        input.sort(new JobDescByPriority());
        assertEquals(expected, input);

    }

    @Test
    public void whenSortReverseOrderByName() {
        Job item1 = new Job("alfa", 1);
        Job item2 = new Job("beta", 2);
        Job item3 = new Job("gamma", 3);
        List<Job> input = Arrays.asList(item3, item1, item2);
        List<Job> expected = List.of(item3, item2, item1);
        input.sort(new JobDescByName());
        assertEquals(expected, input);

    }
}