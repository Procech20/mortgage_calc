import java.util.Scanner;

/**
 * Main
 */
public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("\n\n" + "Enter a number: ");

			int input = scanner.nextInt();

			if (input % 5 == 0 && input % 3 == 0)
				System.out.println("FizzBuzz");
			else if (input % 5 == 0)
				System.out.println("Fizz");
			else if (input % 3 == 0)
				System.out.println("Buzz");
			else
				System.out.println(input);
		}

	}

}
