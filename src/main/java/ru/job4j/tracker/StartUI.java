package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public static void main(String[] args) {
       /* Item firstTime = new Item();
        LocalDateTime timeForFormat = firstTime.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String localDateTimeFormatted = timeForFormat.format(formatter);
        System.out.println(localDateTimeFormatted);

        // для задачи  7. toString [#325820]
        Item secondTime = new Item();
        System.out.println(secondTime);

        // для задачи  5. Tracker - хранилище [#325832]
        Item allFieldsItem = new Item(1, "Alexa");
        Tracker firstTracker = new Tracker();
        firstTracker.add(allFieldsItem);*/

        //для задачи  2.1 Реализация класса StartUI [#325764]

        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] allItems = tracker.findAll(tracker.getItems());
                for (Item itemsToPrint : allItems) {
                    System.out.println(itemsToPrint);
                }
            } else if (select == 2) {
                System.out.println("укажите id заявки, которую мы будем изменять");
                int idForReplacement = Integer.valueOf(scanner.nextLine());
                System.out.println("укажите имя заявки на которую мы будем заменять");
                //Scanner scanner1 = new Scanner(System.in);
                String replacementName = scanner.nextLine();
                Item item1 = new Item(idForReplacement, replacementName);
                tracker.replace(idForReplacement, item1);
                if (tracker.replace(idForReplacement, item1)) {
                    System.out.println("Замена успешно проведена");
                } else {
                    System.out.println("Данные введены не верно либо заявка не найдена,попробуйте заново ");
                }
            } else if (select == 3) {
                System.out.println("укажите id заявки, которую нужно удалить");
                int idForDelete = Integer.valueOf(scanner.nextLine());
                if (tracker.findById(idForDelete) == null) {
                    System.out.println("Заявка с таким id не существует");
                } else {
                    tracker.delete(idForDelete);
                    if (!tracker.delete(idForDelete)) {
                        System.out.println("Заявка успешно удалена");
                    } else {
                        System.out.println("Данные введены не верно либо заявка не найдена,попробуйте заново ");
                    }
                }
            } else if (select == 4) {
                System.out.println("укажите id заявки, которую нужно найти");
                int idToFind = Integer.valueOf(scanner.nextLine());
                Item itemToFind = new Item();
                itemToFind = tracker.findById(idToFind);
                if (itemToFind != null) {
                    System.out.println(itemToFind.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
            } else if (select == 5) {
                System.out.println("укажите имя заявки которую мы будем искать");
                String nameToFind = scanner.nextLine();
                Item[] itemsToFind = tracker.findByName(nameToFind);
                if (itemsToFind.length > 0) {
                    Item[] items = tracker.findByName(nameToFind);
                    for (Item itemsForPrint : items) {
                        System.out.println(itemsForPrint);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
}
