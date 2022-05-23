import java.util.ArrayList;

class Player {
  private String name;
  private ArrayList<Card> hand = new ArrayList<Card>();
  private int numPairs = 0;
  
  public Player(String name) {
    this.name = name;
  }

  public String askPlayer() {
    return "hi";
  }
}