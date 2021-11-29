package cs321project;
import java.io.File;
import java.util.Calendar;
import javax.xml.parsers.SAXParserFactory;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Constants.java
 Dr. Huaming Zhang
 CS 321-03
 November 26, 2021

 This class holds static constants to be used for other classes.
  
 @author anthony_matthews
*/
public class Constants {
        // DATE-BASED CONSTANTS
        protected static final Calendar TODAY = Calendar.getInstance(); // Gets today's date, to use with the month and year functions
        protected static final int CURRENT_MONTH = TODAY.get(Calendar.MONTH) + 1; // The Calender getMonth function is from 0-11, so increase by 1 to match input range
        protected static final int CURRENT_YEAR = TODAY.get(Calendar.YEAR) - 2000; // Subtract by 2000 to match with Exp input data
        // FOOD DATA CONSTANTS
        protected static final int MAX_ITEMS = 5; // Total number of food items (5, for this project's purposes)
        protected static final int MAX_SIZES = 2; // Total number of different sizes available (2, for this project's purposes)   
        // USER INFORMATION CONSTANTS
        protected static final int TOTAL_MANAGERS = 10; // Total number of managers in the system
        protected static final int TOTAL_EMPLOYEES = 10; // Total number of employees in the system
        protected static final int TOTAL_CUSTOMERS = 10; // Total number of customers in the system
        protected static final int LOGIN_REQUIREMENTS = 2; // Amount of information user must enter in order to login
        // PARSER AND DATABASE CONSTANTS
        protected static final Database DATABASE = new Database(); // Has an array that holds all of the prices, plus all of the login information
        protected static final File FOOD_DATA = new File("StorageAlt.xml"); // The file to get the database information from
        protected static final SAXParserFactory SAX_FACTORY = SAXParserFactory.newInstance(); // SAX Parser factory singleton (only produces one for this project)
} // END OF FILE
