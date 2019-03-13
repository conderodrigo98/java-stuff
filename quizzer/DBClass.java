package quiz;

import java.io.* ;
import java.util.*;

public class DBClass{
	private ArrayList<String> questions = new ArrayList<String>(0);
	private ArrayList<String> correctAnswers = new ArrayList<String>(0);
	private int size = 0;

	public DBClass(){
		try{
			Scanner inFile = new Scanner(new FileInputStream("questions.txt"));	
			while(inFile.hasNextLine()){
				this.questions.add(inFile.nextLine());
				this.size ++;	
			}
			inFile.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Missing File.");
		}
		try{
			Scanner inFile2 = new Scanner(new FileInputStream("correctAnswers.txt"));	
			while(inFile2.hasNextLine()){
				this.correctAnswers.add(inFile2.nextLine());	
			}
			inFile2.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Missing File.");
		}
	}

	public int getSize(){
		return this.size;
	}
	public String getQuestion(int i){

		return this.questions.get(i);
	}
	public String getAnswer(int i){
		return this.correctAnswers.get(i);
	}
}