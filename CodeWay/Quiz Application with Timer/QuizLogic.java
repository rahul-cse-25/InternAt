import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizLogic {
	static int secondsRemaining = 10; // define the limit of time for quiz, here it is 10 seconds
	static int questionsAttempted = 0;
	static int totalQuestions;
	static boolean isTimeUp = false;
	static int correctAns = 0;

	Questions que1 = new Questions("Who invented Java Programming?", "a)Guido van Rossum", "b)James Gosling",
			"c)Dennis Ritchie", "d)Bjarne Stroustrup");
	Questions que2 = new Questions("Which statement is true about Java?",
			"a)Java is a sequence-dependent programming language", "b)Java is a code dependent programming language",
			"c)Java is a platform-dependent programming language",
			"d)Java is a platform-independent programming language");
	Questions que3 = new Questions("Which component is used to compile, debug and execute the java programs?", "a)JRE",
			"b)JIT", "c)JDK", "d)JVM");
	Questions que4 = new Questions("Which one of the following is not a Java feature?", "a)Object-oriented",
			"b)Use of pointers", "c)Portable", "d)Dynamic and Extensible");
	Questions que5 = new Questions("Which of these cannot be used for a variable name in Java?",
			"a)identifier & keyword", "b)identifier", "c)keyword", "d)none of the mentioned");
	Questions que6 = new Questions("What is the extension of java code files?", "a).js", "b).txt", "c).class",
			"d).java");
	Questions que7 = new Questions(
			"What will be the output of the following Java code?\n\nclass increment{\n\tpublic static void main(String args[]){\n\t\tint g = 3;\n\t\tSystem.out.print(++g * 8);\n\t}\n}\n",
			"a)32", "b)33", "c)24", "d)25");
	Questions que8 = new Questions("Which environment variable is used to set the java path?", "a)MAVEN_Path",
			"b)JavaPATH", "c)JAVA", "d)JAVA_HOME");
	Questions que9 = new Questions("What is not the use of “this” keyword in Java?",
			"a)Referring to the instance variable when a local variable has the same name",
			"b)Passing itself to the method of the same class", "c)Passing itself to another method",
			"d)Calling another constructor in constructor chaining");
	Questions que10 = new Questions("Which of these are selection statements in Java?", "a)break", "b)continue",
			"c)for()", "d)if()");

	Map<Questions, Character> map = new HashMap<>();

	public QuizLogic() {
		map.put(que1, 'b');
		map.put(que2, 'd');
		map.put(que3, 'c');
		map.put(que4, 'b');
		map.put(que5, 'c');
		map.put(que6, 'd');
		map.put(que7, 'a');
		map.put(que8, 'd');
		map.put(que9, 'b');
		map.put(que10, 'd');
		totalQuestions = map.size();
	}

	public void startQuiz(Scanner sc) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secondsRemaining--;

				if (secondsRemaining <= 0 || questionsAttempted == totalQuestions) {
					timer.cancel();
					isTimeUp = true;
					sc.close();
					getResult();
					System.exit(0);
				}
			}
		}, 1000, 1000); // Schedule the timer to run every second
		int countQuestionNum = 1;
		for (Map.Entry<Questions, Character> que : map.entrySet()) {
			System.out.println("--------------------------------------------------");
			System.out.println("Time Remains:\t" + secondsRemaining + " seconds");
			System.out.println(countQuestionNum + ". " + que.getKey().getQuestion());
			System.out.println(que.getKey().getOption_a());
			System.out.println(que.getKey().getOption_b());
			System.out.println(que.getKey().getOption_c());
			System.out.println(que.getKey().getOption_d());
			System.out.print("Enter your answer:\t");
			Character ans = sc.next().charAt(0);
			countQuestionNum++;
			if (ans.equals(que.getValue())) {
				System.out.println("Correct Answer !");
				correctAns++;
			} else {
				System.out.println("Wrong Answer !");
			}

			questionsAttempted++;
			System.out.println("--------------------------------------------------");
			if (isTimeUp)
				break;
		}

		if(!isTimeUp) {
			timer.cancel();
			sc.close();
			getResult();
		}
	}

	public void getResult() {
	    System.out.println("--------------------------------------------------");
	    System.out.println("Form Submitted !!");
	    System.out.println("--------------------------------------------------");
	    System.out.println("********************Quiz Result*******************");
	    System.out.println("--------------------------------------------------");
	    System.out.println("Here is your result");

	    int unansweredQuestions = totalQuestions - questionsAttempted;

	    if (unansweredQuestions > 0) {
	        System.out.println("Unanswered Questions:\t" + unansweredQuestions);
	    }

	    System.out.println("Correct Answers:\t" + correctAns);
	    System.out.println("Wrong Answers:\t" + (questionsAttempted - correctAns));
	    System.out.println("Total Questions Attempted:\t" + questionsAttempted); // Fix here
	    System.out.println("Total Questions:\t" + totalQuestions);

	    double percentage = (correctAns * 100) / totalQuestions;
	    System.out.println("Percentage:\t" + percentage + "%");

	    if (percentage >= 80) {
	        System.out.println("Excellent Performance !! ");
	    } else if (percentage >= 40 && percentage < 80) {
	        System.out.println("Average Performance !! ");
	    } else {
	        System.out.println("Poor Performance !! ");
	    }

	    System.out.println("Have a Good Day !!");
	    System.out.println("--------------------------------------------------");
	}



}
