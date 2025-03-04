package util;

public class PinValidator {
    // The user-entered PIN 
    private String pin;

    // Constructor to store the PIN
    public PinValidator(String pin) {
        this.pin = pin;
    }


    public class Rules {
        
        public boolean isValidPin() {
            return PinValidator.this.pin.length() == 4 && PinValidator.this.pin.matches("\\d+");
        }
    }
}
