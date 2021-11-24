package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 PAYMENT CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 15, 2021
 This class handles the payment process; it will take some data from the
 PaymentInfo class, and check to make sure that all of the information
 provided is valid.
*/

public class Payment {
    // NOTE: checkInfo WILL BE OPTIMIZED LATER; FOR NOW, I WANTED TO MAKE SOMETHING FUNCTIONAL ENOUGH.
    
        /** Validates that all of the data in the PaymentInfo object is valid; if any of it is invalid,
        * return false.
        * @param info: The payment information to check.
        * @return validInfo: Returns true if all data is valid, and returns false otherwise. */
        public boolean checkInfo(PaymentInfo info) {
            // GET TEMPORARY VALUES (slightly more optimized than repeating the get functions)
            int tempZip = info.getZip();
            long tempCC = info.getCCnum();
            int tempEXP = info.getExp();
            int tempCVC = info.getCvc();
            
            // THE CONDITION STATEMENT IS A WORK-IN-PROGRESS
            if(tempZip > 0 && tempZip < 100000 &&
               tempCVC > 99 && tempCVC < 10000 && // Most CVC values are 3 or 4 digits
               tempCC != 0 && tempEXP != 0) { // Will work on this later
                validInfo = true;
            }
            else { // If any data is incorrect, reject payment
                validInfo = false;
            }
            return validInfo;
        }
    
    private boolean validInfo = false; // Defaults to false in case of an error (this variable may be redundant; let me make sure)
} // END OF FILE