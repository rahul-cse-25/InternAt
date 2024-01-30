import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------------------------------------");
		System.out.println("***** Student Grade Calculator *****");
		System.out.println("------------------------------------");
		System.out.println(
				"This is the Grade Calculor along \nwith some other feature you have to \njust enter the marks of subjects");
		System.out.println("------------------------------------");
		System.out.print("Enter no. of Subjects:\t");
		int n = sc.nextInt();
		sc.nextLine();
		String[] subjects = getSubjectsMarks(sc, n);
		System.out.println("------------------------------------");
		int[] marks = getMarks(sc, subjects);
		int totalMarks = getTotalMarks(marks);
		float averagePercent = getAveragePercent(totalMarks, subjects.length);
		String grade = getGrade(averagePercent);
		displayResult(subjects, marks, totalMarks, averagePercent, grade);
		System.out.println("      *** Program Ended ! ***");
		System.out.println("------------------------------------");
		sc.close();
	}

	private static String[] getSubjectsMarks(Scanner sc, int n) {
		String[] sub = new String[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the "+(i+1) +" Subject's Name:\t");
			sub[i] = sc.nextLine();
		}
		return sub;
	}

	private static void displayResult(String[] subjects, int[] marks, int totalMarks, float averagePercent,
			String grade) {
		System.out.println("\n------------------------------------");
		System.out.println("************** Result **************");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		for (int i = 0; i < subjects.length; i++) {
			System.out.println(subjects[i] + " :\t" + marks[i]);
		}
		System.out.println("------------------------------------");
		System.out.println("Total Marks:\t" + totalMarks);
		System.out.println("Average Percentage:\t" + averagePercent + "%");
		System.out.println("Grade:\t" + grade);
		System.out.println("------------------------------------");
		System.out.println("NOTE:\nGrade P: Just Passed\nGrade F: Failed");
		System.out.println("------------------------------------");
	}

	private static String getGrade(float averagePercent) {
		if (averagePercent > 80)
			return "O";
		else if (averagePercent > 75 && averagePercent < 80)
			return "A";
		else if (averagePercent > 70 && averagePercent < 75)
			return "B";
		else if (averagePercent > 60 && averagePercent < 70)
			return "C";
		else if (averagePercent > 50 && averagePercent < 60)
			return "D";
		else if (averagePercent > 40 && averagePercent < 50)
			return "P";
		return "F";
	}

	private static float getAveragePercent(int totalMarks, int n) {
		return totalMarks / n;
	}

	private static int getTotalMarks(int[] marks) {
		int sum = 0;
		for (int num : marks)
			sum += num;
		return sum;
	}

	private static int[] getMarks(Scanner sc, String[] subjects) {
		int[] marks = new int[subjects.length];
		for (int i = 0; i < marks.length; i++) {
			int temp = getIntInput(sc, "Enter the marks of " + subjects[i] + " :\t");
			while (temp > 100 || temp < 0) {
				System.out.println("Marks should be between 1-100");
				temp = getIntInput(sc, "Enter the marks of " + subjects[i] + " :\t");
			}
			marks[i] = temp;
		}
		return marks;
	}

	private static int getIntInput(Scanner sc, String prompt) {
		System.out.print(prompt);
		int data = sc.nextInt();
		sc.nextLine();
		return data;
	}
}
