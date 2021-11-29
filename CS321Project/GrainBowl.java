package cs321project; // Change this, if needed
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 GrainBowl.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

 The class for the Grain Bowl food type, implementing functions from
 the Food interface class.
*/


public class GrainBowl implements Food {
    /**
      Gets the price according to the food type and the object's size.
      @return price: A float representing price; data is from the .XML file.
    */            
    @Override
    public float getPrice() {
        price = Constants.DATABASE.seekPrice(type,size); // For the Grain Bowl, should only return one value
        return price;
    }

    /**
      Gets the type, which indicates what kind of food it is.
      @return type: An integer representing the type of food.
    */            
    @Override
    public int getType() {
        return type; // May change this later once other classes are completed
    }

    /**
      Gets the size; larger items generally cost more.
      @return size: An integer representing the object's size.
    */         
    @Override
    public int getSize() {
        return size; // Same as above
    }

    /**
      Gets the name of the food, not counting kinds (if applicable).
      @return name: A string representing the name of the food.
    */               
    @Override
    public String getName() {
        return name;
    }

    /**
      Gets the kind, i.e. modifier, of a food object.
      @return 0: No kind is currently defined for this food type.
    */          
    @Override
    public int getKind() {
        return 0;
    }
    /**
      Gets the name of this object's kind from an array.
      @return kindName: This object's kind.
    */      
    @Override
    public String getKindName() {
        return kindName;
    }
    /**
      Sets the object's kind (i.e. modifier) to the input value; if the input
      would result in an invalid kind, reject the input.
      @param input: The desired kind, as input by the user.
    */    
    @Override
    public void setKind(int input) {  
        System.out.println("ERROR: Setting a kind is not supported for " + getName() + ".");
    }
     /**
      Sets the object's size to the input value; if the input would
      result in an invalid size, reject the input.
      @param input: The desired size, as input by the user.
    */     
    @Override
    public void setSize(int input) {
        System.out.println("ERROR: Setting a size is not supported for " + getName() + ".");
    }    
    
    // PRIVATE VARIABLES
    private float price = 0f; // The food's price; defaults to 0 in order to prevent the possible usage of a null value
    private final int type = 4; // Type 4 coresponds to GrainBowl
    private int size = 1; // Not set to final in the event that a new size would be defined
    private final String name = "Grain Bowl"; // The name of the food; used for printing the cart/ticket
    private String kindName = ""; // Not applicable for this food type
} // END OF FILE