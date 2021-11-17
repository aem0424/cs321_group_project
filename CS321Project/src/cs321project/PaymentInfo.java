package cs321project;
import java.util.ArrayList;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 PAYMENTINFO CLASS
 Dr. Huaming Zhang
 CS 321-03
 November 15, 2021

 This class contains a customer's payment information; it will be validated via
 the Payment class, and the transaction will go through if it is determined to
 be valid. Otherwise, the transaction will not happen.
*/

/**
 *
 * @author antho
 */
public class PaymentInfo {
    ArrayList<String> getInfo(long ccnum, int cvc, int exp, int zip) {
        ArrayList<String> newData = new ArrayList();
        // TO DO: ADD VERIFICATION CODE HERE . . . (may be best to do this once we have an .xml file)
        return newData;
    }
    
    // THE BELOW FOUR "GET" FUNCTIONS (if we use them) WILL BE REVISED TO MAKE
    // THEM COMPATIBLE WITH THE ArrayList<String> FORMAT; THEY ARE INCLUDED
    // HERE FOR THE SAKE OF HAVING ALL NECESSARY DATA AS SOON AS POSSIBLE
    
    long getCC() {
        return ccnum;
    }
    
    int getCVC() {
        return cvc;
    }
    
    int getExp() {
        return exp;
    }
    
    int getZip() {
        return zip;
    }
    
    private long ccnum; // The numbers on the front of the credit card
    private int cvc; // The three (or so) numbers on the back
    private int exp; // The credit card's expiration date (be sure to account for both 3-digit and 4-digit expiration dates)
    private int zip; // The ZIP code on the credit card
} // END OF FILE