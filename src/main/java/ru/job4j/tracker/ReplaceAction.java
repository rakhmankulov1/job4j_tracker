package ru.job4j.tracker;

public class ReplaceAction implements UserAction  {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
