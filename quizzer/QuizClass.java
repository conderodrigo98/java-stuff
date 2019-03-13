package quiz;

import quiz.*;
import java.util.*;

public class QuizClass{
	private String[] questions;
	private String[] correctAnswers;
	private String[] answers;
	private DBClass db;

	public QuizClass(int n){
		this.questions = new String[n];
		this.correctAnswers = new String[n];
		this.answers = new String[n];
		db = new DBClass();
		if(n > db.getSize()){
			throw new IndexOutOfBoundsException("The number must be lower than the current amount of questions in the database.");
		}
		Random rand = new Random();
		Set<Integer> indexes = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int index = rand.nextInt(db.getSize());
			while(indexes.contains(index)){
				index = rand.nextInt(db.getSize());
			}
			this.questions[i] = db.getQuestion(index);
			this.correctAnswers[i] = db.getAnswer(index);
			indexes.add(index);
		}
	}

	public String getQuestion(int i){
		return this.questions[i];
	}
	public void setAnswer(int i, String ans){
		this.answers[i] = ans;
	}
	public int getScore(){
		int score = 0;
		for(int i = 0; i < this.questions.length; i++){
			if(this.answers[i].equals(this.correctAnswers[i])){
				score++;
			}
		}
		return score;
	}
}