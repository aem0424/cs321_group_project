/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;
import java.util.ArrayList;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 OrderQueue.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

 This class holds any number of tickets, and adds/removes them as needed.
 
 @author User
*/
public class OrderQueue {
    /**
      The default constructor for the OrderQueue (initializes a new list of tickets).
    */      
    public OrderQueue()
    {
        queue = new ArrayList<Ticket>();
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
    public Ticket remove() {
        return queue.remove(0);
    }
    
    /**
      Adds a ticket object to the queue.
      @param item: The ticket object to be added to the queue.
    */   
    public void add(Ticket item) {
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
      @return food: The ticket to display, as a string.
    */         
    public String displayTicket()
    {
        String tickets = queue.toString();
        return tickets;
    }
    
    // PRIVATE VARIABLES
    private ArrayList<Ticket> queue; // The queue containing the ticket elements.
} // END OF FILE