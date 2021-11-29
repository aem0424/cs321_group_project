package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Database.java
 Dr. Huaming Zhang
 CS 321-03
 November 27, 2021

 This class contains finds and stores all of the possible prices for each food
 item so they can be referenced later.
  
 @author anthony_matthews
*/
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;

public class Database {
    /**
      Initialize the database information by loading the file and parsing it.
    */    
    void initializeData() {
         try {
         SAXParser sax = Constants.SAX_FACTORY.newSAXParser();
         Parser dataParser = new Parser();
         sax.parse(Constants.FOOD_DATA, dataParser);
         }  catch (IOException | ParserConfigurationException | SAXException FileNotFoundException) {
         System.out.println("An error has occured. Please check " + Constants.FOOD_DATA + " and make sure it is valid.");
         }
    }
    
    /**
      Gets the price for a food of a certain type and size, with data obtained from the parser.
      @param foodType: What kind of food to get the price for (sandwich, grain bowl, etc).
      @param foodSize: The size of the food (small, large, etc).
      @return prices[foodType][foodSize]: The price of an item of the specified type and size.
    */    
    float seekPrice(int foodType, int foodSize) {
        return prices[foodType][foodSize];
    }
    
    // PRIVATE VARIABLES
    protected final float[][] prices = new float[Constants.MAX_ITEMS][Constants.MAX_SIZES]; // The price for each item and size
    protected final String[][] admins = new String[Constants.TOTAL_MANAGERS][Constants.LOGIN_REQUIREMENTS]; // The user information for managers
    protected final String[][] staff = new String[Constants.TOTAL_EMPLOYEES][Constants.LOGIN_REQUIREMENTS]; // The user information for employees
    protected final String[][] customers = new String[Constants.TOTAL_CUSTOMERS][Constants.LOGIN_REQUIREMENTS]; // The user information for customers
} // END OF FILE
