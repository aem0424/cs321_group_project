/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

/**
 *
 * @author User
 */
public class Ticket {
        
   public Ticket(Cart aCart, OType o)
   {
        cart = aCart;
        this.o = o;
   }
   
   public void changeStatus(int newStatus)
   {
       status = newStatus;
   }
   
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
   
   public OType getOType()
   {
       return o;
   }
   
   public String displayFood()
   {
       return cart.displayFood();
   }
   
    private final Cart cart;
    private int status;
    private final OType o;
}
