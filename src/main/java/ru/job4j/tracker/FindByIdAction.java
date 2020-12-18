package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by id ===");
        int idToFind = input.askInt("укажите id заявки, которую нужно найти:");
        Item itemToFind = tracker.findById(idToFind);
        if (itemToFind != null) {
            out.println(itemToFind.toString());
        } else {
            out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
