package application;
import java.util.Scanner;

public class Puzzle {
	
	/**
	 * 		Puzzle Class
	 * 		Players solve puzzles and by solving puzzles
	 * 		are able to unlock the level door to move on to the next level.
	 */
	
	
	/**
	 * 	Puzzle attributes including the question and answer strings,
	 * 	boolean solved, and x,y coordinates for when we do collisions and
	 *  hit detection.
	 */
	private boolean solved;
	private int xPos;
	private int yPos;
	private String question, answer;
	
	/**
	 * Puzzle copy constructor
	 * @param p Puzzle to be copied
	 */
	public Puzzle(Puzzle p) {
		this.answer = p.answer ;
		this.question = p.question;
		this.xPos = p.xPos;
		this.yPos = p.yPos;
		this.solved = p.solved;
	}
	
	/**
	 * Puzzle class constructor
	 * @param _x int for puzzles x value
	 * @param _y int for puzzles y value
	 * @param q String for puzzle's question
	 * @param a String for puzzle's answer
	 */
	public Puzzle(int _x,int _y,String q,String a) {
		this.xPos = _x;
		this.yPos = _y;
		this.question = q;
		this.answer = a;
		solved = false;
	}
	
	/**
	 * checkAns is helper method to check answer.
	 * @param tempAns String representing users answer
	 * @return boolean if answer is correct
	 */
	private boolean checkAns(String tempAns) {
		return tempAns.equalsIgnoreCase(answer);
	}
	
	/**
	 *  isSolved is a getter to check if puzzle is solved
	 * @return boolean true if puzzle is solved
	 */
	public boolean isSolved() {
		return solved;
	}
	
	/**
	 * getX getter for puzzles x position on map (not currently implemented)
	 * @return integer of puzzle's x position (will change to double for GUI)
	 */
	public int getX()
	{
		return xPos;
	}	
	
	/**
	 *  getY getter for puzzles y position on map
	 * @return integer of puzzle's y position (will change to double for GUI)
	 */
	public int getY() {
		return yPos;
	}
	
	/**
	 * getQuestion getter for puzzle question
	 * @return String of puzzles question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * getAnswer is a getter for puzzle answer
	 * @return string of puzzle's answer
	 */
	public String getAnswer() {
		return answer;
	}
	
	
	/**
	 *  setSolved is a setter to set the puzzle as solved
	 */
	public void setSolved() {
		solved = true;
	}
	
	
}
