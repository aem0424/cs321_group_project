package cs321_project; // Change this, if needed
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
    int getType(); // Returns the item's type if applicable
    int getSize(); // Returns the item's size, corresponding to an int value
    int[] getExtras(); // Made this an array if we use permutations for the extras (remove this if we don't use extras)
} // END OF FILE