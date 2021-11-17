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
        /** Validates that all of the data in the PaymentInfo object is valid; if any of it is invalid,
        * return false.
        * @return validInfo: Returns true if all data is valid, and returns false otherwise. */
        public boolean checkInfo(PaymentInfo info) {
            int placeholder = 0; // WILL BE REPLACED WITH ACTUAL DATA LATER
            if(placeholder == 0) {
                validInfo = true;
            }
            else { // If any data is incorrect, reject payment
                validInfo = false;
            }
            return validInfo;
        }
    
    private boolean validInfo = false; // Defaults to false in case of an error
} // END OF FILE