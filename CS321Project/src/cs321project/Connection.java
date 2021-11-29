/*
 * test
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Connection.java
 Dr. Huaming Zhang
 CS 321-03
 November 8, 2021

 This class establishes and contains the connection; this is how the user will
 perform various actions within the program.
 
 @author anjan
*/
public class Connection
{
   /**
      The default constructor for the Connection class.
      @param o: A new OrderQueue object.
      @param i: A new Interface object, used for user input.
   */
   public Connection(OrderQueue o, Interface i)
   {
      orderq = o;
      input = i;
      resetConnection();
   }

   /**
      Determines what menu to use, based on the object's state.
      @param key: The user's input.
   */
   public void dial(String key)
   {       
        if (state == WELCOME)
            welcomeMenu(key);
        else if (state == CREDENTIALS_MENU)
            credentialsMenu(key);
        else if (state == ORDER_MENU)
            orderMenu(key);
        else if (state == ORDER_OPT_MENU)
            orderOptMenu(key);
        else if (state == DELIVERY_MENU)
            deliveryMenu(key);
        else if (state == PAYMENT_MENU)
            paymentMenu(key);
        else if (state == SUBMIT_MENU)
            submitMenu(key);
        else if (state == PROCESSING_MENU)
            processMenu(key);
        else if (state == MANAGER_MENU)
            managerMenu(key);
        else if (state == LOGOUT_MENU)
            logoutMenu(key);
   }

   /**
      Resets the connection to its initial state.
   */
   private void resetConnection()
   {
      currentFood = null;
      state = WELCOME;
      
      input.addPanel(input.loginPanel());
      input.setPanel("next");
      
      currentCart = new Cart();                 // move these to start of orderMenu() bc employee and manager dont need cart or ticket?
      currentTicket = new Ticket(currentCart, currentOrder, currentTicketNumber);      
      
   }

   /**
      Asks the user for their username and password, and checks to make sure it is valid.
      @param key: The user's input.
   */
   private void welcomeMenu(String key)   //need to differentiate between users from xml storage file
   {                                //incomplete
    
      String user = input.getUsername();
      String pass = input.getPassword();
       
      Constants.DATABASE.initializeData();
      if (key.equals("1")) {
        if (user.equals("Customer")){
           if (Constants.DATABASE.passCheck(pass, "customer")) //currentTicket.checkPasscode(accumulatedKeys)
           {
              userType = 0;
              state = CREDENTIALS_MENU;
              input.addPanel(input.credentialsPanel(true));
              input.setPanel("next");

           }
           else {
              userType = 3;
              state = CREDENTIALS_MENU;
              input.addPanel(input.credentialsPanel(false));
              input.setPanel("next");
           }
        }

        else if (user.equals("Employee")){
           if (Constants.DATABASE.passCheck(pass, "employee"))
           {
              userType = 1;
              state = CREDENTIALS_MENU;
              input.addPanel(input.credentialsPanel(true));
              input.setPanel("next");
           }
           else {
              userType = 3;
              state = CREDENTIALS_MENU;
              input.addPanel(input.credentialsPanel(false));
              input.setPanel("next");
           }
        }

        else if (user == "Manager"){
           if (Constants.DATABASE.passCheck(pass, "manager"))
           {
              userType = 2;
              state = CREDENTIALS_MENU;
              input.addPanel(input.credentialsPanel(true));
              input.setPanel("next");
           }
           else {
              userType = 3;
              state = CREDENTIALS_MENU;
              input.addPanel(input.credentialsPanel(false));
              input.setPanel("next");
           }
        }

        else {
            userType = 3;
            state = CREDENTIALS_MENU;
            input.addPanel(input.credentialsPanel(false));
            input.setPanel("next"); 
        }
      }
   }

