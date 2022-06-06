import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Player player = new Player(new Scanner(System.in));
    Card[] hand = new Card[13];
    for (int i = 0; i < 13; i++) hand[i] = new Card(i);

    for (Card card : hand) player.goFish(card);

    System.out.println(player.getHand());
    
    for (int i = 0; i < 13; i++) System.out.println("the value the player is asking for is " + player.askValue());
    
    
    
    
  }
}