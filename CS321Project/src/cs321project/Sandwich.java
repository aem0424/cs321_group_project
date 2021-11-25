/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 SANDWICH CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 10, 2021
This is a very early version of the SANDWICH class. It will be added onto and
revised later, and will get a proper description then. 
 */

public abstract class Sandwich implements Interface {
    @Override
    public float getPrice(){
        return price; // enter a calculation here
    }
    
    @Override
    public int getType(String aType) {
        return 1; // change this once the other classes are completed
    }
    
    @Override
    public int getSize(String aSize) {
        if (size == Size.HOT)
        {
            return 1;
        }
        
        else if (size == Size.COLD)
        {
            size = Size.COLD;
            return 2;
        }
        
        else 
        {
            return 0;           //throw exception here?
        }
        
    }
 
    @Override
    public String getName(){
         if (type == Type.SANDWICH)
             name = "Sandwich";
         else 
             name = "tba";
         return name;
    }
    
    @Override
    public void setSize(String aSize) {
        if (Size.HOT.toString().equals(aSize))
        {
            size = Size.HOT;
        }
        
        else if (Size.COLD.toString().equals(aSize))
        {
            size = Size.COLD;
        }
        
        else 
        {
            
        }
        
    }
    
    //PRIVATE VARIABLES
    private float price;
    Type type = Type.SANDWICH;
    Size size;
    private String name;

    private enum Type { SANDWICH } ;
    private enum Size { HOT, COLD };

}