   /**
      Determines the user's type, based on the information they entered.
      @param key: The user's input.
   */   
   private void credentialsMenu(String key) {
       if (key.equals("1")) {
           if (userType == 0){
                state = ORDER_MENU;
                input.addPanel(input.orderPanel());
                input.setPanel("next");
           }
           else if (userType == 1){ // need to read newest order to determine which menu to go into
               state = PROCESSING_MENU;
                input.addPanel(input.employeePanel(true));
                input.setPanel("next");
           }
           else if (userType == 2){
               state = MANAGER_MENU;
                input.addPanel(input.managerPanel());
                input.setPanel("next");
           }
           if (userType == 3){
               throw new java.lang.RuntimeException("Invalid User Type.");
           }
       }
       else if (key.equals("2")) {
           resetConnection();
       }
   }
   /**
      The menu that lets the user determine what food they want.
      @param key: The user's input.
   */
   private void orderMenu(String key) //need to fill with order options (sandwich, etc.)
   {
      if (key.equals("1")) //Pick sandwich
      {
          Sandwich s = null; 
          currentFood = s;
          input.addPanel(input.itemSpecificsPanel(1));
          input.setPanel("next");  //pick if you want a hot or cold sandwich  
          state = ORDER_OPT_MENU;
      }
      else if (key.equals("2")) //Pick soup
      {
          Soup sp = null; 
          currentFood = sp;
          input.addPanel(input.itemSpecificsPanel(2));
          input.setPanel("next");  //pick if you want a hot or cold sandwich          
          state = ORDER_OPT_MENU;
      }
      else if (key.equals("3"))
      {
          MacNCheese mc = null; 
          currentFood = mc;
          input.addPanel(input.itemSpecificsPanel(2));
          input.setPanel("next");  //pick if you want a hot or cold sandwich          
          state = ORDER_OPT_MENU;
      }
      else if (key.equals("4")) //Pick salad
      {
          Salad sa = null; 
          currentFood = sa;
          input.addPanel(input.itemSpecificsPanel(2));
          input.setPanel("next");  //pick if you want a hot or cold sandwich          
          state = ORDER_OPT_MENU;
      }
      
      else if (key.equals("5")) //Pick grainbowl
      {
          GrainBowl g = null; 
          currentFood = g;
          
          currentCart.add(currentFood);
      }
      
      else if (key.equals("6")) //clear cart
      {
          currentCart.clear();
      }
      
      else if (key.equals("7")) //Finish Order
      {
          state = DELIVERY_MENU;
          input.addPanel(input.deliveryOptionsPanel());
          input.setPanel("next");
      }
      else
      {
          throw new java.lang.RuntimeException("Wrong button press.");
      }
    }

   /**
      Lets the user determine the size and kind for each food item.
      @param key: The user's input.
   */
   private void orderOptMenu(String key) 
   {
      if (currentFood.getType() == 1)   //Sandwich        
      {
        if (key.equals("1")) 
        {
            currentFood.setSize(0); //small
            currentFood.setKind(0); //cold
        }
        
        else if (key.equals("2"))
        {
            currentFood.setSize(0); //small
            currentFood.setKind(1); //hot              
        }
        
        else if (key.equals("3"))
        {
            currentFood.setSize(1); //large
            currentFood.setKind(0); //cold              
        }
        
        else if (key.equals("4"))
        {
            currentFood.setSize(1); //large
            currentFood.setKind(1); //hot              
        }
        
        else
            throw new java.lang.RuntimeException("Wrong button press.");
        
        currentCart.add(currentFood);
        state = ORDER_MENU;
      }
      
      else if (currentFood.getType() == 2 || currentFood.getType() == 3 || currentFood.getType() == 4)   //Soup, Mac, or Salad        
      {
        if (key.equals("1")) 
        {
            currentFood.setSize(0); //small
        }
        
        else if (key.equals("2"))
        {
            currentFood.setSize(1); //large          
        }
        
        else
            throw new java.lang.RuntimeException("Wrong button press.");
        
        currentCart.add(currentFood);
        state = ORDER_MENU;
      }
      
      else
        throw new java.lang.RuntimeException("Food type is not found."); 
    }
   
   /**
      Allows the user to determine if their oder will be delivered, picked up, etc.
      @param key: The user's input.
   */
    private void deliveryMenu(String key)       //do we need a new menu for enetring the delivery address? or do we just add it into this menu
    {
        input.addPanel(input.deliveryOptionsPanel());

        if (key.equals("1")) //Delivery
        {         
            Delivery d = null; 
            currentOrder = d;
                     
            if (key.equals("1")) //Submit 
            {
                state = PAYMENT_MENU;
                String address = input.getAddress();
                currentTicket.setAddress(address);
                
                input.addPanel(input.paymentPanel());
                input.setPanel("next");
            }
            else 
            {
                throw new java.lang.RuntimeException("Wrong button press."); 
            }
      }
      
      else if (key.equals("2")) //Pickup
      {
          Pickup p = null; 
          currentOrder = p; 
          state = PAYMENT_MENU;
          input.addPanel(input.paymentPanel());
          input.setPanel("next");
      }
      
      else
         throw new java.lang.RuntimeException("Wrong button press.");
    }

