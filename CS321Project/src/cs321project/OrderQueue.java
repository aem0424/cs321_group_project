/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class OrderQueue {
    
    public OrderQueue()
    {
        queue = new ArrayList<Ticket>();
    }

    public void clear() {
        queue.clear();
    }
    
    public Ticket remove() {
        return queue.remove(0);
    }
    
    /**
     * Adds a ticket to queue
     * @author User
     * @param item
     */    
    public void add(Ticket item) {
        queue.add(item);   
    }
    
    public int size() {
        return queue.size();
    }
    
    public String displayTicket()
    {
        String tickets = queue.toString();
        return tickets;
    }
    
    private ArrayList<Ticket> queue;
}
