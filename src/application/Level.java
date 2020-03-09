package application;

import java.io.IOException;
import java.util.ArrayList;



public class Level {

	private int levelNumber;
	private String levelIntroText, levelExitText;
//	private ArrayList<Prop> props;
	private ArrayList<Puzzle> puzzles;
//	private ArrayList<Cipher> ciphers;
//	private ArrayList<Trigger> triggers; 
//	private Door door;
//	private int playerStartX, playerStartY;	
	
	public Level(int lNum) {
		
		levelNumber = lNum;
		// iterates over String array to add story, level description text elements to level
		// can be used for specific level children where they have level specific methods
		levelIntroText = getLevelIntroText(lNum);
		levelExitText = getLevelOutroText(lNum);
		puzzles = getPuzzles(lNum);
	}
	
	
	
	private String getLevelIntroText(int lvlNum) {
		String introTxt = "";
		switch(lvlNum) {
		case 1:
			introTxt = "Although you have solved many murder cases in the past, you have stumbled upon a rather tricky one.\r\n" + 
					"			It's high-profile: the woman deceased was of great wealth, and a disturbing note was left at the crime \r\n" + 
					"			scene. It may appear to be a suicide at first glance, but it is far too suspicious. Scarlett Johansson \r\n" + 
					"			was envied for her wealth and fame, and she had inherited a rather fortunate business from her father \r\n" + 
					"			before he passed. Her three children, and many others, all seemed too eager for a piece of her fortune \r\n" + 
					"			and notorety. Who killed Scarlett?\\n\\n\r\n" + 
					"			You must leave no stone unturned as you try to solve this crime and figure out what really happened to Scarlett.";
			break;

		case 2:
			introTxt = "We know that Huey, Dewey and Louie are suspects. But now we have added Chris to the roster, and Huey\r\n" + 
					"and Dewey and Louie could have either known or not known that she was giving him her fortune... things\r\n" + 
					"are getting messy. Now that you have a sneaking suspicion that Chris may be responsible, you need to\r\n" + 
					"search for any clues that pertain to him.";
			break;
		case 3:
			introTxt = "You enter the last room and you see where Scarlett's body was found outlined in tape on the floor. \r\n" + 
					"You have 2 suspects left. Narrow it down to the murderer to escape.";
			break;
		}
		
		return introTxt;		
	}
	
	
	
	private String getLevelOutroText(int lvlNum) {
		String outroTxt = "";
		switch(lvlNum) {
		case 1:
			outroTxt = "We know that Huey, Dewey and Louie are suspects. But now we have added Chris Evans to the roster, and Huey and Dewey\r\n" + 
					"and Louie could have either known or not known that she was giving him her fortune. Things are getting messy. \r\n" + 
					"\r\n" + 
					"Now that you have a sneaking suspicion that Chris may be responsible, you need to search for any clues that pertain to him.";
			break;

		case 2:
			outroTxt = "Congratulations you have escaped from the second room but are many more rooms to escape \r\n" + 
					"to solve the mystery!";
			break;
		case 3:
			outroTxt = "The case is solved and you managed to uncover the murderer in an impressive amount of time. This\r\n" + 
					"should prevent any misconstrued headlines in the newspaper and now you have the evidence to prove\r\n" + 
					"Louie is guilty when he is put on trail for the murder of his own mother, Scarlett Johansson. \r\n" + 
					"Congratulations!";
			break;
		}		
		return outroTxt;		
	}
	
	private ArrayList<Puzzle> getPuzzles(int lvlNum){
		ArrayList<Puzzle> puzList = new ArrayList<Puzzle>();
		switch(lvlNum) {
		case 1:
			Puzzle puzzle1_1 = new Puzzle(0, 0, "Scarlett has 3 children with her husband Brad Pitt, who passed away only a year ago in a horrible plane accident. \r\n" + 
					"He was on a business trip and extreme weather conditions overthrew the plane's course as it crashed into a forested area\r\n" + 
					"and burned. Her children, Huey, Dewey and Louis are all married and living in the city, but they would visit Scarlett in\r\n" + 
					"the country from time to time for her lavish parties and special occasions or holidays. The night of Scarlett's death, \r\n" + 
					"she had thrown an extravagant party which was the perfect occasion for her children to be visiting. \r\n" + 
					"\r\n" + 
					"Wait \r\n" + 
					"\r\n" + 
					"'Is this a party invitation? What's wrong with it?'\r\n" + 
					"\r\n" + 
					"enw ryaes vee \r\n" + 
					"\r\n" + 
					"Unscramble the words and enter the answer below:", 
					
					"New Years Eve");
			Puzzle puzzle1_2 = new Puzzle(0,0,"You kept looking through the desk and found a drawer with a safe in it. Shoot! It's locked. If only the code was written \r\n" + 
					"somewhere. a ha! It is. Maybe? This is a 4 number code but you see a note with 8 numbers on it…. Maybe this is some kind \r\n" + 
					"of a key. \r\n" + 
					"\r\n" + 
					"2  1  3  2  7  1  4  2 ", 
					
					"2678");
			puzList.add(puzzle1_1);
			puzList.add(puzzle1_2);
			break;

		case 2:
			Puzzle puzzle2_1 = new Puzzle(0,0, "You find a file cabinet that is locked with a pass code. On it is inscribed:\r\n" + 
					"If Two's Company, and Three's a Crowd What are Four AND Five?\r\n" + 
					"Solve the riddle to open the file cabinet.", "9");
			Puzzle puzzle2_2 = new Puzzle(0,0, "One door remains, and it leads to the room Scarlett died in. The murder weapon or other vital evidence\r\n" + 
					"that would pinpoint the suspect could be behind that door. But the door is locked with what appears \r\n" + 
					"to be a tiny computer puzzle. It reads the following:\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"1 0 1 0   1 1 0 0   1 1 1 0\r\n" + 
					"Password: ___ ___ ___\r\n" + 
					"Hint: convert to hexadecimal", "ace");
			puzList.add(puzzle2_1);
			puzList.add(puzzle2_2);
			break;
		case 3:
			Puzzle puzzle3_1 = new Puzzle(0,0, "The last thing you see is a hand written note that pokes out of the bookshelf near where you found the diary. \r\n" + 
					"It reads:                \r\n" + 
					"These numbers spell a word 411391287\r\n" + 
					"CLUE: 91968968 = NONSENSE\r\n" + 
					"*Hint: It might help to say the numbers in the clue out loud or in your head while you look at the word nonsense*", "Footnotes");
			Puzzle puzzle3_2 = new Puzzle(0,0, "To get out of this room and bring Scarlett's death justice, you must have this case completely cracked...\r\n" + 
							"Enter the Murder's First Name below to escape and solve the mystery.", "Louie");
			puzList.add(puzzle3_1);
			puzList.add(puzzle3_2);
			break;
		}		
		
		return puzList;
	}
	
	public Puzzle getPuzzle(int puzzleNum) {
		Puzzle tPuzzle;
		tPuzzle = new Puzzle(puzzles.get(puzzleNum - 1));
		return tPuzzle;
	}

}
