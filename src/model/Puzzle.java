package model;
import java.util.Scanner;

public class Puzzle extends GameObject{//Puzzle class inherited from GameObject class
	
	/**
	 * The Puzzle Class
	 * Players solve puzzles to play the game, and by solving puzzles are able to 
	 * unlock the level door to move on to the next level. Every puzzle in a level has to be solved 
	 * before the door can be unlocked. This class gets the questions and answers for the puzzles 
	 * and checks that they are solved.
	 */
	
	
	//boolean solved is to check if a puzzle is solved
	private boolean solved;
	//puzzle question and answer strings
	private String  answer;
	
	
	/**
	 * This is the Puzzle copy constructor.
	 * @param p is a Puzzle to be copied.
	 */
	public Puzzle(Puzzle p) {
		super(p);
		this.answer = p.answer ;
		this.solved = p.solved;
	}
	
	/**
	 *Puzzle class constructor
	 * @param _x is an int for a puzzle's x value.
	 * @param _y is an int for a puzzle's y value.
	 * @param q is a String for a puzzle's question.
	 * @param a is a String for a puzzle's answer.
	 */
	public Puzzle(int _x,int _y,String q,String a) {
		super(_x,_y,q);
		this.answer = a;
		solved = false;
	}
	
	
	/**
	 * isSolved is a getter method which to checks if a puzzle is solved.
	 * @return boolean solved (true if puzzle is solved).
	 */
	public boolean isSolved() {
		return solved;
	}
	
//	/**
//	 * The getX method is a getter for a puzzle's x position on the level map.
//	 * @return integer of the puzzle's x position.
//	 */
//	public int getX()
//	{
//		return super.getY();
//	}//Call parent class Getter method
//	
//	/**
//	 * The getY method is a getter for a puzzle's y position on the level map.
//	 * @return integer of the puzzle's y position.
//	 */
//	public int getY() {
//		return super.getY();
//	}//Call parent class Getter method
//	
//	/**
//	 * The getQuestion method is a getter for a puzzle question.
//	 * The question for each puzzle has a correct answer.
//	 * @return String of puzzles question
//	 */
//	public String getQuestion() {
//		return question;
//	}
//	
	/**
	 * The getAnswer method is a getter for a puzzle answer.
	 * The answer matches with a given puzzle question.
	 * The answer the user inputs has to match tghis answer for a puzzle in order to solve
	 * the puzzle and advance in the game.
	 *
	 * @return string of puzzle's answer
	 */
	public String getAnswer() {
		return answer;
	}
	
	
	/**
	 * The setSolved method is a setter to set the puzzle as solved.
	 */
	public void setSolved() {
		solved = true;
	}	
}
