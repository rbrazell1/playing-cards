package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Pile;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class Trick {

  public static final String PILE_FORMAT = "%s pile: %s%n";
  private final Pile redPile;
  private final Pile blackPile;

  public Trick() {
    redPile = new Pile();
    blackPile = new Pile();

  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    Random rng = new SecureRandom();
    deck.shuffle(rng);
    Trick trick = new Trick();
    trick.split(deck);
    trick.swap(rng);
    trick.sort();
    trick.display();
  }

  private void split(Deck deck) {
    boolean routing = false;
    Pile destination = null;
    for (Card card : deck) {
      if (routing) {
        destination.add(card);
      } else {
        switch (card.getSuit()) {
          case CLUBS:
          case SPADES:
            destination = blackPile;
            break;
          case DIAMONDS:
          case HEARTS:
            destination = redPile;
            break;
        }
      }
      routing = !routing;
    }

  }

  private void swap(Random rng) {
    int swapCount = rng.nextInt(1 + Math.min(redPile.size(), blackPile.size()));
    for (int i = 0; i < swapCount; ++i) {
      blackPile.add(redPile.draw());
      redPile.add(blackPile.draw());

    }
  }

  private void sort() {
    Comparator<Card> comparator = Comparator.comparing((Card card) -> card.getSuit().getColor())
        .thenComparing(Card::getSuit)
        .thenComparing(Card::getRank);
    redPile.sort(comparator);
    blackPile.sort(comparator);

  }

  private void display() {
    System.out.printf(PILE_FORMAT, "Red", redPile);
    System.out.printf(PILE_FORMAT, "Black", blackPile);
  }

}
