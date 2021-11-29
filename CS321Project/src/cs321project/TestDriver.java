package cs321project;
/**
 * My driver, used for testing.
 * @author anthony_matthews
 */
public class TestDriver {
    public static void main(String[] args) {
        // INITIALIZE THE THINGS
        TestViewer viewer = new TestViewer();
        Payment process = new Payment();
        GrainBowl testGrain = new GrainBowl();
        Salad testSalad = new Salad();
        Sandwich testSandwich = new Sandwich();
        Constants.DATABASE.initializeData();
        viewer.printPrices();
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
        
        System.out.println(testSalad.getName() + " price: $" + testSalad.getPrice());
        testSalad.setSize(4);
        testSalad.setSize(1);
        System.out.println(testSalad.getName() + " price: $" + testSalad.getPrice());
        
        System.out.println(testSandwich.getKindName() + " " + testSandwich.getName() + " price: $" + testSandwich.getPrice());
        testSandwich.setKind(1);
        System.out.println(testSandwich.getKindName() + " " + testSandwich.getName() + " price: $" + testSandwich.getPrice());
        testSandwich.setSize(1);
        System.out.println(testSandwich.getKindName() + " " + testSandwich.getName() + " price: $" + testSandwich.getPrice());
        testSandwich.setSize(255);
        System.out.println(testSandwich.getKindName() + " " + testSandwich.getName() + " price: $" + testSandwich.getPrice());
        testSandwich.setKind(666);
        System.out.println(testSandwich.getKindName() + " " + testSandwich.getName() + " price: $" + testSandwich.getPrice());

        PaymentInfo account = new PaymentInfo(testCCNUM, testCVC, testEXP, testZIP); // Making sure something like this works
        viewer.printInfo(account);
        validity = process.checkInfo(account);
        viewer.printValidity(validity);
    }
} // END OF FILE