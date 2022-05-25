/*
  This object just works; takes a graphics object, a hight and a width. DO NOT MESS WITH THIS.
*/

import java.awt.*;

class CardBack {
  private Graphics2D graph;
  private int hight;
  private int width;
  private int center;
  private int middle;

  private static final Color color = new Color(70, 50, 150);
  
  CardBack(Graphics2D g, int h, int w) {
    this.graph = g;
    this.hight = h;
    this.width = w;
    this.center = this.width / 2;
    this.middle = this.hight / 2;
    System.out.println(this.width + " " + this.hight);
  } 

  public void draw(int x, int y) {
    int left = x - this.center;
    int top = y - this.middle;
    int diam = this.width / 18;
    this.graph.setColor(this.color);
    this.graph.fillRect(left, top, this.width, this.hight);
    this.graph.setColor(Color.WHITE);
    for (int i = top; i < top + this.hight; i += diam) {
      for (int j = left; j < left + this.width; j += diam) {
        this.graph.fillOval(j, i, diam, diam);
      }
    }
  }

}