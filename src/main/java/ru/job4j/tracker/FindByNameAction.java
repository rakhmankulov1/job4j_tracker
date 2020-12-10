package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameToFind = input.askStr("укажите имя заявки которую мы будем искать:");
        Item[] itemsToFind = tracker.findByName(nameToFind);
        if (itemsToFind.length > 0) {
            for (Item itemsForPrint : itemsToFind) {
                System.out.println(itemsForPrint);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
