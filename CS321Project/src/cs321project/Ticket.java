/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Ticket.java
 Dr. Huaming Zhang
 CS 321-03
 November 28, 2021

 An object of this class is created after an order is completed; it contains all
 of the food in the order, as well as the status of the order itself (delivered,
 in process, etc).
 
 @author ???
*/
public class Ticket {
    /**
      The default constructor for a Ticket object.
      @param aCart: The food items in the order.
      @param o: The type of order this ticket will represent.
    */       
   public Ticket(Cart aCart, OType o)
   {
        cart = aCart;
        this.o = o;
   }

    /**
      Changes the state of a ticket.
      @param newStatus: The state to change a ticket's status to.
    */    
   public void changeStatus(int newStatus)
   {
       status = newStatus;
   }

    /**
      Gets a ticket's current status.
      @return A string indicating a ticket's current status.
    */    
   public String getStatus()
   {
       switch (status) {
           case 1:
               return "Preparing Order";
           case 2:
               return "Order Delivery In Progress";
           case 3:
               return "Order Delivered";
           case 4:
               return "Order Ready for Pickup";
           default:
               return "Invalid Status";
       }
   }

    /**
      Gets what kind of order this ticket represents.
      @return o: The OType (OrderType) for this ticket.
    */    
   public OType getOType()
   {
       return o;
   }

    /**
      Displays the food as a string, using a cart object.
      @return cart.displayFood(): The kind of food, represented from the cart.
    */    
   public String displayFood()
   {
       return cart.displayFood();
   }
   
    // PRIVATE VARIABLES
    private final Cart cart; // The cart, containing the food data in the order
    private int status; // The current state of the order
    private final OType o; // The type of order this ticket is
} // END OF FILE