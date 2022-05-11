import java.awt.*;

public class CardFront {
  private Graphics2D graph;
  private String v;
  private String s;
  private Suit suit;
  private Special special;
  private CardBack back;

  private static final int SIZE = 12;
  
  public CardFront(Graphics2D g, String suit, String value) {
    this.graph = g;
    this.v = value;
    this.s = suit;
    this.suit = new Suit(this.graph, this.s, SIZE * 3 / 2);
    this.special = new Special(this.graph, this.s, this.v, SIZE * 8);
    this.back = new CardBack(this.graph, SIZE * 25 / 2, SIZE * 15 / 2);
  }

  // this bit of code is important to the rendering process
  //draws the card
  public void draw(int x, int y) {
    drawBlank(x, y);
    if ("♠".equals(this.s)||"♣".equals(this.s)) 
      this.graph.setColor(Color.BLACK);
    else this.graph.setColor(Color.RED);
    if (this.v.equals("2")) drawTwo(x, y);
    else if (this.v.equals("3")) drawThree(x, y);
    else if (this.v.equals("4")) drawFour(x, y);
    else if (this.v.equals("5")) drawFive(x, y);
    else if (this.v.equals("6")) drawSix(x, y);
    else if (this.v.equals("7")) drawSeven(x, y);
    else if (this.v.equals("8")) drawEight(x, y);
    else if (this.v.equals("9")) drawNine(x, y);
    else if (this.v.equals("10")) drawTen(x, y);
    else {
      this.special.draw(x + SIZE * 9 / 2, y + SIZE * 7);
    }
  }

  // this bit of code is important to the rendering process
  //draws a blank card
  private void drawBlank(int x, int y) {
    this.graph.setColor(Color.WHITE);
    int radius = SIZE * 3 / 4; 
    int diam = SIZE * 3 / 2;
    int hight = SIZE * 14;
    int width = SIZE * 9;
    int inHight = hight - diam;
    int inWidth = width - diam;

    this.graph.fillRect(x + radius, y, inWidth, hight);
    this.graph.fillRect(x, y + radius, width, inHight);

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++)
        this.graph.fillOval(x + i * inWidth, y + j * inHight, diam, diam);
    }
  }

  // this bit of code is important to the rendering process
  private void drawTwo(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    int spacing = SIZE * 7 / 3;
    this.suit.draw(center, middle - spacing);
    this.suit.draw(center, middle + spacing);
  }

  // this bit of code is important to the rendering process
  private void drawThree(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    int spacing = SIZE * 7 / 2;
    this.suit.draw(center, middle);
    this.suit.draw(center, middle - spacing);
    this.suit.draw(center, middle + spacing);
  }

  // this bit of code is important to the rendering process
  private void drawFour(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    int spaceV = SIZE * 7 / 2;
    int spaceH = SIZE * 2;
    this.suit.draw(center - spaceH, middle - spaceV);
    this.suit.draw(center + spaceH, middle + spaceV);
    this.suit.draw(center - spaceH, middle + spaceV);
    this.suit.draw(center + spaceH, middle - spaceV);
  }

  // this bit of code is important to the rendering process
  private void drawFive(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    drawFour(x, y);
    this.suit.draw(center, middle);
    
  }

  // this bit of code is important to the rendering process
  private void drawSix(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    int spaceV = SIZE * 7 / 2;
    int spaceH = SIZE * 2;
    this.suit.draw(center + spaceH, middle);
    this.suit.draw(center + spaceH, middle - spaceV);
    this.suit.draw(center + spaceH, middle + spaceV);
    this.suit.draw(center - spaceH, middle);
    this.suit.draw(center - spaceH, middle - spaceV);
    this.suit.draw(center - spaceH, middle + spaceV);
  }

  // this bit of code is important to the rendering process
  private void drawSeven(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    int spaceV = SIZE * 7 / 3;
    int spaceH = SIZE * 2;
    this.suit.draw(center - spaceH, middle - spaceV);
    this.suit.draw(center + spaceH, middle + spaceV);
    this.suit.draw(center - spaceH, middle + spaceV);
    this.suit.draw(center + spaceH, middle - spaceV);
    drawThree(x, y);
  }

  // this bit of code is important to the rendering process
  private void drawEight(int x, int y) {
    drawTwo(x, y);
    drawSix(x, y);
  }

  // this bit of code is important to the rendering process
  private void drawNine(int x, int y) {
    drawSix(x, y);
    drawThree(x, y);
  }

  // this bit of code is important to the rendering process
  private void drawTen(int x, int y) {
    int middle = SIZE * 7 + y;
    int center = SIZE * 9 / 2 + x;
    int spaceVA = SIZE * 7 / 5;
    int spaceVB = spaceVA * 3;
    this.suit.draw(center, middle - spaceVA);
    this.suit.draw(center, middle + spaceVA);
    this.suit.draw(center, middle - spaceVB);
    this.suit.draw(center, middle + spaceVB);
    drawSix(x, y);
  }

  // this bit of code is important to the rendering process
  public void drawBack(int x, int y) {
    drawBlank(x, y);
    this.back.draw(x + SIZE * 9 / 2, y + SIZE * 7);
  }
}