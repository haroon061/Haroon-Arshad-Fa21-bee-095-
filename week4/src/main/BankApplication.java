package main;

import banking.BankingSystem;
import util.PinValidator;
import java.io.Console;

public class BankApplication {

    public static void main(String[] args) {
        // The Console object helps us read user input securely.
        Console console = System.console();

        if (console == null) {
            System.err.println("No console available. Please run this in a supported environment.");
            return;
        }

        System.out.print("Enter Account Number: ");
        String inputAccountNumber = console.readLine();

        System.out.print("Enter PIN: ");
        char[] pinChars = console.readPassword(); 
        String inputPin = new String(pinChars);   

        PinValidator pinValidator = new PinValidator(inputPin);
        PinValidator.Rules pinRules = pinValidator.new Rules();

        while (!pinRules.isValidPin()) {
            System.out.println("Error: Invalid PIN format. Please enter a 4-digit numeric PIN.");
            System.out.print("Re-enter PIN: ");
            pinChars = console.readPassword();
            inputPin = new String(pinChars);


            pinValidator = new PinValidator(inputPin);
            pinRules = pinValidator.new Rules();
        }

        boolean isVerified = BankingSystem.Verifier.verify(inputAccountNumber, inputPin);

        if (isVerified) {

            BankingSystem system = new BankingSystem();
            system.displayAccountDetails();
        } else {
           
            System.out.println("Invalid credentials. Access denied.");
        }
    }
}
