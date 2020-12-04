package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item[] getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return findAll();
    }

    public Item[] findAll(Item[] items) {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] foundByName = new Item[this.size];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                foundByName[size] = item;
                size++;
            }
        }
        foundByName = Arrays.copyOf(foundByName, size);
        return foundByName;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) { //проверка параметров - валидация
            items[index] = item;
            items[index].setId(id);
        }
        return index != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) { //проверка параметров - валидация
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        }
        return index != -1;
    }
}