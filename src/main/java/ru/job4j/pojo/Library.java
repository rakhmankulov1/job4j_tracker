package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 300);
        Book stranger = new Book("Stranger", 200);
        Book raven = new Book("Raven", 400);
        Book thunderstorm = new Book("Thunderstorm", 150);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = stranger;
        books[2] = raven;
        books[3] = thunderstorm;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
            }
        }
    }
}

