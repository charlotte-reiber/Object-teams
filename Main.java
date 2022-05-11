import java.awt.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println("hello");

    DrawingPanel panel = new DrawingPanel(700, 500);
    panel.setBackground(Color.BLUE);
    
    Graphics g = panel.getGraphics();    
    Graphics2D graph = (Graphics2D)g;

    CardFront s3 = new CardFront(graph, 1);
    CardFront h5 = new CardFront(graph, 13 + 3);
    CardFront d7 = new CardFront(graph, 26 + 5);
    CardFront c10 = new CardFront(graph, 39 + 8);
    CardFront sk = new CardFront(graph, 11);
    CardFront hq = new CardFront(graph, 13 + 10);
    CardFront dj = new CardFront(graph, 26 + 9);
    CardFront ca = new CardFront(graph, 51);
    
    s3.draw(25, 25);
    hq.draw(150, 25);
    d7.draw(275, 25);
    ca.drawBack(400, 25);
    sk.draw(25, 250);
    h5.draw(150, 250);
    dj.draw(275, 250);
    c10.draw(400, 250);
  }
  //commenting to make sure stuff works
  // Israel was here!!!!!
}