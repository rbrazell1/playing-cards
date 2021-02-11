package edu.cnm.deepdive.model;

public class Card {

  private final Rank rank;
  private final Suit suit;


  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public String getSymbol() {
    return String.format("%s%s", rank.symbol(), suit.symbol());
  }

  @Override
  public String toString() {
    return String.format("%s %s", rank,suit);
  }
}

