package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idToFind = input.askInt("укажите id заявки, которую нужно найти:");
        Item itemToFind = tracker.findById(idToFind);
        if (itemToFind != null) {
            System.out.println(itemToFind.toString());
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
