package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private static Suit suit;
    private static Value value;

    public Card(Suit suit, Value value) {
        Card.suit = suit;
        Card.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }

    public static void main(String[] args) {
         Stream.of(Suit.values())
                .flatMap(suits -> Stream.of(Value.values())
                        .map(values -> new Card(suits, values)))
                .forEach(System.out::println);
    }
}
