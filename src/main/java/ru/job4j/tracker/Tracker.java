package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    //private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public List<Item> getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public List<Item> findAll() {
        return findAll();
    }

    public List<Item> findAll(List<Item> items) {
        List<Item> items1 = new ArrayList<>();
        items1.addAll(items);
        return items1;
    }

    public List<Item> findByName(String key) {
        List<Item> foundByName = new ArrayList<>(this.size);
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                foundByName.add(size, item);
                size++;
            }
        }
        List<Item> foundByName1 = new ArrayList<>(this.size);
        foundByName1.addAll(foundByName);
        return foundByName1;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) { //проверка параметров - валидация
            items.set(index, item);
            items.get(index).setId(id);
        }
        return index != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) { //проверка параметров - валидация
            //System.arraycopy(items, index + 1, items, index, size - index);
            items.set(size - 1, null);
            size--;
        }
        return index != -1;
    }
}