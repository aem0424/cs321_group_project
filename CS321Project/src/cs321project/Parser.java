package cs321project;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Parser.java
 Dr. Huaming Zhang
 CS 321-03
 November 26, 2021
 This class reads through the .XML file used for storing the food data in order
 to use it for various purposes.
  
 @author anthony_matthews
*/

public class Parser extends DefaultHandler {
   boolean smallPrice = false; // Set to truw when the parser finds the price for a small-sized item
   boolean largePrice = false; // Set to true when the parser finds the price for a large-sized item

    /**
      Parses the file, performing operations if certain strings are found in the file.
      @param uri: The filename of the file to be parsed.
      @param localName: (Unused) A deprecated(?) argument, included for compatibility.
      @param qName: The current string the parser is at in the .XML file.
      @param attributes: The data found after an equals sign in the .XML file.
      @throws SAXException: An error of some kind has happened during data parsing.
    */   
   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

      // GET THE TOTALS FOR EACH TYPE (note: this is not quite complete at the moment)
      // If I can't implement this successfully, I can just assign a value of like 9 or something to the TOTAL_[MEMBER} variables instead
/*      if (qName.equalsIgnoreCase("total")) {
          String totalM = attributes.getValue("totalManagers");
          String totalE = attributes.getValue("totalEmployees");
          String totalC = attributes.getValue("totalCustomers");
          // CONVERT THE FOUND STRINGS INTO INTS, AND ASSIGN THEM TO THE TOTAL CONSTANTS
          Constants.TOTAL_MANAGERS = Integer.parseInt(totalM);
          Constants.TOTAL_EMPLOYEES = Integer.parseInt(totalE);
          Constants.TOTAL_CUSTOMERS = Integer.parseInt(totalC);
      } */
      
      // FIND AND GET USER DATA
      if (qName.equalsIgnoreCase("user")) {
          String role = attributes.getValue("role"); // Gets the user's role
          String user = attributes.getValue("username"); // Gets their username
          String pass = attributes.getValue("password"); // Gets their password
          switch(role) { // Set username and password based on the role found
              case("Manager"):
              Constants.DATABASE.admins[adminTracker][0] = user;
              Constants.DATABASE.admins[adminTracker][1] = pass;
              adminTracker++; // Increment by 1 until data equal to the total amount of data is filled
              break;
          case("Employee"):
              Constants.DATABASE.staff[staffTracker][0] = user;
              Constants.DATABASE.staff[staffTracker][1] = pass;     
              staffTracker++;
              break;
          case("Customer"):
              Constants.DATABASE.customers[customerTracker][0] = user;
              Constants.DATABASE.customers[customerTracker][1] = pass;    
              customerTracker++;
              break;
          }
      }
      
      // FIND AND GET FOOD DATA
      if (qName.equalsIgnoreCase("type")) {
         foodTracker++; // Indicates what type of food the parser is on
      }
      else if (qName.equalsIgnoreCase("small")) { 
         smallPrice = true; // When true, set a price for a small item to the current food type
      }
      else if (qName.equalsIgnoreCase("large")) {
         largePrice = true; // Same as the small case, but for a large-size item
      }
      else if (qName.equalsIgnoreCase("\\type")) {
         foodTracker--; // Can cause an overflow if not present
      }
   }

    /**
      Gets the current string, and sets data to the price array if the smallPrice or largePrice
      Boolean values are true.
      @param ch[]: An array containing the data as characters (functionally the same as a String).
      @param start: The location of the first character in the string
      @param length: The length of the entire string.
      @throws SAXException: An error of some kind has happened during data parsing.
    */     
   @Override
   public void characters(char ch[], int start, int length) throws SAXException {
      String temp = new String(ch, start, length);
      if (smallPrice) {
         Constants.DATABASE.prices[foodTracker - 1][0] = Float.parseFloat(temp);
         smallPrice = false;
      }
      else if (largePrice) {
         Constants.DATABASE.prices[foodTracker - 1][1] = Float.parseFloat(temp);
         largePrice = false;
      }
   }
   
   // PRIVATE VARIABLES
   private int foodTracker = 0; // Used to track which food item the parser is currently on
   private int adminTracker = 0; // Used to track how many admins have been stored
   private int staffTracker = 0; // Same as above, but for staff members
   private int customerTracker = 0; // Same as bove two, but for customers
} // END OF FILE