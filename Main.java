import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Game game = new Game(new Scanner(System.in), 3);
    
    game.playGame();
  }
}