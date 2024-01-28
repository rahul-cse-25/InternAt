import java.util.Scanner;

public class QuizImplementation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuizLogic ql = new QuizLogic();
		while (true) {
			System.out.println("\n-----------------------------------------------");
			System.out.println("********* Quiz Application with Timer *********");
			System.out.println("-----------------------------------------------");
			System.out.println("This is the Timer Quiz Application,\nNOTE: You have 10 minute to answer all questions"
					+ "\nIf you not attempt all questions in given time \nthen it will submit automatic and show result.");
			System.out.println("-----------------------------------------------");
			System.out.println("1.Start Quiz\n2.End the Program");
			System.out.println("-----------------------------------------------");
			System.out.print("Enter your choice:\t");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println("-----------------------------------------------");
			switch (choice) {
			case 1: {
				ql.startQuiz(sc);
				System.exit(0);
			}
			case 2: {
				System.out.println("-----------------------------------------------");
				System.out.println("Program Ended !");
				System.out.println("-----------------------------------------------");
				System.exit(0);
			}
			default:
				System.out.println("Invalid choice !");
			}

		}
	}
}
