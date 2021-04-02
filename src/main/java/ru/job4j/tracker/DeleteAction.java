package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int idForDelete = input.askInt("укажите id заявки, которую нужно удалить:");
        if (tracker.delete(idForDelete)) {
            out.println("Заявка успешно удалена");
        } else {
            out.println("Данные введены не верно либо заявка"
                    + " не найдена,попробуйте заново ");
        }
        return true;
    }
}
