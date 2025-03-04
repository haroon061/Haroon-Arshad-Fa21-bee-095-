package banking;

public class BankingSystem {

    private static final String STORED_ACCOUNT_NUMBER = "Haroon";
    private static final String STORED_PIN = "1234";


    public static class Verifier {
        public static boolean verify(String accountNumber, String pin) {
            // Check if the provided account number and pin match with our stored ones
            return accountNumber.equals(STORED_ACCOUNT_NUMBER) && pin.equals(STORED_PIN);
        }
    }

    public void displayAccountDetails() {
        System.out.println("===================================");
        System.out.println("Welcome to Your Bank Account!");
        System.out.println("Account Number: " + STORED_ACCOUNT_NUMBER);
        System.out.println("Current Balance: $10,000.00");
        System.out.println("===================================");
    }
}
