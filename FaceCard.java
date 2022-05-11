/*
  This object just works; takes a graphics object, a string (s, h, d, c), another string (j, q, k, a) and a size. DO NOT MESS WITH THIS.
*/

import java.awt.*;

class Special {
  private Graphics2D graph;
  private String s;
  private String v;
  private int size;
  private Suit suit;

  public Special(Graphics2D graph, String suit, String value, int size) {
    this.s = suit;
    this.v = value;
    this.graph = graph;
    this.size = size;
    this.suit = new Suit(this.graph, this.s, this.size / 6);
  }

  public void draw(int x, int y) {
    if (this.v.equals("K")) drawKing(x, y);
    else if (this.v.equals("Q")) drawQueen(x, y);
    else if (this.v.equals("J")) drawJack(x, y);
    else drawAce(x, y);
    this.graph.setColor(Color.WHITE);
    this.suit.draw(x, y);
  }

  private void drawBody(int x, int y) {
    int two = this.size / 6;
    int three = this.size / 4;
    int four = two * 2;
    int five = two + three;
    
    Polygon body = new Polygon();
    body.addPoint(x - two, y);
    body.addPoint(x - two, y - two);
    body.addPoint(x, y - two);
    body.addPoint(x + two, y);

    this.graph.fillOval(x - two, y - five, four, three);
    this.graph.fillPolygon(body);
  }

  private void drawCrown(int x, int y, boolean isKing) {
    int two = this.size / 6;
    int one = this.size / 12;
    int three = this.size / 4;
    int six = this.size / 2;
    int eight = six + two;
    if (!isKing) eight -= one;

    Polygon a = new Polygon();
    a.addPoint(x - one, y - three);
    a.addPoint(x + one, y - three);
    a.addPoint(x - two, y - six);

    Polygon b = new Polygon();
    b.addPoint(x - one, y - three);
    b.addPoint(x + one, y - three);
    b.addPoint(x + two, y - six);

    Polygon c = new Polygon();
    c.addPoint(x - one, y - three);
    c.addPoint(x + one, y - three);
    c.addPoint(x, y - eight);

    this.graph.fillPolygon(a);
    this.graph.fillPolygon(b);
    this.graph.fillPolygon(c);
  }

  private void drawTiara(int x, int y) {
    //1 3 4 5
    int one = this.size / 12;
    int three = this.size / 4;
    int four = this.size / 3;
    int five = this.size / 6 + three;

    Polygon a = new Polygon();
    a.addPoint(x - one, y - three);
    a.addPoint(x + one, y - three);
    a.addPoint(x - three, y - five);

    Polygon b = new Polygon();
    b.addPoint(x - one, y - three);
    b.addPoint(x + one, y - three);
    b.addPoint(x + three, y - five);

    Polygon c = new Polygon();
    c.addPoint(x - three, y - three);
    c.addPoint(x + three, y - three);
    c.addPoint(x, y - four);

    this.graph.fillPolygon(a);
    this.graph.fillPolygon(b);
    this.graph.fillPolygon(c);
  }

  private void drawSepter(int x, int y) {
    int one = this.size / 12;
    int three = this.size / 4;
    int four = this.size / 3;

    this.graph.setStroke(new BasicStroke(3));
    this.graph.drawLine(x + four, y - three, x, y);
    this.graph.fillOval(x + three, y - three, one, one);
  }

  public void drawKing(int x, int y) {
    for (int i = 0; i < 2; i++) {
      drawBody(x, y);
      drawCrown(x, y, true);
      drawSepter(x, y);
      this.graph.rotate(Math.toRadians(180), x, y);
    }
  }

  public void drawQueen(int x, int y) {
    for (int i = 0; i < 2; i++) {
      drawBody(x, y);
      drawCrown(x, y, false);
      drawTiara(x, y);
      drawSepter(x, y);
      this.graph.rotate(Math.toRadians(180), x, y);
    }
  }

  public void drawJack(int x, int y) {
    for (int i = 0; i < 2; i++) {
      drawBody(x, y);
      drawCrown(x, y, false);
      this.graph.rotate(Math.toRadians(180), x, y);
    }
  }

  public void drawAce(int x, int y) {
    int size = this.size * 2 / 3;
    Suit ace = new Suit(this.graph, this.s, size);
    ace.draw(x, y);
  }
}