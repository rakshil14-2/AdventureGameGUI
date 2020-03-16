package model;

public class Prop {
	
	
	/**
	 * 		Prop Class
	 * 		creates objects on the map for the player to interact with.
	 * 		Typically in game development props are non-interactive but due to
	 * 		the limitation of a text game props are interactive to add more atmosphere to game
	 */
	
	/**
	 * 	Prop class attributes
	 * 	xPos/yPos for interaction on map once collision detection is implemented
	 * 	description is a string containing the props text
	 */
	private int xPos = 0;
	private int yPos = 0;
	private String description  = "Put object descriptive text here."
			+ "\n eg. \"You look at an old oak bookcase, you note that it is"
			+ " full of books on the ocult.";



	/**
	 * prop copy constructor
	 * @param prop Prop object to be copied
	 */
	public Prop(Prop prop)
	{
		xPos = prop.getX();
		yPos = prop.getY();
		description = prop.getDescription();	
	}
	
	
	/**
	 *  Prop object constructor
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
	 * getDescription gets prop description string
	 * @return string representing the description of the Prop object
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 *  getX getter for prop x value
	 * @return int X position
	 */
	public int getX() {
		return xPos;
	}
	
	/**
	 * getY getter for prop y value
	 * @return int Y position
	 */
	public int getY() {
		return yPos;
	}
	
	

	
}
