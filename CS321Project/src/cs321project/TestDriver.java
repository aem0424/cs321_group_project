package cs321project;
/**
 * My driver, used for testing.
 * @author antho
 */
public class TestDriver {
    public static void main(String[] args) {
        // INITIALIZE THE THINGS
        TestViewer viewer = new TestViewer();
        Payment process = new Payment();
        GrainBowl testFood = new GrainBowl();
        Constants.DATABASE.initializeData();
        viewer.printPrices();
        float testPrice = testFood.getPrice();
        System.out.println("TEST PRICE IS: $" + testPrice); // Demonstrates that the price array works
        System.out.println("ADMIN USER + PASS: " + Constants.DATABASE.admins[0][0] + ", " + Constants.DATABASE.admins[0][1]);
        System.out.println("STAFF USER + PASS: " + Constants.DATABASE.staff[0][0] + ", " + Constants.DATABASE.staff[0][1]);
        System.out.println("CSTMR USER + PASS: " + Constants.DATABASE.customers[0][0] + ", " + Constants.DATABASE.customers[0][1]);
        
        boolean validity; // Used to check if payment info is valid
        // BELOW 4 VALUES ARE FOR TESTING THE PAYMENT CLASS
        long testCCNUM = 123456789012L;
        int testCVC = 666;
        int testEXP = 1121;
        int testZIP = 65535;
        // END OF TEST VALUES
        
        PaymentInfo account = new PaymentInfo(testCCNUM, testCVC, testEXP, testZIP); // Making sure something like this works
        viewer.printInfo(account);
        validity = process.checkInfo(account);
        viewer.printValidity(validity);
    }
} // END OF FILE