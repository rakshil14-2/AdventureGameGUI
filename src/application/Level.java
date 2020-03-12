package application;
import java.util.ArrayList;


/**
 * 	Level class
 * 	
 * 	Currently contains the objects in the level
 * 	Plan to implement more for the next demo 
 * 
 */
public class Level {

	/**
	 *  attributes for the current game objects of the GUI version of the game,
	 *  level number, intro and outro text, props, and puzzles
	 */
	private int levelNumber;
	private String levelIntroText, levelExitText;
	private ArrayList<Prop> props;
	private ArrayList<Puzzle> puzzles;

	/**
	 * Level constructor
	 * @param lNum integer representing level number
	 */
	public Level(int lNum) {
		
		levelNumber = lNum;
		// iterates over String array to add story, level description text elements to level
		// can be used for specific level children where they have level specific methods
		levelIntroText = getLevelIntroText(lNum);
		levelExitText = getLevelOutroText(lNum);
		puzzles = getPuzzles(lNum);
		props = getProps(lNum);
	}
	
	
	/**
	 * getLevelIntroText is a private method to generate the introduction text for the levels
	 * @param lvlNum integer representing the level number
	 * @return String containing the level's intro text
	 * 
	 */
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
	
	
	/**
	 * 	getPuzzles method returns arraylist of puzzles for each level
	 * 	@param lvlNum integer represeting level number
	 *  @return ArrayList of Puzzles for level
	 */
	private ArrayList<Puzzle> getPuzzles(int lvlNum){
		ArrayList<Puzzle> puzList = new ArrayList<Puzzle>();
		switch(lvlNum) {
		case 1:
			Puzzle puzzle1_1 = new Puzzle(0, 0, "Scarlett has 3 children with her husband Brad Pitt, who passed \r\n" + 
					"away only a year ago in a horrible plane accident.He was on a business trip and extreme weather \r\n" + 
					"conditions overthrew the plane's course as it crashed into a forested area and burned. Her children, Huey, \r\n" + 
					"Dewey and Louis are all married and living in the city, but they would visit Scarlett in the country \r\n" + 
					"from time to time for her lavish parties and special occasions or holidays. The night of Scarlett's death, \r\n" +
					"she had thrown an extravagant party which was the perfect occasion for her children to be visiting. \r\n"+
					"\r\n" + 
					"Wait \r\n" + 
					"\r\n" + 
					"'Is this a party invitation? What's wrong with it?'\r\n" + 
					"\r\n" + 
					"enw ryaes vee \r\n" + 
					"\r\n" + 
					"Unscramble the words and enter the answer below:", 
					
					"New Years Eve");
			Puzzle puzzle1_2 = new Puzzle(0,0,"You kept looking through the desk and found a drawer with a safe in it. Shoot! \r\n" + 
					"It's locked. If only the code was written somewhere. a ha! It is.  \r\n"+
					"Maybe? This is a 4 number code but you see a note with 8 numbers on it…. Maybe this is some kind \r\n" + 
					"of a key. \r\n" + 
					"\r\n" + 
					"2  1  3  2  7  1  4  2 ", 
					
					"2678");
			Puzzle puzzle1_3 = new Puzzle(0,0, "You open a drawer of Scarlett's desk and find some financial documents...\n"
					+ " It looks right before Scarlett died, she changed her will so her entire fortune would go to \n"
					+ "someone she had just met 2 weeks prior - her new romantic partner that she just began \r\n" + 
					" seeing.\n"
					+ "He was probably at the party too, but the only way to find out is to translate the \n"
					+ "cipher that shows his name on this paper.\n\n"
					+ "The hint is 'EJTKU'. And the algorithm is X(alphabetic index)-2.",
					"Chris");
			puzList.add(puzzle1_1);
			puzList.add(puzzle1_2);
			puzList.add(puzzle1_3);
			break;

		case 2:
			Puzzle puzzle2_1 = new Puzzle(0,0, "You find a file cabinet that is locked with a pass code. On it is inscribed:\r\n" + 
					"If Two's Company, and Three's a Crowd What are Four AND Five?\r\n" + 
					"Solve the riddle to open the file cabinet.", "9");
			Puzzle puzzle2_2 = new Puzzle(0,0, "One door remains, and it leads to the room Scarlett died in. \r\n" + 
					"The murder weapon or other vital evidence that would pinpoint the suspect could be behind that door.\r\n" + 
					" But the door is locked with what appears to be a tiny computer puzzle. It reads the following:\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"1 0 1 0   1 1 0 0   1 1 1 0\r\n" + 
					"Password: ___ ___ ___\r\n" + 
					"Hint: convert to hexadecimal", "ace");
			puzList.add(puzzle2_1);
			puzList.add(puzzle2_2);
			break;
		case 3:
			Puzzle puzzle3_1 = new Puzzle(0,0, "The last thing you see is a hand written note that pokes out of the bookshelf near\n"
					+ "where you found the diary.\r\n" + 
					"It reads:                \r\n" + 
					"These numbers spell a word 411391287\r\n" + 
					"CLUE: 91968968 = NONSENSE\r\n" + 
					"*Hint: It might help to say the numbers in the clue out loud or in your head\n"
					+ "while you look at the word nonsense*", "Footnotes");
			Puzzle puzzle3_2 = new Puzzle(0,0, "To get out of this room and bring Scarlett's death justice, you must have this case completely cracked...\r\n" + 
							"Enter the Murder's First Name below to escape and solve the mystery.", "Louie");
			puzList.add(puzzle3_1);
			puzList.add(puzzle3_2);
			break;
		}		
		
		return puzList;
	}
	
	
	/**
	 * 	getProps method is a helper method to generate the levels props
	 * 	@param lvlNum integer representing level number
	 * 	@return ArrayList of Props for the level
	 */
	private ArrayList<Prop> getProps(int lvlNum){
		ArrayList<Prop> propList = new ArrayList<Prop>();
		switch(lvlNum) {
		case 2:
			Prop prop2_1 = new Prop("You pick up the phone and give the voicemails a listen.\r\n" + 
					"'This is the hospital calling. It's 10:00pm. Hewey has been in a serious car accident on the main highway, \r\n" + 
					"and we are taking him into surgery right now. Please contact us at the hospital as soon as possible'\r\n" + 
					"\r\n" + 
					"Hewey left at 10:00pm! The murder was not until at least midnight according to our autopsy report. This \r\n" + 
					"eliminates Hewey as a suspect.", 0, 0);
			propList.add(prop2_1);
			Prop prop2_2 = new Prop("In the file cabinet you find Dewey's medical documents... and you realize Dewey has been in a coma for 17 \r\n" + 
					"days! This completely eliminates Dewey as a suspect.", 0,0);
			propList.add(prop2_2);
			break;

		case 3:
			Prop prop3_1 = new Prop("You begin sifting through the bookshelf for any traces of evidence when you pull out Scarlett's diary.\r\n" + 
					"In her most recent entry before her passing, she wrote:\r\n" + 
					"\r\n" + 
					"December 13th, 1989\r\n" + 
					"I know what is going to happen to me, and I know who will do it. My children do not visit anymore. \r\n" + 
					"They only want what I have. I am changing my will to go to Chris, his family is in dire need of financial aid.\r\n" + 
					"My children are going to be furious when I tell them, but they should earn their own place. \r\n" + 
					"                                                        -Scarlett Johansson\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"This information is incredibly revealing. Scarlett claims to have willingly changed her inheritance to go to \r\n" + 
					"Chris, but there's no proof that this was her true motive or whether or not there had been any outside pressures\r\n" + 
					"making her say this. Also, who is to say they Louie even knew that she had changed it? Or who is to say that he\r\n" + 
					"did not know? Louie could have known and murdered out of anger, or Louie could have not known, and murdered in\r\n" + 
					"hopes of inheriting a fortune.", 0, 0);
			Prop prop3_2 = new Prop("Footnotes... what could it mean? You start to retrace your steps and remember there was a footnote on the financial\r\n" + 
					"documents that contained Scarlett's will. You open up your files to read the document again and on the very last\r\n" + 
					"page there is a footnote that only contains the letter 'L'. It is subtle, easy to miss, but it is right under the\r\n" + 
					"passage where Scarlett declared her fortune will no longer be going to her sons.\r\n" + 
					"Head to the final door to attempt your escape.", 0, 0);
			propList.add(prop3_1);
			propList.add(prop3_2);
			break;
		}		
		
		return propList;
		
	}
	
	/**
	 * 	getPuzzle method generates the levels puzzles
	 * 	@param puzzleNum integer representing the puzzle in the array
	 * 	@return Puzzle object
	 */
	public Puzzle getPuzzle(int puzzleNum) {
		Puzzle tPuzzle;
		tPuzzle = new Puzzle(puzzles.get(puzzleNum - 1));
		return tPuzzle;
	}
	
	/**
	 *  getProp method generates the levels props
	 *  @param propNum integer representing the prop in the array
	 *  @return Prop object
	 */	
	public Prop getProp(int propNum) {
		Prop tProp;
		tProp = new Prop(props.get(propNum -1));
		return tProp;
	}
	
}
