/*
  This object just works; takes a graphics object, a string (s, h, d, c) and a size. DO NOT MESS WITH THIS.
*/

import java.awt.*;

class Suit {
  private Graphics2D graph;
  private String suit;
  private int size;
  private int width;
  private int hight;
  private int center;
  private int middle;

  public Suit(Graphics2D graph, String suit, int size) {
    this.suit = suit;
    this.graph = graph;
    this.size = size;
    this.width = this.size; //36
    this.hight = this.size * 7 / 6; //42
    this.center = this.width / 2; //18
    this.middle = this.hight / 2; //21
  }

  public void draw(int x, int y) {
    x -= this.center;
    y -= this.middle;
    if (suit.equals("♠")) drawSpade(x, y);
    else if (suit.equals("♥")) drawHeart(x, y);
    else if (suit.equals("♦")) drawDiamond(x, y);
    else drawClub(x, y);
  }

  private void drawSpade(int x, int y) {
    int circleHight = this.center * 5 / 4; //14
    int arcHight = this.middle - this.hight / 4; //11
    int triWidth = this.width / 8;
    int move4 = this.width / 9; //4
    int move2 = move4 / 2; //2
    int triHight = circleHight / 2 + move2 + 1;

    Polygon triangleA = new Polygon();
    triangleA.addPoint(x + this.center, y + this.middle);
    triangleA.addPoint(x + this.center + triWidth, y + this.hight);
    triangleA.addPoint(x + this.center - triWidth, y + this.hight);

    Polygon triangleB = new Polygon();
    triangleB.addPoint(x + move4, y + triHight);
    triangleB.addPoint(x + this.width - move4, y + triHight);
    triangleB.addPoint(x + this.center, y);

    this.graph.fillOval(x, y + arcHight, this.center, circleHight);
    this.graph.fillOval(x + this.center, y + arcHight, this.center, circleHight);
    this.graph.fillOval(x + move2, y + triHight, this.width - move4, arcHight);
    this.graph.fillPolygon(triangleA);
    this.graph.fillPolygon(triangleB);
  }

  private void drawHeart(int x, int y) {
    int arcHight = this.hight * 2 / 3; //28
    int move4 = this.width / 9; //4
    int move2 = move4 / 2; //2
    int move1 = move2 / 2; //1

    Polygon triangle = new Polygon();
    triangle.addPoint(x + move1, y + this.middle);
    triangle.addPoint(x + width - move1, y + this.middle);
    triangle.addPoint(x + this.center, y + this.hight);

    this.graph.fillOval(x, y, this.center, arcHight);
    this.graph.fillOval(x + this.center, y, this.center, arcHight);
    this.graph.fillOval(x + this.center / 2, y + this.middle / 2, this.center, this.middle);
    this.graph.fillRect(x + move2, y + arcHight / 2, this.width - move4, arcHight / 4);
    
    this.graph.fillPolygon(triangle);
  }

  private void drawDiamond(int x, int y) {
    Polygon diamond = new Polygon();
    diamond.addPoint(x + this.center, y);
    diamond.addPoint(x + this.width, y + this.middle);
    diamond.addPoint(x + this.center, y + this.hight);
    diamond.addPoint(x, y + this.middle);

    this.graph.fillPolygon(diamond);
  }

  private void drawClub(int x, int y) {
    int circleHight = this.center * 5 / 4; //14
    int arcHight = this.middle - this.hight / 4;
    int triWidth = this.width / 8;

    Polygon triangle = new Polygon();
    triangle.addPoint(x + this.center, y + this.middle);
    triangle.addPoint(x + this.center + triWidth, y + this.hight);
    triangle.addPoint(x + this.center - triWidth, y + this.hight);

    this.graph.fillOval(x, y + arcHight, this.center, circleHight);
    this.graph.fillOval(x + this.center, y + arcHight, this.center, circleHight);
    this.graph.fillOval(x + this.center / 2, y, this.center, circleHight);
    this.graph.fillPolygon(triangle);
  }
}