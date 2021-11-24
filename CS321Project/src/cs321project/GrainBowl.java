package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 GRAINBOWL CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

This is a VERY early version of the GrainBowl class. It will be added onto and
revised later, and will get a proper description then.
*/


public class GrainBowl implements Interface {
    @Override
    public float getPrice() {
        return price; // Put a calculation here later
    }
    
    @Override
    public int getType() {
        return 0; // May change this later once other classes are completed
    }
    
    @Override
    public int getSize() {
        return 0; // Same as above
    }
    
    @Override
    public int[] getExtras() {
        return extras;        
    }
    
    @Override
    public String getName() {
        if (type == Type.GRAIN)
            name = "Grain Bowl";
        else
            name = "tba";
        return name;
    }
    
    
    // PRIVATE VARIABLES
    private float price;
    Type type = Type.GRAIN;
    Size size = Size.LARGE;
    private int[] extras = new int[0]; // Protoypical; will likely be changed
    private String name; // Can be defined since it only has one possible name
    private enum Type { GRAIN }; // Not really a variable, but defined here for organization's sake
    private enum Size { LARGE }; // Only size possible (enum in case more options are added later)
}