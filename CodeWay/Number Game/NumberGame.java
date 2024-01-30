import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// check

public class NumberGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printMenu();
		int choice = getIntInput(sc, "Enter your choice:\t");
		System.out.println("---------------------------------------");
		if (choice == 1) {
			int randomNum = generateRandomNumber();
			int userNum = getIntInput(sc, "Enter your guessed number:\t");
			if (randomNum == userNum) {
				winnerPrompt();
				gameEndPrompt();
			} else {
				wrongGuessPrompt();
				gameEndPrompt();
			}

		} else if (choice == 2) {
			int count = 5;
			int randomNum = generateRandomNumber();
			for (int i = 0; i < 5; i++) {
				System.out.println("You have " + count + " attempt left !");
				int userNum = getIntInput(sc, "Enter your guessed number:\t");
				if (randomNum == userNum) {
					winnerPrompt();
					gameEndPrompt();
				} else {
					count--;
					wrongGuessPrompt();
					suggestNumber(randomNum, userNum, count);
					if (count == 0)
						gameEndPrompt();
				}
			}
		} else {
			System.out.println("Invalid choice !");
		}
		sc.close();
	}

	private static void gameEndPrompt() {
		System.out.println("---------------------------------------");
		System.out.println("************** GAME ENDED *************");
		System.out.println("---------------------------------------");
		System.exit(0);
	}

	private static void suggestNumber(int randomNum, int userNum, int count) {
		if (count != 0) {
			if (Math.abs(randomNum - userNum) < 5) {
				System.out.println("So close to the number...");
				System.out.println("---------------------------------------");
			} else if (Math.abs(randomNum - userNum) > 10) {
				System.out.println("So far with number...");
				System.out.println("---------------------------------------");
			}
		}
	}

	private static int getIntInput(Scanner sc, String prompt) {
		System.out.print(prompt);
		int data = sc.nextInt();
		sc.nextLine();
		return data;
	}

	private static void wrongGuessPrompt() {
		System.out.println("---------------------------------------");
		System.out.println("Wrong Guess Please Try again !");
	}

	private static void winnerPrompt() {
		System.out.println("---------------------------------------");
		System.out.println("Hurrey you guess the right number !");
		System.out.println("Thank you for Playing !!");
		System.out.println("---------------------------------------");
	}

	private static int generateRandomNumber() {
		return ThreadLocalRandom.current().nextInt(1, 100);
	}

	private static void printMenu() {
		System.out.println("\n---------------------------------------");
		System.out.println("************* NUMBER GAME *************");
		System.out.println("---------------------------------------");
		System.out.println("NOTE: This is the number guessing game \nin this game you"
				+ "system is generate any\nrandom number and you have to guess\nit" + " range of number (1-100)\nHint: So far = differ by >10 \nand so close = differ by <5");
		System.out.println("---------------------------------------");
		System.out.println("1.Play Single attempt\n2.Play Multiple attempt");
		System.out.println("---------------------------------------");
	}
}
