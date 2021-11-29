package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Sandwich.java
 Dr. Huaming Zhang
 CS 321-03
 November 28, 2021

This is a VERY early version of the Sandwich class. It will be added onto and
revised later, and will get a proper description then.
*/


public class Sandwich implements Food {
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
    
    public int getKind() {
        return kind;
    }
    
    public String getKindName() {
        return kindName;
    }
    
    public void setKind(int input) {
        if (input == 0 || input == 1) {
            kind = input;
            kindName = kindArray[input];
        }
        else
            System.out.println("ERROR: This kind is not supported for " + getName() + ".");
    }
    
    public void setSize(int input) {
        if (input == 0 || input == 1) // Valid sizes for this food
            size = input;
        else
            System.out.println("ERROR: This size is not supported for " + getName() + ".");
    }
    
    // PRIVATE VARIABLES
    private float price = 0f;
    private final int type = 0; // Type 1 corresponds to salad
    private int size = 0; // Default size is 0 (small); can also be 1 (large)
    private int kind = 0; // 0 corresponds to Cold, 1 corresponds to Hot
    private final String name = "Sandwich"; // Can be defined since it only has one possible name
    private final String[] kindArray = new String[]{"Cold", "Hot"}; // Initializes an array containing all possible sandwich kinds (hot, cold, etc.)
    private String kindName = kindArray[0]; // Defaults to "Cold"
} // END OF FILE