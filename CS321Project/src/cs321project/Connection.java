/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321project;

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
   public Connection(OrderQueue o, Input i)
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
      if (state == CONNECTED)
         connect(key);
      else if (state == WELCOME)
         welcomeMenu(key);
      else if (state == ORDER_MENU)
         orderMenu(key);
      else if (state == DELIVERY_MENU)
         deliveryMenu(key);
      else if (state == PAYMENT_MENU)
         paymentMenu(key);
      else if (state == SUBMIT_MENU)
         submitMenu(key);
   }

   /**
      Record voice.
      @param voice voice spoken by the user
   */
   public void record(String voice)
   {
         currentRecording += voice;
   }

   /**
      The user hangs up the phone.
   */
   public void hangup()           //not sure what this will become (maybe finish order?)  
   {
      if (state == RECORDING)
         currentMailbox.addMessage(new Message(currentRecording));
      resetConnection();
   }

   /**
      Reset the connection to the initial state and prompt
      for login
   */
   private void resetConnection()
   {
      currentRecording = "";
      accumulatedKeys = "";
      state = CONNECTED;
      input.speak(INITIAL_PROMPT);
   }

   /**
      Try to connect the user with the specified mailbox.
      @param key the phone key pressed by the user
   */
   private void connect(String key)
   {
      if (key.equals("S"))
      {         
          currentMailbox = system.findMailbox(accumulatedKeys);  
         if (currentMailbox != null)
         {
            state = RECORDING;
            phone.speak(currentMailbox.getGreeting());
         }
         else
            phone.speak("Incorrect mailbox number. Try again!");
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
        
   }

   /**
      Try to log in the user.
      @param key the phone key pressed by the user
   */
   private void welcomeMenu(String key)   //need to differentiate between users from xml storage file
   {                                //incomplete
      if (key.equals("Customer"))
      {
         if (currentCart.checkPasscode(accumulatedKeys))
         {
            state = MAILBOX_MENU;
            input.speak(MAILBOX_MENU_TEXT);
         }
         else
            input.speak("Incorrect passcode. Try again!");
         accumulatedKeys = "";
      }
      
      else if (key.equals("Employee"))
      {
          
      }
      
      else if (key.equals("Employee"))
      {
          
      }
      
      else
         accumulatedKeys += key;
   }
   
   /**
      Change pass code.
      @param key the phone key pressed by the user
   */
   private void changePasscode(String key) //maybe keep this?
   {
      if (key.equals("#"))
      {
         currentCart.setPasscode(accumulatedKeys);
         state = WELCOME;
         input.speak(WELCOME_TEXT);
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   }

   /**
      Respond to the user's selection from message menu.
      @param key the interface key pressed by the user 
   */
   private void orderMenu(String key) //need to fill with order options (sandwich, etc.)
   {
      if (key.equals("1"))
      {
         
      }
      else if (key.equals("2"))
      {
         
      }
      else if (key.equals("3"))
      {
         
      }
      else if (key.equals("4"))
      {
         
      }
      else if (key.equals("5"))
      {
         
      }
      
      else
      {
          
      }
    }
   
    /**
      Delivery Menu.
      @param key phone key pressed by the user
   */   
    private void deliveryMenu(String key)
    {
      if (key.equals("1"))
      {         
         
      }
      
      else if (key.equals("2"))
      {
          
      }
      
      else
         accumulatedKeys += key;
    }

    /**
      Delivery Menu.
      @param key phone key pressed by the user
   */   
    private void paymentMenu(String key)
    {
      if (key.equals("1"))
      {         
         
      }
      
      else if (key.equals("2"))
      {
          
      }
      
      else
         accumulatedKeys += key;
    }

    /**
      Delivery Menu.
      @param key phone key pressed by the user
   */   
    private void submitMenu(String key)
    {
      if (key.equals("1"))
      {         
         
      }

      else
         accumulatedKeys += key;
    }
    
   private OrderQueue orderq;
   private Cart currentCart;
   private String currentRecording;
   private String accumulatedKeys;
   private Input input;
   private int state;

   private static final int DISCONNECTED = 0;
   private static final int CONNECTED = 1;
   private static final int WELCOME = 2;
   private static final int ORDER_MENU = 3;
   private static final int DELIVERY_MENU = 4;
   private static final int PAYMENT_MENU = 5;
   private static final int SUBMIT_MENU = 6;
              
   private static final String INITIAL_PROMPT = 
         "Enter your login info.";      
   private static final String ORDER_MENU_TEXT = 
         "Enter 1 to listen to your messages\n"
         + "Enter 2 to change your passcode\n"
         + "Enter 3 to change your greeting";
   private static final String DELIVERY_MENU_TEXT = 
         "Enter 1 for Delivery\n"
         + "Enter 2 for Pickup";
   private static final String PAYMENT_MENU_TEXT = 
         "Enter your credit card number, cvc, expiration date, and zip code";
   private static final String SUBMIT_MENU_TEXT = 
         "Please review and submit your order.";
}