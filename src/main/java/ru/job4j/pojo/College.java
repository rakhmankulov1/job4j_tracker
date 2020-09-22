package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov ivan");
        student.setGroup("5d");
        student.setDateOfAdmission(new Date());

        System.out.println(student.getFullName() + " студент группы: " + student.getGroup()
                + " поступил: " + student.getDateOfAdmission());
    }
}
