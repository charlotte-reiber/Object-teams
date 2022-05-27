import java.util.ArrayList;
import java.util.Scanner;

class Player {
  private String name;
  private Scanner scan;
  private ArrayList<Card> hand = new ArrayList<Card>();
  private int numPairs = 0;
  
  public Player(String name, Scanner scan) {
    this.scan = scan;
    this.name = askName();
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

  /**
  * this is a method that adds a card 
  * to the player's hand
  * @param the card being added
  */
  public void getCard(Card card) {
    this.hand.add(card);
  }

  /**
  * this is a method that gets a value from the user
  * @return the value of the card being looked for
  */
  public int askValue() {
    boolean gotValue = false;
    int value = -1;
    String token;
    do {
      System.out.print("What value are you looking for? ");
      token = this.scan.next();
      try {
        value = Integer.valueOf(token);
      } catch (NumberFormatException exception) {
        token = token.substring(0,1).toLowerCase();
        if (token.equals("a")) value = 1;
        else if (token.equals("j")) value = 11;
        else if (token.equals("q")) value = 12;
        else if (token.equals("k")) value = 13;
        if (value == -1) System.out.println("That is not a valid value.");
        else if (!hasValue(value)) System.out.println("You do not have that value in your hand.");
        else gotValue = true;
      }
    } while (!gotValue);
    return value;
  }

  /**
  * this is a method that checks if the player
  * is the player being asked
  * @param the name being checked
  * @return if the player has that name
  */
  public boolean checkName(String name) {
    return this.name.equals(name);
  }

  /**
  * returns true if the player has a card with that value
  * @param value the value being looked for
  */
  public boolean hasValue(int value) {
    for(Card card : this.hand) {
      if (card.getValue() == value) return true;
    }
    return false;
  }

  /**
  * this is a method that gets the name of the player object
  * @returns the name of the player
  */
  private String askName() {
    System.out.print("What would you like your name to be? ");
    String token = this.scan.nextLine();
    token.replaceAll("\\s", "_");
    token.toLowerCase();
    return token;
  }
}