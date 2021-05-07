package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {
    private static Suit suit;
    private static Value value;

    public Card(Suit suit, Value value) {
        Card.suit = suit;
        Card.value = value;
    }

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] suits = getNames(Suit.class);
        String[] values = getNames(Value.class);

        Stream.of(suits)
                .flatMap(level -> Stream.of(values)
                        .map(value -> level + " " + value))
                .forEach(System.out::println);

    }
}
