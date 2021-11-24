package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 INTERFACE CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

 This class defines an interface that the menu item classes will extend; this
 will serve as a "base" for the classes it extends, all of which will need to
 define their own versions of the base functions defined below.
*/

public interface Interface {
    float getPrice(); // Returns the price of the item (float by default)
    int getType(String aType); // Returns the item's type if applicable
    int getSize(String aSize); // Returns the item's size, corresponding to an int value
    String getName(); // Returns the name of the menu item; type determines the name for some (we may need this)
} // END OF FILE
