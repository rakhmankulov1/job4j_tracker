package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman fm = new Freshman();
        /* Ошибка в приведении типа. */
        Student st = (Student) fm;  // код завершится с ошибкой приведения типов ClassCastException
        /* Повышающее привидение*/
        System.out.println(fm);
    }
}
