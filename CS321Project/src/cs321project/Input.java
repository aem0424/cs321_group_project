/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Input {
    /**
      Construct phone object.
   */
   public Input()
   {
      //GUI code here
   }

   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hangup.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run(Connection c)
   {
      boolean more = true;
      while (more)
      {
         String input = scanner.nextLine();
         if (input == null) return;
         if (input.equalsIgnoreCase("H"))
            c.hangup();
         else if (input.equals("77"))
            c.paymentMenu();
         else if (input.equalsIgnoreCase("Q"))
            more = false;
         else if (input.length() == 1
            && "1234567890#".indexOf(input) >= 0)   //Change this
            c.dial(input);
         else
            c.record(input);
      }
   }

   private Scanner scanner;
}
