package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private static Suit suit;
    private static Value value;

    public Card(Suit suit, Value value) {
        Card.suit = suit;
        Card.value = value;
    }

    public Card(Suit suit) {
        Card.suit = suit;
    }

    public Card(Value value) {
        Card.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .map(Card::new)
                .flatMap(cards -> Stream.of(Value.values()))
                .map(Card::new)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }
}
