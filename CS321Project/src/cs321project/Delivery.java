/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Delivery.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021
 
 A class indicating that the order will be delivered.
 
 @author ???
*/
public abstract class Delivery implements OType {
    /**
      Gets the type of delivery this class represents.
      @return A string indicating that this is a Delivery-type order.
    */  
    @Override
    public String getType()
    {
        return "Delivery";
    }
} // END OF FILE