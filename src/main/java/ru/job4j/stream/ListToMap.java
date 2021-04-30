package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> toMap(List<Student> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getSurname, student -> student));
    }
}
