//import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;

class Game {
  private Scanner scan;
  private Deck deck;
  private Player[] players;
  private Player active;
  private Player recipient;
  
  public Game(Scanner scan, int numPlayers) {
    this.deck = new Deck(52);
    this.scan = scan;
    this.players = new Player[numPlayers];
    for (int i = 0; i < players.length; i++)
      players[i] = new Player(scan);
    
  }

  /**
  * this is a method that executes
  * a single round of turns
  */
  public void turn() {
    String name;
    Card exchanged;
    int value;
    do {
      name = active.askPlayer();
    } while (playerExists(name));
    value = this.active.askValue(); 
    if (this.recipient.hasValue(value)) {
      exchanged = this.recipient.giveCard(value);
      this.active.goFish(exchanged);
      this.active.checkPairs();
    } else {
      this.active.goFish(this.deck.drawCard());
    }
  }

  /**
  * this is a method that gets a name from a player
  * and checks to see if that player exists
  */
  public boolean playerExists(String name) {
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
  public boolean gameOver() {
    for (Player player : this.players) {
      if (!player.hasCards()) return true;
    }
    return false;
  }

  /**
  * this is a method that plays the game
  */
  public void playGame() {
    int[] scores = new int[this.players.length];
    while (!gameOver()) {
      for (Player player : this.players) {
        if (!gameOver()){ 
          this.active = player;
          System.out.println("it is " + 
            this.active.getName() + "'s turn: ");
          turn();
        }
      }
    }
    
    for (int i = 0; i < scores.length; i++) {
      scores[i] = this.players[i].getScore();
    }

    ArrayList<Player> winners = decideWinner(scores);
    System.out.println("Winners:");
    for (Player winner : winners) 
      System.out.println(winner.getName());
  }

  /**
  * this is a method that determines the winners
  */
  public ArrayList<Player> decideWinner(int[] scores) {
    ArrayList<Player> winners = new ArrayList<Player>();
    int highestScore = 0;
    for (int score : scores) {
      if (score > highestScore) score = highestScore;
    }
    for (Player player : this.players) {
      if (player.getScore() == highestScore) {
        winners.add(player);
      }
    }
    return winners;
  }
}