   /**
      Lets the user enter their payment information.
      @param key: The user's input.
   */ 
    private void paymentMenu(String key)        //need to collect data from user
    {
        Payment p = new Payment();       
        ArrayList<Object>info = input.getPaymentInfo();
        PaymentInfo pi = new PaymentInfo((long)info.get(0), (int)info.get(1), (int)info.get(2), (int)info.get(3));
        
        if (p.checkInfo(pi) == true)
        {
            state = LOGOUT_MENU;
            input.addPanel(input.orderStatusPanel(true));
            input.setPanel("next");
        }
        
        else if (p.checkInfo(pi) == false)
        {
            state = LOGOUT_MENU;
            input.addPanel(input.orderStatusPanel(false));
            input.setPanel("next");
        }
        
        else 
        {
         throw new java.lang.RuntimeException("I don't know how you even managed to get this error.");
        }
    }

   /**
      Submits the user's order information.
      @param key: The user's input.
   */
    private void submitMenu(String key)
    {
        //need to display Ticket panel until submit key is pushed, move this to payment Menu after completed
        
        if (key.equals("1")) //Submit button pressed
        {         
            state = LOGOUT_MENU;
            input.addPanel(input.logoutPanel()); 
            input.setPanel("next");
        }

        else
            throw new java.lang.RuntimeException("Wrong button press.");
        
    }

   /**
      Asks for the user to process an order (meant to be used by employees).
      @param key: The user's input.
   */
    private void processMenu(String key)
    {
        currentTicket = orderq.get();        //takes first ticket in queue
        
        //Make seperate panel that shows ticket so we can see status change accordingly?
        
        if (currentTicket.getOType().getType().equals("Delivery"))       //Delivery
        {         
            input.addPanel(input.employeePanel(true));      //ask if food is done and being delivered
            input.setPanel("next");
            
            if (key.equals("1"))    //yes
            {
                currentTicket.changeStatus(2);
                
                try {                           //Pauses for 5 seconds
                    // pause for 5 seconds
                    TimeUnit.SECONDS.sleep(5);
                }
                
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                currentTicket.changeStatus(3);
                state = LOGOUT_MENU;
            }
            
            else
            {
                throw new java.lang.RuntimeException("Wrong button press.");
            }
        }

        else if (currentTicket.getOType().getType().equals("Pickup"))       //Pickup
        {         
            input.addPanel(input.employeePanel(false));  //ask if food is ready for pickup
            input.setPanel("next");
            
            if (key.equals("1"))
            {
                currentTicket.changeStatus(4);
                state = LOGOUT_MENU;
            }
                        
            else
            {
                throw new java.lang.RuntimeException("Wrong button press.");
            }
        }
        
        else
        {
            throw new java.lang.RuntimeException("Not delivery or takeout type.");   
        }
    }

   /**
      The manager's menu, allowing them to access both customer and employee view.
      @param key: The user's input.
   */ 
    private void managerMenu(String key)
    {
        if (key.equals("1")) //Exit
        {
            state = LOGOUT_MENU;
            input.addPanel(input.logoutPanel()); 
            input.setPanel("next");
        }
        
        else
            throw new java.lang.RuntimeException("Wrong button press.");
    }
    
   /**
      Lets the user log out, and resets the connection.
      @param key: The user's input.
   */
    private void logoutMenu(String key)
    {
        if (key.equals("1"))
        {
            if (userType == 0){
                orderq.add(currentTicket);      //Adds current ticket to orderqueue
                currentTicketNumber++;
                resetConnection();
            }
            else {
                   //Adds current ticket to orderqueue
               resetConnection();     
            }
            
        }
        
        else
            throw new java.lang.RuntimeException("Logout error.");

    }
   
   // PRIVATE VARIABLES
   private OrderQueue orderq; // The order queue, containing all of the tickets
   private Ticket currentTicket; // The current ticket being worked on
   private Cart currentCart; // The current cart, containing all of the food items
   private Food currentFood; // The current food, and any changes made to it
   private OType currentOrder; // The current order type, for checking out
   private Interface input; // The user's input to the Interface
   private int state; // The state the class is currently in
   private int userType; // Determines if the user is a Customer, Employee, or Manager
   private int currentTicketNumber = 1; // Starts with 1, as it serves as the first ticket

   // STATE
   private static final int DISCONNECTED = 0; // No connection
   private static final int WELCOME = 1; // On the Welcome menu
   private static final int ORDER_MENU = 2; // On the Order menu
   private static final int ORDER_OPT_MENU = 3; // On the Order Options menu
   private static final int DELIVERY_MENU = 4; // On the Delivery menu
   private static final int PAYMENT_MENU = 5; // On the Payment menu
   private static final int SUBMIT_MENU = 6; // On the Submit Order menu
   private static final int PROCESSING_MENU = 7; // On the Order Processing menu
   private static final int LOGOUT_MENU = 8; // On the Logout menu
   private static final int MANAGER_MENU = 9; // On the Manager View menu
   private static final int CREDENTIALS_MENU = 10; // On the Login menu
} // END OF FILE
