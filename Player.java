import java.util.ArrayList;
import java.util.Scanner;

class Player {
  private String name;
  private Scanner scan;
  private ArrayList<Card> hand = new ArrayList<Card>();
  private int numPairs = 0;
  
  public Player(String name, Scanner scan) {
    name.replaceAll("\\s", "_");
    name.toLowerCase();
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
    String player = this.scan.nextLine();
    player = player.replaceAll("\\s", "_");
    player = player.toLowerCase();
    return player;
  }
  /**
  * this is a method that removes a card
  * from the players hand and returns it
  * @param the value of a card
  * @return the card
  * @throw if the card isn't in the hand
  */
  public Card giveCard(int value) throws IllegalArgumentException{
    Card match = null;
    boolean foundMatch = false;
    for (int i = 0; i < this.hand.size(); i++) {
      if (this.hand.get(i).getValue() == value)
        foundMatch = true;
        match = this.hand.get(i);
        this.hand.remove(i);
        i--;
    }
    if (foundMatch) return match;
    else throw new IllegalArgumentException();
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