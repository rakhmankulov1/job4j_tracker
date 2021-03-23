package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all items";
    }

   @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all items ===");
        List<Item> allItems = tracker.findAll(tracker.getItems());
        for (Item itemsToPrint : allItems) {
           out.println(itemsToPrint);
        }
       return true;
    }
}
