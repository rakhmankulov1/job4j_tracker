package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

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
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItems(Tracker tracker) {
        Item[] allItems = tracker.findAll(tracker.getItems());
        for (Item itemsToPrint : allItems) {
            System.out.println(itemsToPrint);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int idForReplacement = input.askInt("укажите id заявки, которую"
                + " мы будем изменять:");
        String replacementName = input.askStr("укажите имя заявки на которую"
                + " мы будем заменять:");
        Item item1 = new Item(idForReplacement, replacementName);
        if (tracker.replace(idForReplacement, item1)) {
            System.out.println("Замена успешно проведена");
        } else {
            System.out.println("Данные введены не верно либо заявка"
                    + " не найдена,попробуйте заново ");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int idForDelete = input.askInt("укажите id заявки, которую нужно удалить:");
        if (tracker.delete(idForDelete)) {
            System.out.println("Заявка успешно удалена");
        } else {
            System.out.println("Данные введены не верно либо заявка"
                    + " не найдена,попробуйте заново ");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        int idToFind = input.askInt("укажите id заявки, которую нужно найти:");
        new Item();
        Item itemToFind;
        itemToFind = tracker.findById(idToFind);
        if (itemToFind != null) {
            System.out.println(itemToFind.toString());
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String nameToFind = input.askStr("укажите имя заявки которую мы будем искать:");
        Item[] itemsToFind = tracker.findByName(nameToFind);
        if (itemsToFind.length > 0) {
            for (Item itemsForPrint : itemsToFind) {
                System.out.println(itemsForPrint);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
         /*   if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }*/
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
       /* System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");*/
    }
}
