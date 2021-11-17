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

   public static void main(String[] args)
   {
      OrderQueue orderq = new OrderQueue(TICKET_COUNT);
      
      Input i = new Input();
      Connection c = new Connection(orderq, i);
      i.run(c);
   }

   private static final int TICKET_COUNT = 20;
    
}
