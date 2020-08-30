package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int value) {
        this.load = value;
    }

    public static void main(String[] args) {
        Battery first = new Battery(30);
        Battery second = new Battery(70);
        System.out.println("first : " + first.load + ". second : " + second.load);
        first.exchange(second);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }
}