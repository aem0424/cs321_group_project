package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 Payment.java
 Dr. Huaming Zhang
 CS 321-03
 November 15, 2021

 This class handles the payment process; it will take some data from the
 PaymentInfo class, and check to make sure that all of the information
 provided is valid.
  
 @author anthony_matthews
*/

public class Payment {
    /**
      Validates that all of the data in the PaymentInfo object is valid; if any of it is invalid,
      return false.
      @param info: The payment information to check (consists of ZIP, CCnum, EXP date, and CVC num).
      @return validInfo: Returns true if all data is valid, and returns false otherwise.
    */
    public boolean checkInfo(PaymentInfo info) {
       // GET THE VARIABLES FROM THE ENTERED PAYMENT (more optimized than calling the get functions each time)
       int tempZip = info.getZip();
       long tempCC = info.getCCnum();
       int tempEXP = info.getExp();
       int tempCVC = info.getCvc();
            
       // VERIFY THAT THE INFORMATION IS VALID
       if(tempZip > 0 && tempZip < 100000 && // ZIP codes are generally within this range
          tempCVC > 99 && tempCVC < 10000 && // Most CVC values are 3 or 4 digits
          tempCC >= 10000000000L && tempCC <= 999999999999L // Check that CC is at least 11 digits (could start with 0) but no more than 12
          && dateCheck(tempEXP)) { // Run final check to see if date input is valid
           validInfo = true;
       }
       else { // If any data is incorrect, reject payment
           validInfo = false;
       }
       return validInfo;
    }

    /**
      Checks the data integer to make sure that it is a valid date.
      @param date: The date from the payment info, as an integer.
      @return validDate: Returns true if the date is valid, false otherwise.
    */    
    public boolean dateCheck(int date) {
        // CONVERT THE INPUT MONTH AND YEAR INTO WORKABLE VALUES
        int inputMonth = date / 100; // Result should be from 1-12
        if (inputMonth < 1 || inputMonth > 12) // Can return false early if value is impossible
            return false;
        int inputYear = date - (inputMonth * 100);
        if (inputYear < 0 || inputYear > 99) // Same case as inputMonth above
            return false;

        // RUN CHECKS
        if (inputYear < Constants.CURRENT_YEAR) // Credit card expired the previous year
            return false;
        else if (inputYear == Constants.CURRENT_YEAR && inputMonth < Constants.CURRENT_MONTH) // Credit card expired at least a month prior
            return false;
        return true; // Returns true if all data is correct
    }
    
    // PRIVATE VARIABLES
    private boolean validInfo = false; // Determines validity of input information; defaults to false in case of an error
} // END OF FILE