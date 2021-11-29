/*
 * test
To change this license header, choose License Headers in Project Properties.
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
      else if (state == ORDER_MENU)
         orderMenu(key);
//      else if (state == ORDER_OPT_MENU)
//         orderOptMenu(key);
      else if (state == DELIVERY_MENU)
         deliveryMenu(key);
//      else if (state == PAYMENT_MENU)
//         paymentMenu(key);
      else if (state == SUBMIT_MENU)
         submitMenu(key);
      else if (state == PROCESSING_MENU)
         processMenu(key);
      else if (state == DONE_MENU)
         doneMenu(key);
   }

   public void enterInfo(long ccnum, int cvc, int exp, int zip)
   {
       paymentMenu(ccnum, cvc, exp, zip);
   }
   
   /**
      Reset the connection to the initial state and prompt
      for login
   */
   private void resetConnection()
   {
      currentFood = null;
      accumulatedKeys = "";
      state = WELCOME;
      input.speak(WELCOME_TEXT);
      currentCart = new Cart();
      currentTicket = new Ticket(currentCart, currentOrder);      
      
   }

      /**
      Record user input.
      @param voice input typed by the user
   */
   public void record(String input)
   {
      if (state == PAYMENT_MENU || state == DELIVERY_MENU) 
      {
          currentRecording += input;
      }
   }
   
   /**
      Try to log in the user.
      @param key the phone key pressed by the user
   */
   private void welcomeMenu(String key)   //need to differentiate between users from xml storage file
   {                                //incomplete
    
      Constants.DATABASE.initializeData();
               
      if (key.equals("Customer"))
      {
         if (currentTicket.checkPasscode(accumulatedKeys))
         {
            state = ORDER_MENU;
            input.speak(ORDER_MENU_TEXT);
         }
         else
            input.speak("Incorrect passcode. Try again!");
         
         accumulatedKeys = "";
      }
      
      else if (key.equals("Employee"))
      {
          if (currentTicket.checkPasscode(accumulatedKeys))
         {
            state = PROCESSING_MENU;
            input.speak(PROCESSING_MENU_TEXT);
         }
         else
            input.speak("Incorrect passcode. Try again!");
         
         accumulatedKeys = "";
      }
      
      else if (key.equals("Manager"))
      {
          //Manager should be able to see all tickets, does that mean we make new "manager menu"?
      }
      
      else
          input.speak("Please enter a valid username.");
   }

   /**
      Respond to the user's selection from message menu.
      @param key the interface key pressed by the user 
   */
   private void orderMenu(String key) //need to fill with order options (sandwich, etc.)
   {
       
      if (key.equals("1")) //Pick sandwich
      {
          Sandwich s = null; 
          currentFood = s;
          input.speak(SANDWICH_MENU_TEXT);  //pick if you want a hot or cold sandwich          
          if (key.equals("1"))
          {
              s.setSize("HOT");              //need to pick hot here 
          }
          else if (key.equals("2"))
          {
              s.setSize("COLD");              //need to pick cold here
          }
          
          currentCart.add(currentFood);
      }
      else if (key.equals("2")) //Pick soup
      {
          Soup sp = null; 
          currentFood = sp;
          input.speak(SOUP_MENU_TEXT);  //pick if you want a hot or cold sandwich          
          if (key.equals("1"))
          {
              sp.setSize("LARGE");              //need to pick large here
          }
          else if (key.equals("2"))
          {
              sp.setSize("SMALL");              //need to pick small here
          }
          
          currentCart.add(currentFood);
      }
      else if (key.equals("3"))
      {
          MacNCheese mc = null; 
          currentFood = mc;
          input.speak(MAC_MENU_TEXT);  //pick if you want a hot or cold sandwich          
          if (key.equals("1"))
          {
              mc.setSize("LARGE");              //need to pick large here
          }
          else if (key.equals("2"))
          {
              mc.setSize("SMALL");              //need to pick small here
          }
          
          currentCart.add(currentFood);
      }
      else if (key.equals("4")) //Pick salad
      {
          Salad sa = null; 
          currentFood = sa;
          input.speak(SALAD_MENU_TEXT);  //pick if you want a hot or cold sandwich          
          if (key.equals("1"))
          {
              sa.setSize("HALF");              //need to pick half here
          }
          else if (key.equals("2"))
          {
              sa.setSize("WHOLE");              //need to pick whole here
          }
          
          currentCart.add(currentFood);
      }
      
      else if (key.equals("5")) //Pick grainbowl
      {
          GrainBowl g = null; 
          currentFood = g;
          
          currentCart.add(currentFood);
      }
      
      else if (key.equals("6")) //Delete item
      {
          currentCart.remove();
      }
      
      else if (key.equals("7")) //Finish Order
      {
          state = DELIVERY_MENU;
          input.speak(DELIVERY_MENU_TEXT);
      }
      else
      {
          input.speak("Please enter a valid option");
      }
    }

   /**
      Respond to the user's selection from message menu.
      @param key the interface key pressed by the user 
   */
   
   /**
   private void orderOptMenu(String key) //PROBABLY WONT NEED
   {
      if (currentFood.getType("Sandwich"))        
      {
                     
      }
      else if (currentFood.getType("Soup"))
      {
         
      }
      else if (currentFood.getType("MacNCheese"))
      {
         
      }
      else if (currentFood.getType("Salad"))
      {
         
      }
      else if (currentFood.getType("GrainBowl"))
      {
         
      }
      
      else
      {
          
      }
    }
   */
   
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
          input.speak(DELIVERY_OPT_MENU_TEXT);  //enter address         
          if (key.equals("1"))
          {
                            //need to take address here 
              state = PAYMENT_MENU;
              input.speak(PAYMENT_MENU_TEXT);
          }
          else 
          {
              input.speak("Enter a valid address.");
          }
      }
      
      else if (key.equals("2")) //Pickup
      {
          Pickup p = null; 
          currentOrder = p; //Do we need to do anything else for pickup?
          state = PAYMENT_MENU;
          input.speak(PAYMENT_MENU_TEXT);
      }
      
      else
         input.speak("Enter a valid option.");
    }

    /**
      Payment Menu.
      @param key phone key pressed by the user
   */   
    private void paymentMenu(long ccnum, int cvc, int exp, int zip)        //need to collect data from user
    {
        Payment p = new Payment();        
        PaymentInfo pi = new PaymentInfo(ccnum, cvc, exp, zip);
        
        if (p.checkInfo(pi) == true)
        {
            state = SUBMIT_MENU;
            input.speak(SUBMIT_MENU_TEXT);
        }
        
        else if (p.checkInfo(pi) == false)
        {
            input.speak("Input valid information.");
        }
        
        else 
        {
            input.speak("Error with payment info check.");
        }
    }

    /**
      Delivery Menu.
      @param key phone key pressed by the user
   */   
    private void submitMenu(String key)
    {
        
        currentTicket.displayTicket();
        
        if (key.equals("1")) //Submit button pressed
        {         
            state = DONE_MENU;
            input.speak(DONE_MENU_TEXT);
        }

        else
        {
            input.speak("Invalid input.");
        }
    }

    /**
      Process Menu.
      @param key phone key pressed by the user
   */   
    private void processMenu(String key)
    {
      if (key.equals("1"))
      {         
          //need to work on this
      }

      else
      {
          
      }
    }

    /**
      Last Menu.
      @param key phone key pressed by the user
   */   
    private void doneMenu(String key)
    {
        
        currentTicket.displayTicket();
        
        if (key.equals("1")) //Close button?
        {         
            resetConnection();
        }

        else
        {
            input.speak("Enter a valid option.");
        }
        
    }
    
   private OrderQueue orderq;
   private Ticket currentTicket;
   private Cart currentCart;
   private Food currentFood;
   private OType currentOrder;
   private String accumulatedKeys;
   private Interface input;
   private String currentRecording;
   private int state;

   private static final int DISCONNECTED = 0;
   private static final int WELCOME = 1;
   private static final int ORDER_MENU = 2;
   private static final int ORDER_OPT_MENU = 3;
   private static final int DELIVERY_MENU = 4;
   private static final int PAYMENT_MENU = 5;
   private static final int SUBMIT_MENU = 6;
   private static final int PROCESSING_MENU = 7;
   private static final int DONE_MENU = 8;
   
   private static final String WELCOME_TEXT = 
         "Enter your login info."; 
   
   private static final String ORDER_MENU_TEXT = 
         "Enter 1 to listen to your messages\n"
         + "Enter 2 to change your passcode\n"
         + "Enter 3 to change your greeting";
   
   private static final String SANDWICH_MENU_TEXT = 
         "Select if you want a hot or cold sandwich.";
   
   private static final String SOUP_MENU_TEXT = 
         "Select if you want a large or small soup.";

   private static final String MAC_MENU_TEXT = 
         "Select if you want a large or small mac and cheese.";

   private static final String SALAD_MENU_TEXT = 
         "Select if you want a large or small salad.";
   
   private static final String DELIVERY_MENU_TEXT = 
         "Enter 1 for Delivery\n"
         + "Enter 2 for Pickup";

   private static final String DELIVERY_OPT_MENU_TEXT = 
         "Enter the address for delivery.";   
   
   private static final String PAYMENT_MENU_TEXT = 
         "Enter your credit card number, cvc, expiration date, and zip code";
   
   private static final String SUBMIT_MENU_TEXT = 
         "Please review and submit your order.";
   
   private static final String PROCESSING_MENU_TEXT =
         "Is the food done?";
   
   private static final String DONE_MENU_TEXT =
         "Order Complete.";
   
}