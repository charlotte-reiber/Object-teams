//import java.awt.*;
import java.util.Scanner;

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

  public void turn(Player[] players) {
    String name;
    for (Player active : players) {
      this.active = active;
      do {
        name = active.askPlayer();
      } while (playerExists(name));
    }
  }

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
}