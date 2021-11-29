package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Soup.java
 Dr. Huaming Zhang
 CS 321-03
 November 28, 2021

This is a VERY early version of the Soup class. It will be added onto and
revised later, and will get a proper description then.
*/


public class Soup implements Food {
    @Override
    public float getPrice() {
        price = Constants.DATABASE.seekPrice(type,size);
        return price;
    }
    
    @Override
    public int getType() {
        return type; // May change this later once other classes are completed
    }
    
    @Override
    public int getSize() {
        return size; // Same as above
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public void setSize(int input) {
        if (input == 0 || input == 1) // Valid sizes for this food
            size = input;
        else
            System.out.println("ERROR: This size is not supported for " + getName() + ".");
    }
    
    // PRIVATE VARIABLES
    private float price = 0f;
    private final int type = 2; // Type 1 corresponds to salad
    private int size = 0; // Default size is 0 (small); can also be 1 (large)
    private final String name = "Soup"; // Can be defined since it only has one possible name
} // END OF FILE