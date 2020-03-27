README.txt

I. How To Download:
-------------------
	AdventureGameGUI.java source files can ba downloaded from:
		https://github.com/pkohoutek/AdventureGameGUI

	Source code is all located in the Project /src folder.
	The package application in the /src ffolder contains all the classes and the
	other necessary files (mostly jpgs,pngs and fxml files) are not in the package
	but are in the /src folder.


II-A. How To Run in Eclipse:
-------------------
	OpenJavaFX and software is needed to run the program in Eclipse. Follow the guide here:
		https://openjfx.io/openjfx-docs/#IDE-Eclipse
	
	To get Java 12 support, install the patch from the Eclipse MarketPlace: Java 12 Support for Eclipse 2019-03 (4.11).

	Download an appropriate JDK (version 8 or above) for your operating system and set JAVA_HOME to the JDK directory.

	Include the new JDK as Installed JREs in Eclipse -> Preferences -> Java -> Installed JREs -> Add.
		
	Download the appropriate JavaFX SDK for your operating system and unzip it to a desired location, for instance /Users/your-
	user/Downloads/javafx-sdk-14. Download JavaFX here: https://gluonhq.com/products/javafx/
	
	Create a new User Library under Eclipse -> Window -> Preferences -> Java -> Build Path -> User Libraries -> New.
	
	Name it JavaFX14 and include the jars under the lib folder from JavaFX 14.
	
	Add VM Argument in Eclipse. Click on Run -> Run Configurations...  -> Java Application, create a new launch configuration for the project and add these VM arguments:
		Linux/Mac:
			--module-path /path/to/javafx-sdk-14/lib --add-modules javafx.controls,javafx.fxml
		Windows:
			--module-path "\path\to\javafx-sdk-14\lib" --add-modules javafx.controls,javafx.fxml
	
	Now you can run the project from Eclipse.

II-B. How To Compile:
-------------------
	OpenJavaFX software is needed to run the program. Install here:
		https://openjfx.io/openjfx-docs/#install-java
	
	Add an environment variable pointing to the lib directory of the runtime
	using the terminal or the command prompt:

	Linux/Mac:
		export PATH_TO_FX=path/to/javafx-sdk-14/lib
	Windows:
		set PATH_TO_FX="path\to\javafx-sdk-14\lib"

	You can now compile and run JavaFX applications from the command line using
	the JavaFX runtime.

	Linux/Mac:
		To compile AdventureGameGUI run the following in the terminal:
			javac --module-path $PATH_TO_FX --add-modules javafx.controls,
			javafx.fxml Main.java

	Windows:
		To compile AdventureGameGUI run the following in the command prompt:
			javac --module-path %PATH_TO_FX% --add-modules javafx.controls,
			javafx.fxml Main.java
	To Run:
	
	Linux/Mac:
		To run AdventureGameGUI run the following in the terminal:
			java --module-path $PATH_TO_FX --add-modules javafx.controls,
			javafx.fxml AdventureGameGUI

	Windows:
		To run AdventureGameGUI run the following in the command prompt:
			java --module-path %PATH_TO_FX% --add-modules javafx.controls,
			javafx.fxml AdventureGameGUI
			
--------------------------------------
IV. Files Included With This Project:
--------------------------------------

Files in this project are seperated into packages:

	Package 1: application 
		* Main.java
		* application.css

	Package 2: controller
		* GameOverController.java
		* Level1Controller.java
		* Level2Controller.java
		* Level3Controller.java
		* MainMenuController.java
		* PropController.java
		* PuzzleController.java

	Package 3: model

		* GameClock.java
		* Level.java
		* Prop.java
		* Puzzle.java

	Package 4: photos

		* ComboLock.png	
		* Diary.jpg
		* Diary.png
		* Door.png
		* Footenote.png
		* GameOver.jpg
		* Invitation.png
		* KeypadLock.png
		* Knife.png
		* MedicalDoc.png
		* Note.png
		* Paper.png
		* Phone.png
		* QuestionMark.jpg
		* SecurityCode.png
		* Solved.jpg
		* Telephone.png
		* down.png
		* left.png
		* mansion.jpg
		* medical.jpg
		* right.png
		* safeLock.jpg
		* squibbles.png
		* will.jpg

	Package 5: view

		* CharacterMovement.java
		* GameOver.fxml
		* Home.fxml
		* Level1.fxml
		* Level2.fxml
		* Level3.fxml
		* MainMenu.fxml
		* Prop.fxml
		* PropWindow.java
		* Puzzle.fxml
		* PuzzleWindow.java
		* Won.fxml

	Other files:

		* .classpath
		* .project
		* build.fxbuild
		* README.MD
		* README.txt

-------------
V. Libraries:
-------------

The program uses open javafx 12. The program AdventureGameGUI will not compile/run on
devices that do not use open javafx.

-----------------------------------
VI. Game Description + Information:
-----------------------------------

AdventureGameGUI is a adventure game where you are trapped in a room playing in the
role of a detective trying to solve a murder mystery. Various props and puzzles will
provide clues and must be solved in order to escape and win the game.

-------------
VII. Classes:
-------------
CharacterMovement: 
	moves an avatar in the window​
GameClock: 
	checks time and gives you the time you have left finish the game ​
GameOverController: 
	changes scene back to main menu after clock runs out​
Level: 
	contains all intro texts, props and puzzles​
Level1Controller: 
	handles image clicks and checks that the puzzles in level 1 are all solved 
	before allowing door to open and begin level 2​
Level2Controller: 
	handles image clicks and checks that the puzzles in level 2 are all solved 
	before allowing door to open and begin level 3​
Level3Controller: 
	handles image clicks and checks that the puzzles in level 3 are all solved 
	before allowing user to go to winning scene​
Main: 
	opens an fxml file called main​
Main Menu Controller: 
	handles button clicks and changes the scene​
Prop: 
	an object with an x,y value and a description​
Prop Controller: 
	gets the prop object images and text​
Prop Window: 
	when prop button is clicked opens a new window with prop description and 
	image​
Puzzle: 
	an object with an x,y value, question and answer​
Puzzle Controller: 
	gets the puzzle question, answer and handles user input from the text field
	to check if it is solved​
Puzzle Window: 
	when puzzle button is clicked opens a new window with a question and text 
	field for user to input their answer

-------------------
VIII. Contributors:
-------------------

Program written by:

	Group 9 ~ Tutorial 2
	
	Paul
	Azhar
	Carlo
	Delara
	Claire 

		for CPSC 233 Project, Winter Semester 2020.

​

