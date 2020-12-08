package ru.job4j.tracker;

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

        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            String msg = "";
            int select = input.askInt(msg);
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] allItems = tracker.findAll(tracker.getItems());
                for (Item itemsToPrint : allItems) {
                    System.out.println(itemsToPrint);
                }
            } else if (select == 2) {
                System.out.println("укажите id заявки, которую мы будем изменять");
                int idForReplacement = input.askInt(msg);
                System.out.println("укажите имя заявки на которую мы будем заменять");
                String replacementName = input.askStr(msg);
                Item item1 = new Item(idForReplacement, replacementName);
                if (tracker.replace(idForReplacement, item1)) {
                    System.out.println("Замена успешно проведена");
                } else {
                    System.out.println("Данные введены не верно либо заявка"
                           + " не найдена,попробуйте заново ");
                }
            } else if (select == 3) {
                System.out.println("укажите id заявки, которую нужно удалить");
                int idForDelete = input.askInt(msg);
                if (tracker.delete(idForDelete)) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Данные введены не верно либо заявка"
                          + " не найдена,попробуйте заново ");
                }

            } else if (select == 4) {
                System.out.println("укажите id заявки, которую нужно найти");
                int idToFind = input.askInt(msg);
                new Item();
                Item itemToFind;
                itemToFind = tracker.findById(idToFind);
                if (itemToFind != null) {
                    System.out.println(itemToFind.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
            } else if (select == 5) {
                System.out.println("укажите имя заявки которую мы будем искать");
                String nameToFind = input.askStr(msg);
                Item[] itemsToFind = tracker.findByName(nameToFind);
                if (itemsToFind.length > 0) {
                    for (Item itemsForPrint : itemsToFind) {
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
