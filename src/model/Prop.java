package model;

public class Prop {
	
	/**
	 *
	 * The Prop class creates objects on the map for the player to interact with.
	 * These prop objects contain important storyline information which will help better the 
	 * user's undertsanding of the storyline and provide them with important hints and information to 
	 * win the game. The intention of the props is to add more atmosphere to the game while remaining purposeful. 
	 *
	 */

	// xPos/yPos for interaction on map once collision detection is implemented
	private int xPos = 0;
	private int yPos = 0;
	// description is a string containing the props text
	private String description  = "Put object descriptive text here."
			+ "\n eg. \"You look at an old oak bookcase, you note that it is"
			+ " full of books on the ocult.";

	/**
	 * This is the copy contructor for Prop.
	 *
	 * @param prop Prop object to be copied
	 */
	public Prop(Prop prop)
	{
		xPos = prop.getX();
		yPos = prop.getY();
		description = prop.getDescription();	
	}
	
	/**
	 * The Prop object constructor
	 * To help place the prop in the respective location and give it the relative decription.
	 * @param des prop description text
	 * @param x integer representing x position
	 * @param y integer representing y position
	 */
	public Prop(String des, int x, int y) {
		xPos = x;
		yPos = y;
		description = des;	
	} 
	
	
	/**
	 * The getDescription method is a getter method which retrieves the prop description string.
	 * The prop requires a description for the user to read so that it maintains a purpose.
	 *
	 * @return string representing the description of the Prop object
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * The getX methos is a getter method to retrive a prop's x-value.
	 * The x-value is required to give the prop it's x position on the level map.
	 * @return int X position
	 */
	public int getX() {
		return xPos;
	}
	
	/**
	 * The getY methos is a getter method to retrive a prop's y-value.
	 * The y-value is required to give the prop it's x position on the level map.
	 * @return int Y position
	 */
	public int getY() {
		return yPos;
	}			
}
