/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321project;

import java.util.ArrayList;
/**
 *
 * @author matth
 */
public class Cart {
    
    public Cart() {
        queue = new ArrayList<Food>();

    }
    
    public void clear() {
        queue.clear();
    }
    
    public Food remove() {
        return queue.remove(0);
    }
    
    public void add(Food item) {
        queue.add(item);   
    }
    
    public int size() {
        return queue.size();
    }
    
    public String displayFood()
    {
        String food = queue.toString();
        return food;
    }
    
    private ArrayList<Food> queue;

}