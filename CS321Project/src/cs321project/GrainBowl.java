package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 GrainBowl.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

This is a VERY early version of the GrainBowl class. It will be added onto and
revised later, and will get a proper description then.
*/


public class GrainBowl implements Food {
    @Override
    public float getPrice() {
        price = Constants.DATABASE.seekPrice(type,size); // For the Grain Bowl, should only return one value
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
    
    // PRIVATE VARIABLES
    private float price = 0f;
    private final int type = 4; // Type 4 coresponds to GrainBowl
    private int size = 1; // Not set to final in the event that a new size would be defined
    private final String name = "Grain Bowl"; // Can be defined since it only has one possible name
} // END OF FILE