package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle redPlane = new Plane();
        Vehicle greenPlane = new Plane();
        Vehicle train = new Train();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus = new Bus();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = new Vehicle[]{plane, redPlane, greenPlane,
                train, train1, train2, bus, bus1, bus2};
        for (Vehicle all : vehicles) {
            all.move();
        }
    }
}
