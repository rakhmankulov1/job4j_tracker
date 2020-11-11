package ru.job4j.ru.job4j.io;

import java.util.Scanner;

public class Matches {

    private static int matches = 11;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int whosRound = 0;
        while (matches > 0) {
            System.out.println("Количество спичек на столе: " + matches);
            System.out.print("Выберите количество спичек от 1 до 3: \n");
            int select = Integer.valueOf(input.nextLine());
            whosRound++;

            if (select < 1 || select > 3) {
                System.out.println("Введённое число не соответствует диапазону от 1 до 3\n");
                continue;
            } else if (matches - select <= 0) {
                if (whosRound % 2 == 0) {
                    System.out.println("Победил второй игрок!");
                } else {
                    System.out.println("Победил первый игрок!");
                }
            }
            matches = matches - select;
        }
    }
}
