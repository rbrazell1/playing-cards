package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Shoe implements Iterable<Card> {

  private final List<Card> cards;
  private final Random rng;

  private Shoe(int numDecks, boolean shuffled, Random rng) {
    List<Card> cards = new ArrayList<>();
    for (int i = 0; i < numDecks; i++) {
      Deck deck = new Deck();
      for (Card card : deck) {
        cards.add(card);
      }
    }
    this.rng = rng;
    if (shuffled) {
      Collections.shuffle(cards, rng);
    }
    this.cards = Collections.unmodifiableList(cards);
  }

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  public Card[] toArray() {
    return cards.toArray(new Card[0]);
  }

  // TODO Add methods

  public static class Builder {

    private int numDecks = 1;
    private Random rng;
    private boolean shuffled;

    public Builder setNumDecks(int numDecks) throws IllegalArgumentException {
      if (numDecks < 0) {
        throw new IllegalArgumentException();
      }
      this.numDecks = numDecks;
      return this;
    }

    public Builder setRng(Random rng) {
      this.rng = rng;
      return this;
    }

    public Builder setShuffled(boolean shuffled) {
      this.shuffled = shuffled;
      return this;
    }

    public Shoe build() {
      if (rng == null) {
        rng = new Random();
      }
      return new Shoe(numDecks, shuffled, rng);
    }

  }

}
