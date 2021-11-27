package cs321project;
import java.util.Calendar;
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
        // WILL LIKELY PUT THE PARSER DEFINITION HERE
} // END OF FILE