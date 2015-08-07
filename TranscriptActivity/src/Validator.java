import java.util.Scanner;

public class Validator {
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine();
		return s;
	}

	public static String getGrade(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			s = getString(sc, prompt);
			if (s.equalsIgnoreCase("A") || s.equalsIgnoreCase("B")
					|| s.equalsIgnoreCase("C") || s.equalsIgnoreCase("D")
					|| s.equalsIgnoreCase("F")) {
				isValid = true;
			} else {
				System.out.println("Error! Invalid grade. Try again.");
			}
		}
		return s;
	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (i >= max) {
				System.out.println("Error! Number must be less than " + max	+ ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}
	
}