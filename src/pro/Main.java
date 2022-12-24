package pro;

import java.text.NumberFormat;
import java.util.*;

public class Main {

	// Declaring color to be used in terminal
	// Custom declaration
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_YELLOW = "\u001B[33m";

	// Initial academy dataas & Evaluations
	static final int ACADEMY_PERIOD = 3;
	static final double PAYMENT_RATE_FOR_ACADEMY = 31 / 100.0;
	static final int MONTLY_GROSS_INCOME_FOR_ACADEMY = 650;
	static final int GROSS_ACADEMY_INCOME = ACADEMY_PERIOD * MONTLY_GROSS_INCOME_FOR_ACADEMY;

	// Permanent datas && Evaluations
	static final double PERMANENT_PAYMENT_RATE = 40 / 100.00;
	static final int PERMANENT_GROSS_MONTHLY_INCOME = 1_600;

	// int[]

	// Instantiating the Calculator Method
	public static ArrayList<String> paymentCalculator(int[] numbersOfMonths) {
		ArrayList<String> outList = new ArrayList<>();
		for (int numberOfMonths : numbersOfMonths) {
			double permanentPaidFees = 3_840;

			final int PERMANENT_GROSS = numberOfMonths * PERMANENT_GROSS_MONTHLY_INCOME;

			int monthsDifference = 6 - numberOfMonths;

			double DISCOUNT_RATE = numberOfMonths < 6 ? (10 / 100.0) * monthsDifference : 1;

			// Building output results
			permanentPaidFees = (numberOfMonths < 6) ? permanentPaidFees - (permanentPaidFees * DISCOUNT_RATE)
					: permanentPaidFees;

			double permanentEarnings = PERMANENT_GROSS - permanentPaidFees;

			outList.add(NumberFormat.getCurrencyInstance(Locale.US).format(permanentEarnings / numberOfMonths));
		}

		return outList;

	}

	public static void main(String[] args) {
		try {

			int[] inputs = { 6, 5, 4, 3, 2 };

			List<String> outList = paymentCalculator(inputs);
			for (int i = 0; i < inputs.length; i++) {
				String x = outList.get(i);
				// Invoking the Calculator Method on correct input
				System.out.println(ANSI_CYAN + "HOME TAKE AWAY FOR " + inputs[i] + " Months: " + ANSI_GREEN + x + "\n\n");
			}
		} catch (NumberFormatException e) {
			System.out.println("\n\n" + ANSI_RED + "Please enter a valid number");
		}

	}

}
