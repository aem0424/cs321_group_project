/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 SOUP CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 15, 2021

This is a very early version of the SALAD class. It will be added onto and
revised later, and will get a proper description then. 
 */
public class Salad implements Food {
    @Override
    public float getPrice(){
        return price; // enter a calculation here
    }
    
    @Override
    public int getType() {
        return 0; // change this once the other classes are completed
    }
    

    public int GetSize(){
        return 0; //channge this once other classes are completed
    }
    
    @Override
    public String getName(){
         if (type == Type.SALAD)
             name = "Salad";
         else 
             name = "tba";
         return name;
    }
    
    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    //PRIVATE VARIABLES
private float price;
Type type = Type.SALAD;
private String name;
private enum Type { SALAD } ;
private enum Size { HALF , WHOLE };

}