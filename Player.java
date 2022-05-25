import java.util.ArrayList;
import java.util.Scanner;

class Player {
  private String name;
  private Scanner scan;
  private ArrayList<Card> hand = new ArrayList<Card>();
  private int numPairs = 0;
  
  public Player(String name, Scanner scan) {
    this.name = name;
    this.scan = scan;
  }

  /**
  * this is a method that asks the player 
  * who they would like to ask during their turn
  * @returns a name
  */
  public String askPlayer() {
    System.out.print("Who would you like to ask? ");
    return this.scan.next();
  }

  public Card giveCard(int value) {
    // removes a card from the players hand and returns it
    return new Card(52, 0);
  }

  public void getCard(Card card) {
    // adds a card to the players hand
  }

  public int askValue() {
    // returns the card value the player is asking for
    return 5;
  }

  public boolean checkName(String name) {
    // returns if the player is the player being asked
    return true;
  }

  /**
  * returns true if the player has a card with that value
  * @param value the value being looked for
  */
  public boolean checkValue(int value) {
    // returns true if the player has a card with that value
    return true;
  }
}