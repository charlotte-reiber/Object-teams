import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Deck {

  private int deckSize;
  ArrayList<Card> deck = new ArrayList<Card>();
  //private Card[] deck;
  
  public Deck(int inputSize) {
    newDeck(inputSize);
  }

  /**Draws the top card from the deck
  */
  public Card drawCard() {
    //if (this.deck.length==0) return new Card(1, -1);
    Card tempCard = this.deck.get(0);
    this.deck.remove(0);
    //this.deck = Arrays.copyOfRange(this.deck, 1, this.deck.length);
    return tempCard;
  }


  /**Returns the top card of the deck
  */
  public Card getTopCard() {
    return this.deck.get(0);
  }

  /**Creates a new default ordered deck, then shuffles it
  */
  public void newDeck(int inputSize) {
    this.deckSize = inputSize;
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    //Card[] tempDeck = new Card[deckSize];
    for(int i = 0; i<deckSize;i++) {
      tempDeck.add(new Card(deckSize, i));
    }
    this.deck = tempDeck;
    shuffle();
    
  }

  /**Shuffles the deck
  */
  public void shuffle() {
    ArrayList<Card> tempDeck = this.deck;
    Random rand = new Random();
    Card tempCard;
    for (int i = 0; i < tempDeck.size(); i++) {
      int x = rand.nextInt(tempDeck.size());
      tempCard = tempDeck.get(x);
      tempDeck.set(x, tempDeck.get(i));
      tempDeck.set(i, tempCard);
    }
    this.deck = tempDeck;
  }

  /**Checks if a string is an integer
  */
  private boolean isInteger(String input) {
    try {Integer.parseInt(input);return true;} catch(NumberFormatException e){return false;}
  }
}