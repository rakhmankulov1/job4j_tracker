package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            products[index] = null;
            products[index] = products[i];
            products[i] = null;
        }
        return products;
    }
}
