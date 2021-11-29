package cs321project;
/**
 CS 321-03 GROUP PROJECT (PANERA BREAD)
 PaymentInfo.java
 Dr. Huaming Zhang
 CS 321-03
 November 15, 2021

 This class contains a customer's payment information; it will be validated via
 the Payment class, and the transaction will go through if it is determined to
 be valid. Otherwise, the transaction will not happen.
  
 @author anthony_matthews
*/

public class PaymentInfo {
    /**
      The default constructor for the PaymentInfo class; the values will be obtained
      from the user inputting their payment information.
      @param ccnum: The value to be assigned to an object's ccnum variable.
      @param cvc: The value to be assigned to an object's cvc variable.
      @param exp: The value to be assigned to an object's exp variable.
      @param zip: The value to be assigned to an object's zip variable.
    */
    public PaymentInfo(long ccnum, int cvc, int exp, int zip) {
        this.ccnum = ccnum;
        this.cvc = cvc;
        this.exp = exp;
        this.zip = zip;
    }
    
    /**
    Gets the value for a PaymentInfo object's CC number.
    @return this.ccnum: The ccnum value for this object.
    */
    long getCCnum() {
        return this.ccnum;
    }

    /**
    Gets the value for a PaymentInfo object's CVC number.
    @return this.cvc: The cvc value for this object.
    */    
    int getCvc() {
        return this.cvc;
    }

    /**
    Gets the value for a PaymentInfo object's expiration date.
    @return this.exp: The exp value for this object.
    */      
    int getExp() {
        return this.exp;
    }
    
    /**
    Gets the value for a PaymentInfo object's ZIP code.
    @return this.zip: The zip value for this object.
    */          
    int getZip() {
        return this.zip;
    }
    
    // PRIVATE VARIABLES
    private long ccnum; // The numbers on the front of the credit card
    private int cvc; // The three (or so) numbers on the back
    private int exp; // The credit card's expiration date (be sure to account for both 3-digit and 4-digit expiration dates)
    private int zip; // The ZIP code on the credit card
} // END OF FILE