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
   Connects a phone to the mail system. The purpose of this
   class is to keep track of the state of a connection, since
   the phone itself is just a source of individual key presses.
*/
public class Connection
{
   /**
      Construct a Connection object.
      @param o a OrderQueue object
      @param i a Input object
   */
   public Connection(OrderQueue o, Interface i)
   {
      orderq = o;
      input = i;
      resetConnection();
   }

   /**
      Respond to the user's pressing a key on the phone touch pad
      @param key the phone key pressed by the user
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
      Reset the connection to the initial state and prompt
      for login
   */
   private void resetConnection()
   {
      currentFood = null;
      state = WELCOME;
      
      input.addPanel(input.loginPanel());
      input.setPanel("next");
      
      currentCart = new Cart();          // move these to start of orderMenu() bc employee and manager dont need cart or ticket?
      currentTicket = new Ticket(currentCart, currentOrder, currentTicketNumber);      
      
   }

   /**
      Try to log in the user.
      @param key the phone key pressed by the user
   */
   private void welcomeMenu(String key)   //need to differentiate between users from xml storage file
   {                                //incomplete
    
      String user = input.getUsername();
      String pass = input.getPassword();
       
      Constants.DATABASE.initializeData();
      if (key.equals("1")) {
        if (user.equals("Customer")){
           if (pass.equals("password")) //currentTicket.checkPasscode(accumulatedKeys)
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
           if (pass.equals("password"))
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
           if (pass.equals("password"))
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
           else
               resetConnection();
       }
       else if (key.equals("2")) {
           resetConnection();
       }
   }

   /**
      Respond to the user's selection from message menu.
      @param key the interface key pressed by the user 
   */
   private void orderMenu(String key) //need to fill with order options (sandwich, etc.)
   {
      if (key.equals("1")) //Pick sandwich
      {
          Sandwich s = new Sandwich(); 
          currentFood = s;
          state = ORDER_OPT_MENU;
          input.addPanel(input.itemSpecificsPanel(1));
          input.setPanel("next");  //pick if you want a hot or cold sandwich 
      }
      else if (key.equals("2")) //Pick soup
      {
          Soup sp = new Soup(); 
          currentFood = sp;
          state = ORDER_OPT_MENU;
          input.addPanel(input.itemSpecificsPanel(2));
          input.setPanel("next");  //pick if you want a hot or cold sandwich          
      }
      else if (key.equals("3"))
      {
          MacNCheese mc = new MacNCheese(); 
          currentFood = mc;
          state = ORDER_OPT_MENU;
          input.addPanel(input.itemSpecificsPanel(3));
          input.setPanel("next");  //pick if you want a hot or cold sandwich          
      }
      else if (key.equals("4")) //Pick salad
      {
          Salad sa = new Salad(); 
          currentFood = sa;
          state = ORDER_OPT_MENU;
          input.addPanel(input.itemSpecificsPanel(4));
          input.setPanel("next");  //pick if you want a hot or cold sandwich          
      }
      
      else if (key.equals("5")) //Pick grainbowl
      {
          GrainBowl g = new GrainBowl(); 
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
          throw new java.lang.RuntimeException("Wrong Button Press.");
      }
    }

   /**
      Menu with options for each food choice.
      @param key the interface key chosen by the user 
   */
   
   
   private void orderOptMenu(String key) 
   {
      if (currentFood.getType() == 0)   //Sandwich        
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
        input.addPanel(input.orderPanel());
        input.setPanel("next");
        
      }
      
      else if (currentFood.getType() == 1 || currentFood.getType() == 2 || currentFood.getType() == 3)   //Soup, Mac, or Salad        
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
            throw new java.lang.RuntimeException("Wrong Button press.");
        
        currentCart.add(currentFood);
        state = ORDER_MENU;
        input.addPanel(input.orderPanel());
        input.setPanel("next");
      }
      
      else
        throw new java.lang.RuntimeException("Food type is not found."); 
    }
   
    /**
      Delivery Menu.
      @param key phone key pressed by the user
   */   
    private void deliveryMenu(String key)
    {      
      if (key.equals("1")) //Delivery
      {         
          Delivery d = null; 
          currentOrder = d;
            //enter address         
          if (key.equals("1"))
          {
                            //need to take address here 
              state = PAYMENT_MENU;
              input.addPanel(input.paymentPanel());
              input.setPanel("next");
          }
          else 
          {
              throw new java.lang.RuntimeException("I don't know how you even managed to get this error."); 
          }
      }
      
      else if (key.equals("2")) //Pickup
      {
          Pickup p = null; 
          currentOrder = p; //Do we need to do anything else for pickup?
          state = PAYMENT_MENU;
          input.addPanel(input.paymentPanel());
          input.setPanel("next");
      }
      
      else
         throw new java.lang.RuntimeException("Wrong button press.");
    }

    /**
      Payment Menu.
      @param key phone key pressed by the user
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
      Delivery Menu.
      @param key phone key pressed by the user
   */   
    private void submitMenu(String key)
    {
        if (key.equals("1")) //Submit button pressed
        {         
            state = LOGOUT_MENU;
            input.addPanel(input.logoutPanel()); 
            input.setPanel("next");
        }

        else
        {
            throw new java.lang.RuntimeException("I don't know how you even managed to get this error.");
        }
    }

    /**
      Process Menu.
      @param key phone key pressed by the user
   */   
    private void processMenu(String key)
    {
        currentTicket = orderq.remove();        //takes first ticket in queue
        
        //Make seperate panel that shows ticket so we can see status change accordingly?
        
        if (currentTicket.getOType().getType().equals("Delivery"))       //Delivery
        {         
            input.addPanel(input.employeePanel(true));      //ask if food is done and being delivered
            input.setPanel("next");
            
            if (key.equals("1"))    //yes
            {
                currentTicket.changeStatus(2);
                //wait 5 seconds to signify delivery time
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
      Last Menu.
      @param key phone key pressed by the user
   */   
    /**
      Manager Menu.
      @param key interface key pressed by the user
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
      Last Menu.
      @param key interface key pressed by the user
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
    
   public int getOrderNumber() {
       return currentTicketNumber;
   }
    
   private OrderQueue orderq;
   private Ticket currentTicket;
   private Cart currentCart;
   private Food currentFood;
   private OType currentOrder;
   private Interface input;
   private int state;
   private int userType;
   private int currentTicketNumber=1;

   private static final int DISCONNECTED = 0;
   private static final int WELCOME = 1;
   private static final int ORDER_MENU = 2;
   private static final int ORDER_OPT_MENU = 3;
   private static final int DELIVERY_MENU = 4;
   private static final int PAYMENT_MENU = 5;
   private static final int SUBMIT_MENU = 6;
   private static final int PROCESSING_MENU = 7;
   private static final int LOGOUT_MENU = 8;
   private static final int MANAGER_MENU = 9;
   private static final int CREDENTIALS_MENU = 10;
}