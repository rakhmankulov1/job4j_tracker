package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListToMapTest {

    @Test
    public void listToMap() {
        List<Student> studentList = List.of(
                new Student(100, "First"),
                new Student(100, "First"),
                new Student(70, "Second"),
                new Student(50, "Third")
        );
        Map<String, Student> rsl = ListToMap.toMap(studentList);
        Map<String, Student> expected = new HashMap<>();
        expected.put("First", new Student(100, "First"));
        expected.put("Second", new Student(70, "Second"));
        expected.put("Third", new Student(50, "Third"));
        assertThat(rsl, is(expected));
    }
}