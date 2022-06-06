public class Card {

    static final String[] SUITES = { "♠", "♥", "♦", "♣" };
    static final String[] SPECIALS = { "A", "J", "Q", "K" };
    static final int NONSPECIALS = 9;
  
    private int      suite;
    private String   cardFace;
    private int      value;
    private int      cardValue;
    
    public Card(int input) {
      this.value = input%13;
      this.suite = input/13;
      this.cardFace = (value==0) ? SPECIALS[0] : ((value<10) ? String.valueOf(value+1) : SPECIALS[value-9]);
      cardValue = (value==0) ? 11 : ((value<10) ? value+1 : 10);
    }
  
    /**Returns the value of the card from 1-13
    */
    public int getValue() {
      return this.value + 1;
    }
  
    /**Returns the value of the card from 1-11
    */
    public int getCardValue() {
      return this.cardValue;
    }
  
    /**Returns the face value of the card
    */
    public String getFace() {
      return SUITES[this.suite]+this.cardFace;
    }
  
    public String toString() {
      return SUITES[this.suite]+this.cardFace;
    }
  
  }