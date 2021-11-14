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
public class Sandwich implements Interface {
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
    public int[] getExtras() {
        return extras;
    }
    
    @Override
    public String getName(){
         if (type == Type.Sandwich)
             name = "Sandwich";
         else 
             name = "tba";
         return name;
    }
    
    //PRIVATE VARIABLES
private float price;
Type type = Type.Sandwich;
private int[] extras = new int[0];
private String name;

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private enum Type { SANDWICH, Sandwich } ;
private enum Size { SMALL, LARGE };

}



