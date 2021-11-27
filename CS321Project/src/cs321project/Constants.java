package cs321project;
import java.io.File;
import java.util.Calendar;
import javax.xml.parsers.SAXParserFactory;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 CONSTANTS CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 26, 2021

 This class holds static constants to be used for other classes.
*/
public class Constants {
        public static final Calendar TODAY = Calendar.getInstance(); // Gets today's date, to use with the month and year functions
        public static final int CURRENT_MONTH = TODAY.get(Calendar.MONTH) + 1; // The Calender getMonth function is from 0-11, so increase by 1 to match input range
        public static final int CURRENT_YEAR = TODAY.get(Calendar.YEAR) - 2000; // Subtract by 2000 to match with Exp input data
        // PUT SOMETHING FOR FOOD_DATA FILEPATH (not finalized yet)
        protected static final File FOOD_DATA = new File("C:\\Users\\antho\\Desktop\\CS 321-03\\cs321_group_project\\CS321Project\\src\\cs321project\\StorageAlt.xml");
        // PUT SOMETHING FOR FOOD_DATA FILEPATH (not finalized yet)
        protected static final int MAX_ITEMS = 5; // Total number of food items (5, for this project's purposes)
        protected static final int MAX_SIZES = 2; // Total number of different sizes available (2, for this project's purposes)        
        protected static final SAXParserFactory SAX_FACTORY = SAXParserFactory.newInstance(); // SAX Parser factory singleton (only produces one for this project)
        protected static final Price PRICE_DATABASE = new Price(); // Has an array that holds all o the prices
} // END OF FILE