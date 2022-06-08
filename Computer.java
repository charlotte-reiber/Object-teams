import java.util.Scanner;
import java.util.Random;

class Computer extends Player {
  Player[] others;
  Random rand;
  public Computer() {
    super(new Scanner(System.in));
    this.rand = new Random();
  }

  /**
  * this is a method that tells the computer 
  * who the other players are
  */
  public void initializePlayers(int self, Player[] others) {
    Player[] players = new Player[others.length - 1];
    int index = 0;
    for (Player player : players) {
      if (index != self) player = others[index];
      index++;
    }
    this.others = players;
  }
  
  public String askPlayer(boolean weirdBit) {
    int index = this.rand.nextInt(this.others.length);
    return this.others[index].getName();
  }

  
}