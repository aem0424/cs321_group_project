package cs321project;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matth
 */
public class Soup extends FoodItem {
    
    public Soup(Double p, Boolean t, Boolean s) {
        super("Soup");
        
    }
    
    private final String name;
    private final Double price = 1.00;
    private final byte temp = 1;
    private final byte size;
}
