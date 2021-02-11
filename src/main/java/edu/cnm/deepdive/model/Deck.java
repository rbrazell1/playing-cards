package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck implements Dealable{

  private List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card =  new Card(rank, suit);
        cards.add(card);
      }
    }
  }

  @Override
  public void shuffle() {

  }

  @Override
  public void shuffle(Random rng) {

  }

  @Override
  public Dealable deal(int count) {
    return null;
  }

  @Override
  public void sort() {

  }
}
