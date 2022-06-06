import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Player player = new Player(new Scanner(System.in));
    Card two = new Card (1);
    Card three = new Card (2);
    Card four = new Card (3);
    Card five = new Card (4);
    Card six = new Card (5);
    Card threeHeart = new Card (15);
    Card fourHeart = new Card (16);

    player.goFish(two);
    player.goFish(fourHeart);
    player.goFish(three);
    player.goFish(four);
    player.goFish(five);
    player.goFish(six);
    player.goFish(threeHeart);
    
    System.out.println(player.getHand());
    
    System.out.println(player.hasValue(3));
    
    System.out.println(player.hasValue(10));
    
    
    
    
  }
}