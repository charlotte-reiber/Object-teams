//import java.awt.*;
import java.util.Scanner;

class Game {
  private Deck deck;
  private Player[] players;
  private Player active;
  private Player recipient;
  private static final int NUMDELT = 7;
  
  public Game(Scanner scan, int numPlayers) {
    this.deck = new Deck(52);
    this.players = new Player[numPlayers];
    for (int i = 0; i < players.length; i++)
      players[i] = new Player(scan);
    
  }

  /**
  * this is a method that executes
  * a single round of turns
  */
  private void turn(boolean firstTurn) {
    boolean foundRecipient = false;
    String name;
    Card exchanged;
    int value;
    do {
      name = active.askPlayer(firstTurn);
      if (playerExists(name)) {
        foundRecipient = true;
        for (Player player : this.players) {
          if (player.checkName(name)) 
            this.recipient = player;
        }
      }
      firstTurn = false;
    } while (!foundRecipient);
    value = this.active.askValue(); 
    if (this.recipient.hasValue(value)) {
      System.out.println(this.recipient.getName() + 
        " has a " + value + "!");
      exchanged = this.recipient.giveCard(value);
      this.active.goFish(exchanged);
    } else {
      this.active.goFish(this.deck.drawCard());
      System.out.println(this.recipient.getName() + 
        " doesn't have a " + value + ".\nGo Fish!");
    }
    this.active.checkPairs();
  }

  /**
  * this is a method that gets a name from a player
  * and checks to see if that player exists
  */
  private boolean playerExists(String name) {
    for (Player player : this.players) {
      if (player.getName().equals(name)
         && !player.equals(this.active)) {
        this.recipient = player;
        return true; 
      }
    }
    System.out.println("That is not a valid player name.");
    return false;
  }

  /**
  * this is a method that checks 
  * if the game is over
  */
  private boolean gameOver(int numRounds) {
    if (numRounds > 10) return false;
    for (Player player : this.players) {
      if (!player.hasCards()) return true;
    }
    return false;
  }

  /**
  * this is a method that plays the game
  */
  public void playGame() {
    boolean nextTurn = false;
    int numRounds = 1;
    deal();
    int[] scores = new int[this.players.length];
    while (!gameOver(numRounds)) {
      for (Player player : this.players) {
        if (!gameOver(numRounds)){ 
          this.active = player;
          this.active.checkPairs();
          System.out.println("\nit is " + 
            this.active.getName() + "'s turn: ");
          System.out.println(this.active.getName() + 
            "'s hand: " + this.active.getHand());
          turn(nextTurn);
          nextTurn = true;
          System.out.println(this.active.getName() + 
            "'s hand is now: " + this.active.getHand());
          System.out.println(this.active.getName() + 
            " has " + this.active.getScore() + " pairs.");
        }
      }
      numRounds++;
    }
    
    Player[] winners = decideWinner();
    System.out.println("\nWinners:");
    for (Player winner : winners) 
      System.out.println(winner.getName());
  }

  /**
  * this is a method that determines the winners
  */
  private Player[] decideWinner() {
    int[] scores = new int[this.players.length];
    for (int i = 0; i < this.players.length; i++)
      scores[i] = this.players[i].getScore();

    int highestScore = 0;
    int numOccurance = 0;

    for (int score : scores) {
      if (score > highestScore) highestScore = score;
    }

    for (int score : scores) 
      if (score == highestScore) numOccurance++;

    Player[] winners = new Player[numOccurance];
    int index = 0;

    for (Player participant : this.players) {
      if (participant.getScore() == highestScore) {
        winners[index] = participant;
        index++;
      }
    }

    return winners;
  }

  /**
  * this is a method that deals the cards
  */
  private void deal() {
    for (int i = 0; i < NUMDELT; i++) {
      for (Player player: this.players) {
        player.goFish(this.deck.drawCard());
      }
    }
  }
}