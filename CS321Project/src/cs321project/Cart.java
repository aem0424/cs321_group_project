/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Cart.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

This is a VERY early version of the GrainBowl class. It will be added onto and
revised later, and will get a proper description then.
 
@author matt
*/
import java.util.ArrayList;
public class Cart {

    /**
      The default constructor for the Cart (initializes a new list of food).
    */     
    public Cart() {
        queue = new ArrayList<Food>();

    }
    
    /**
      Clears the queue, removing all elements.
    */     
    public void clear() {
        queue.clear();
    }
    
    /**
      Deletes the first object in the queue.
      @return queue.remove(0): The queue, with the first element removed.
    */     
    public Food remove() {
        return queue.remove(0);
    }

    /**
      Adds a food object to the queue.
      @param item: The food object to be added to the queue.
    */     
    public void add(Food item) {
        queue.add(item);   
    }

    /**
      Gets the size of the queue as an integer.
      @return queue.size(): The total number of elements in the queue.
    */     
    public int size() {
        return queue.size();
    }

    /**
      Displays the current element as a string.
      @return food: The food to display, as a string.
    */     
    public String displayFood()
    {
        String food = queue.toString();
        return food;
    }
    
    // PRIVATE VARIABLES
    private ArrayList<Food> queue; // The queue containing the food elements
} // END OF FILE