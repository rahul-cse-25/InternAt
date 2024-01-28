import java.util.Scanner;

public class AtmImplementation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean terminate = false;
		AtmServices atm = new AtmServices();
		boolean back = false;
		while (!terminate) {
			System.out.println("\n------------------------------");
			System.out.println("******* ATM Simulation *******");
			System.out.println("------------------------------");
			int cardNum = getIntInput(sc, "Enter Card Number (last 4 digit):\t");
			System.out.println("------------------------------");
			if (atm.isPresent(cardNum)) {
				atm.setCardNum(cardNum);
				while (true) {
					System.out.println("\n------------------------------");
					System.out.println("******* ATM Simulation *******");
					System.out.println("------------------------------");
					System.out.println("1.Check Balance\n2.WithDraw\n3.Deposit\nEnter -1 to Exit");
					System.out.println("------------------------------");
					int choice = getIntInput(sc, "Enter your choice:\t");
					switch (choice) {
					case 1: {
						int pin = getIntInput(sc, "Enter Pin code:\t");
						atm.setPinNum(pin);
						System.out.println(atm.balance());
						break;
					}
					case 2: {
						int amount = getIntInput(sc, "Enter amount:\t");
						int pin = getIntInput(sc, "Enter Pin code:\t");
						atm.setPinNum(pin);
						atm.withdraw(amount);
						break;

					}
					case 3: {
						int amount = getIntInput(sc, "Enter amount:\t");
						int pin = getIntInput(sc, "Enter Pin code:\t");
						atm.setPinNum(pin);
						atm.deposit(amount);
						break;
					}
					case -1: {
						System.out.println("------------------------------");
						System.out.println("Thank You Visit Again !!");
						System.out.println("------------------------------");
						back = true;
						break;
					}
					default: {
						System.out.println("Invalid choice !");
					}

					}
					if (back)
						break;
				}
			} else {
				System.out.println("User Not Exist.");
				int choice = getIntInput(sc, "Press 1 to Try Again or Press any other key to end the program:\t");
				if (choice != 1) {
					System.out.println("------------------------------");
					System.out.println("Program Ended ! Thank You Visit Again !!");
					System.out.println("------------------------------");
					terminate = true;
				}
			}
		}

	}

	private static int getIntInput(Scanner sc, String prompt) {
		System.out.print(prompt);
		int data = sc.nextInt();
		sc.nextLine();
		return data;
	}
}
