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
public class CS321Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        OrderQueue orders = new OrderQueue();
        
        Interface GUI = new Interface();
        Connection c = new Connection(orders, GUI);
        GUI.run(c);
    }   
}
