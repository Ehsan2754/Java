package ir.ahuratus.Task5;

import java.util.Scanner;

public abstract class TestAssert {
	
	private static final boolean CHECK_ASSERTIONS = true;

	public static void main(String[] args) {
		System.out.print("Inform your age: ");
		Scanner scanner;
		try {
			scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			Integer age = Integer.valueOf(inputString);
			
			// validateAge(age);
			if (CHECK_ASSERTIONS)
				assert age <= 969 : "too old!";
				assert age >= 0   : "Negative age?!!!:)))";

						System.out.println(inputString);
		} catch (NumberFormatException e) {
			System.out.println("The argument was not a number.");
		}
	}
	
	private static boolean validateAge(Integer age) {
		assert age >= 0 && age <= 969;
		// TODO Complex validation
		return true;
	}

}
