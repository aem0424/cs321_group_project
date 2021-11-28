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

 This class reads through the .xml file used for storing the food data in order
 to use it for various purposes.
*/

public class Parser extends DefaultHandler {
   boolean smallPrice = false;
   boolean largePrice = false;

   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

      // GET THE TOTALS FOR EACH TYPE (note: this is not quite complete at the moment)
      if (qName.equalsIgnoreCase("total")) {
          String totalM = attributes.getValue("totalManagers");
          String totalE = attributes.getValue("totalEmployees");
          String totalC = attributes.getValue("totalCustomers");
          Constants.TOTAL_MANAGERS = Integer.parseInt(totalM);
          Constants.TOTAL_EMPLOYEES = Integer.parseInt(totalE);
          Constants.TOTAL_CUSTOMERS = Integer.parseInt(totalC);
      }
      
      // FIND AND GET USER DATA
      if (qName.equalsIgnoreCase("user")) {
          String role = attributes.getValue("role"); // Gets the user's role
          String user = attributes.getValue("username"); // Gets their username
          String pass = attributes.getValue("password"); // Gets their password
          switch(role) {
              case("Manager"):
              Constants.DATABASE.admins[adminTracker][0] = user;
              Constants.DATABASE.admins[adminTracker][1] = pass;
              adminTracker++;
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
         foodTracker++;
      }
      else if (qName.equalsIgnoreCase("small")) { 
         smallPrice = true;
      }
      else if (qName.equalsIgnoreCase("large")) {
         largePrice = true;
      }
      else if (qName.equalsIgnoreCase("\\type")) {
         foodTracker--;
      }
   }

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
   private int  adminTracker = 0; // Used to track how many admins have been stored
   private int staffTracker = 0; // Same as above, but for staff members
   private int customerTracker = 0; // Same as bove two, but for customers
} // END OF FILE