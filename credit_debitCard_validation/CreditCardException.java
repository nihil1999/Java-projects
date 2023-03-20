package projects.credit_debitCard_validation;

public class CreditCardException extends Exception {
	

	public static String err1_cardRange_mismatch = "Credit card number exceeds digit range, please enter correctly.";
	public static String err2_cardRange0_mismatch = "Card number must be greater than 0.";
	public static String err3_cardRange_less = "Please enter you card number correctly.";
	public static final String err4_input_mismatch = "\nYou should only enter number.\n";
	
	public CreditCardException(String msg) {
		super(msg);

	}
}
