package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Find all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll(tracker.getItems());
        for (Item itemsToPrint : allItems) {
            System.out.println(itemsToPrint);
        }
        return true;
    }
}
