import quiz.QuizClass;
import java.util.Scanner;

public class Quizzer{
	public static void main(String[] args) {
		System.out.println("Welcome to Quizzer! How many questions do you want?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n == 0){
			throw new ArrayIndexOutOfBoundsException("The number must be a positive integer.");
		}
		scan.nextLine();
		QuizClass quiz = new QuizClass(n);
		for(int i = 0; i < n; i++){
			System.out.println(quiz.getQuestion(i));
			String ans = scan.nextLine();
			quiz.setAnswer(i, ans);
		}
		System.out.print("Your score is ");
		System.out.print(quiz.getScore());
		System.out.print("/");
		System.out.print(n);
		System.out.println(".");
	}
}