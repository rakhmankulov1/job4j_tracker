package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idForDelete = input.askInt("укажите id заявки, которую нужно удалить:");
        if (tracker.delete(idForDelete)) {
            System.out.println("Заявка успешно удалена");
        } else {
            System.out.println("Данные введены не верно либо заявка"
                    + " не найдена,попробуйте заново ");
        }
        return true;
    }
}
