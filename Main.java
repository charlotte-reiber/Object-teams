import java.awt.*;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Deck deck = new Deck(52);
    Scanner scan = new Scanner(System.in);
    Player user = new Player("bob", scan);
    user.askPlayer();
  }
}