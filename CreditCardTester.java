
/**
 * A tester for the CreditCard class.
 * 
 */

import java.util.Scanner;

public class CreditCardTester 
{
    public static void main(String[] args) 
	{
        System.out.println("Please enter a 12-digit credit card number.");
	    Scanner scanner = new Scanner(System.in);
	    String creditCardNumber = scanner.next();
		if (creditCardNumber.length() == 12)
		{
			CreditCard card = new CreditCard(creditCardNumber);
			card.check();
			if (card.isValid()) 
			{
				System.out.println("Valid");
			} 
			else 
			{
				int code = card.getErrorCode();
				System.out.println("Oops! That's an invalid number.");
				System.out.println("The error code was: " + code); 
			}
		}
		else
		{
			System.out.println("The Credit Card Number is an invalid length. Please try again.");
			main(args);
		}
    }
}
