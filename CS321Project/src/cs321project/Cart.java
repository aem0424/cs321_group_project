/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321_project;

import java.util.ArrayList;
/**
 *
 * @author matth
 */
public class Cart {
    
    public Cart() {
        queue = new ArrayList<FoodItem>();
    }
    
    public void clear() {
        queue.clear();
    }
    
    public FoodItem remove() {
        return queue.remove(0);
    }
    
    public void add(FoodItem item) {
        queue.add(item);   
    }
    
    public int size() {
        return queue.size();
    }
    
    private ArrayList<FoodItem> queue;
}
