package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;


    public List<Item> getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return findAll();
    }

    public List<Item> findAll(List<Item> items) {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> foundByName = new ArrayList<>();
        for (Item item:items) {
            if (item.getName().equals(key)) {
                foundByName.add(item);
            }
        }
        return foundByName;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        int index=0;
        for (Item item:items) {
            if (item.getId() == id) {
                rsl = index;
                break;
            }
            index++;
            }
            return rsl;
        }



    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) { //проверка параметров - валидация
            item.setId(id);
            items.set(index, item);
        }
        return index != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) { //проверка параметров - валидация
            items.remove(index);
        }
        return index != -1;
    }
}