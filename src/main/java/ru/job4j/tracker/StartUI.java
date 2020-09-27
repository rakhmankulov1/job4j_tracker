package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item firstTime = new Item();
        LocalDateTime timeForFormat = firstTime.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String localDateTimeFormatted = timeForFormat.format(formatter);
        System.out.println(localDateTimeFormatted);

        /* для задачи  7. toString [#325820] */
        Item secondTime = new Item();
        System.out.println(secondTime);

        /* для задачи  5. Tracker - хранилище [#325832] */
        Item allFieldsItem = new Item(1, "Alexa");
        Tracker firstTracker = new Tracker();
        firstTracker.add(allFieldsItem);
        System.out.println(firstTracker.findById(1));

    }
}
