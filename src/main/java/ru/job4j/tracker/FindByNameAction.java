package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String nameToFind = input.askStr("укажите имя заявки которую мы будем искать:");
        List<Item> itemsToFind = tracker.findByName(nameToFind);
        if (itemsToFind.size() > 0) {
            for (Item itemsForPrint : itemsToFind) {
                out.println(itemsForPrint);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
