package cs321project;
/**
 * My viewer, used for testing.
 * @author antho
 */
public class TestViewer {
    /**
      Prints all of the information from the payment account.
      @param info: The account from which to get the data code from.
   */
    void printInfo(PaymentInfo info) {
        System.out.println("The credit card number is: " + info.getCCnum() + ".");
        System.out.println("The CVC number is: " + info.getCvc() + ".");
        System.out.println("The expiration date is: " + info.getExp() + ".");
        System.out.println("The ZIP code is: " + info.getZip() + ".");
    }
  
    /**
      Prints a message based on whether or not the payment info is valid.
      @param valid: A boolean value to be obtained from Payment.checkInfo().
    */
    void printValidity(boolean valid) { // May only need to print a message if an order has an error
        if (valid == true)
            System.out.println("The payment info you entered is valid. Your order will be processed shortly!");
        else
            System.out.println("ERROR: The payment info you entered is not valid. Please try again.");
    }
    
    void printPrices() {
        for(int i = 0; i < Constants.MAX_ITEMS; i++)
            for(int j = 0; j < Constants.MAX_SIZES; j++)
            {
                System.out.println("ITEM " + i + ", SIZE " + j + " PRICE: $" + Constants.PRICE_DATABASE.seekPrice(i, j));
            }
    }
} // END OF FILE