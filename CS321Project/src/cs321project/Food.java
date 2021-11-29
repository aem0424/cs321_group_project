package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Food.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

 This class defines an interface that the menu item classes will extend; this
 will serve as a "base" for the classes it extends, all of which will need to
 define their own versions of the base functions defined below.
 
 @author anthony_matthews
*/

public interface Food {
    float getPrice(); // Returns the price of the item (float by default)
    int getType(); // Returns the item's type
    int getSize(); // Returns the item's size, corresponding to an int value
    String getName(); // Returns the name of the menu item
    public int getKind(); // Gets the food's kind (i.e. modifier), if applicable
    public String getKindName(); // Returns the name of the food's kind
    public void setKind(int input); // Sets the food's kind to the desired value
    public void setSize(int input); // Sets the food's size to the desired value
} // END OF FILE
