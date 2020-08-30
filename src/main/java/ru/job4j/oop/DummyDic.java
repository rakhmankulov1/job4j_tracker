package ru.job4j.oop;

public class DummyDic {
    public static void main(String[] args) {
        DummyDic one = new DummyDic();
        System.out.println(one.engToRus("Some"));
    }

    public String engToRus(String eng) {
        String output = "Неизвестное слово. " + eng;
        return output;
    }
}
