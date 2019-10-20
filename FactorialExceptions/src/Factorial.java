import java.util.Scanner;
import java.util.InputMismatchException;

public class Factorial {

	/*
	 * Recursion Assignment (with exceptions added). 
	 * Author: Mikolaj Wieczorek 
	 * Due: September 26th, 2019
	 * 
	 * This class computes factorial number of a positive integer using the user's
	 * input value with Scanner.
	 * 
	 * Methods:
	 * 
	 * - looping factorial method: using a simple loop way 
	 * 
	 * - recursive factorial method: using recursion
	 * 
	 * Exceptions used:
	 * 
	 * - InputMismatchException: for any value inputed by user different from an
	 * int. This exception is imported from java.util.InputMismatchException. 
	 * 
	 * - OutOfBounds: for any value inputed by user that exceeds 20. This is a
	 * throwable exception created in OutOfBounds.java file. 
	 * 
	 * - InvalidUserInput: for any value inputed by user that is smaller than 0. 
	 * This is a throwable exception created in InvalidUserInput.java file.
	 * 
	 */

	public static void main(String args[]) {
		// Define a new Scanner object for keyboard input.
		Scanner keyBoard = new Scanner(System.in);

		while (true) {
			// Start with some user input parameter validation.
			System.out.println("");
			System.out.println("Enter a positive integer or -1 to end.");
			int inputInt;
			try {
				inputInt = keyBoard.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Please enter an integer value.");
				keyBoard.next();
				continue;
			}

			if (inputInt == -1) {
				keyBoard.close();
				return;
			} // the only way to get out of the program;

			// Factorial via looping.
			try {
				long resultLoop = factorialLoop(inputInt);
				System.out.println("\nCalling looping factorial method using " + inputInt);
				System.out.println("Looping Factorial result: " + resultLoop);
			} catch (OutOfBounds ex) {

				System.out.println(ex.getMessage());

			} catch (InvalidUserInput ex) {
				System.out.println(ex.getMessage());
			}

			// Factorial via recursion.

			try {
				long resultRecurse = factorialRecursive(inputInt);
				System.out.println("\nCalling recursive factorial method using " + inputInt);
				System.out.println("Recursive Factorial result: " + resultRecurse);
			} catch (OutOfBounds ex) {
				// Do not need to have another prompt printed when user inputs incorrect value.
				// System.out.println(ex.getMessage());
			} catch (InvalidUserInput ex) {
				// Do not need to have another prompt printed when user inputs incorrect value.
				// System.out.println(ex.getMessage());
			}
		}

	}

	/*
	 * This is the factorial routine implemented using recursion. The input is, on
	 * first call, the starting integer. On subsequent calls, the decremented
	 * integer values. We are assuming here that the input is never a negative
	 * value.
	 */

	// Looping factorial method. Protect the methods by "OutOfBounds,
	// InvalidUserInput"
	public static long factorialLoop(int inputInt) throws OutOfBounds, InvalidUserInput {

		/*
		 * If nextInt is larger than 20, throw OutOfBounds exception; construct
		 * OutOfBounds object that will be used as a message in the catch block
		 */
		if (inputInt > 20)
			throw new OutOfBounds("Please enter an integer smaller than 20.");

		/*
		 * If nextInt is smaller than 0, throw InvalidUserInput; construct
		 * InvalidUserInput object that will be used as a message in the catch block
		 */
		if (inputInt < 0)
			throw new InvalidUserInput("Please enter an integer greater than 0.");

		// We stop the recursion if the input is 1 or 0.
		if ((inputInt == 1) || (inputInt == 0))
			// it's going to return to the next instruction --> result = ...
			return 1;

		long factorial = 1;
		int i = inputInt;

		// Continue multiplying ever decreasing integers as long as they are greater
		// than 1.
		while (i > 1) {
			factorial = factorial * i;
			System.out.println("Multiplier = " + i + ", result = " + factorial);

			--i;
		}
		return factorial; // ... and done.
	} // End of ... Looping factorial method.

	// Recursive factorial method. Protect the methods by "OutOfBounds,
	// InvalidUserInput"
	public static long factorialRecursive(long nextInt) throws OutOfBounds, InvalidUserInput

	{

		/*
		 * If nextInt is larger than 20, throw OutOfBounds exception; construct
		 * OutOfBounds object that will be used as a message in the catch block
		 */
		if (nextInt > 20)
			throw new OutOfBounds("Please enter an integer smaller than 20.");

		/*
		 * If nextInt is smaller than 0, throw InvalidUserInput; construct
		 * InvalidUserInput object that will be used as a message in the catch block
		 */
		if (nextInt < 0)
			throw new InvalidUserInput("Please enter an integer greater than 0.");

		long result;

		// We stop the recursion if the input is 1 or 0.
		if ((nextInt == 1) || (nextInt == 0))
			// it's going to return to the next instruction --> result = ...
			return 1;
		/*
		 * When finally '1', we return to the caller/ The next integer is greater than
		 * one. Continue calling down to the next factorial method.
		 */

		/*
		 * Method calling itself - recursion. nextInt is being decremented each time it
		 * goes through the loop.
		 */
		result = factorialRecursive(nextInt - 1);

		// ... then apply the next multiplier.
		result *= nextInt; // *= result times nextInt is equal to result

		System.out.println("Multiplier = " + nextInt + ", Result = " + result);

		// this result is going to be the result/caller = factorailRec...
		return result; // ... and done.

	} // End of ... Recursive factorial method.

	/*
	 * This is the factorial routine implemented using looping. We are assuming here
	 * that the input is never a negative value. But, as implemented, every integer
	 * less than 2 returns the value 1.
	 */

}
