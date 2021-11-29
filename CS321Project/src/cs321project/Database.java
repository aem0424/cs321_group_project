package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Price.java
 Dr. Huaming Zhang
 CS 321-03
 November 27, 2021
 This class contains finds and stores all of the possible prices for each food
 item so they can be referenced later.
*/
import java.io.IOException;
import java.util.Arrays;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;

public class Database {
    void initializeData() {
         try {
         SAXParser sax = Constants.SAX_FACTORY.newSAXParser();
         Parser dataParser = new Parser();
         sax.parse(Constants.FOOD_DATA, dataParser);
         }  catch (IOException | ParserConfigurationException | SAXException FileNotFoundException) {
         System.out.println("An error has occured. Please check " + Constants.FOOD_DATA + " and make sure it is valid.");
         }
    }
    
    float seekPrice(int i, int j) {
        return prices[i][j];
    }
    
    boolean passCheck(String pass, String userType) { //need to check if password is in admins/staff/customers
        
        if ("customer".equals(userType))
        {
            
        for (int i = 0; i < customers.length; i++)
        {
            if (pass.equals(customers[i][1]))
            {
                return true;
            }
        }
        
        return false;
        }
        
        else if ("employee".equals(userType))
        {
            for (int i = 0; i < staff.length; i++)
            {
                if (pass.equals(staff[i][1]))
                {
                    return true;
                }
            }
            
            return false;
        }
        
        else if ("manager".equals(userType))
        {
        for (int i = 0; i < admins.length; i++)
        {
            if (pass.equals(admins[i][1]))
            {
                return true;
            }
        }
        
        return false;
        }
        
        else
        {
            return false;
        }
        
        
        
    }
    
    protected final float[][] prices = new float[Constants.MAX_ITEMS][Constants.MAX_SIZES];
    protected final String[][] admins = new String[Constants.TOTAL_MANAGERS][2];
    protected final String[][] staff = new String[Constants.TOTAL_EMPLOYEES][2];
    protected final String[][] customers = new String[Constants.TOTAL_CUSTOMERS][2];
} // END OF FILE