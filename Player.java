import java.util.ArrayList;
import java.util.Scanner;

class Player {
  private String name;
  private Scanner scan;
  private ArrayList<Card> hand = new ArrayList<Card>();
  private int numPairs = 0;
  
  public Player(Scanner scan) {
    this.scan = scan;
    this.name = askName();
  }

  /**
  * this is a method that asks the player 
  * who they would like to ask during their turn
  * @returns a name
  */
  // works
  public String askPlayer(boolean weirdBit) {
    System.out.print("Who would you like to ask? ");
    if (weirdBit) this.scan.nextLine();
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
  // works
  public Card giveCard(int value) {
    Card match = null;
    for (int i = 0; i < this.hand.size(); i++) {
      if (this.hand.get(i).getValue() == value) {
        match = this.hand.get(i);
        this.hand.remove(i);
        return match;
      }
    }
    return match;
  }

  /**
  * this is a method that adds a card 
  * to the player's hand
  * @param the card being added
  */
  // works
  public void goFish(Card card) {
    this.hand.add(card);
  }

  /**
  * this is a method that gets a value from the user
  * @return the value of the card being looked for
  */
  //does not work
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
        if (token.equals("a")){
          value = 1;
          gotValue = true;
        }
        else if (token.equals("j")) {
          value = 11;
          gotValue = true;
        }
        else if (token.equals("q")) {
          value = 12;
          gotValue = true;
        }
        else if (token.equals("k")) {
          value = 13;
          gotValue = true;
        }
      }
      if (value > 1 && value < 11) gotValue = true;
      if (!hasValue(value) && gotValue) {
        System.out.println("You do not have that value in your hand.");
        gotValue = false;
      }
      else if (!gotValue) System.out.println("That is not a valid card value.");
    } while (!gotValue);
    return value;
  }

  /**
  * this is a method that checks if the player
  * is the player being asked
  * @param the name being checked
  * @return if the player has that name
  */
  // works
  public boolean checkName(String name) {
    name = name.replaceAll("\\s", "_");
    name = name.toLowerCase();
    return this.name.equals(name);
  }

  /**
  * returns true if the player has a card with that value
  * @param value the value being looked for
  */
  // works
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
  // works
  public String askName() {
    System.out.print("What would you like your name to be? ");
    String player = this.scan.nextLine();
    player = player.replaceAll("\\s", "_");
    player = player.toLowerCase();
    return player;
  }

  /**
  * this is a method that checks 
  * if the player has any matches
  * @returns the number of pairs the player has
  */
  // works
  public int checkPairs() {
    for (int i = 0; i < this.hand.size(); i++) {
      for (int j = i; j < this.hand.size(); j++) {
        int a = this.hand.get(i).getValue();
        int b = this.hand.get(j).getValue();
        if (a == b && i != j) {
          this.numPairs++;
          this.hand.remove(j);
          this.hand.remove(i);
          i--;
          j = this.hand.size();
        }
      }
    }
    return numPairs;
  }

  /**
  * this is a method that returns a string
  * representing the player's hand
  * @returns the player's hand
  */
  // works
  public String getHand() {
    String hand = "";
    for (Card card : this.hand) hand += card.toString() + ", ";
    return hand;
  }

  /**
  * this is a method that tells if the player has cards
  * @returns if the player has cards
  */
  // works
  public boolean hasCards() {
    return this.hand.size() > 0;
  }

  /**
  * this is a method that returns the player's name
  * @returns the player's name
  */
  // works
  public String getName() {
    return this.name;
  }

  /**
  * this is a method that tells if the player
  * being passed in is the same as the player object
  * @returns if the players are the same
  * @param the player being checked against
  */
  // works
  public boolean equals(Player player) {
    if (!checkName(player.name)) return false;
    else if (!this.getHand().equals(player.getHand()))
      return false;
    return true;
  }

  /**
  * this is a method that returns 
  * the number of pairs
  */
  // works
  public int getScore() {
    return this.numPairs;
  }
}