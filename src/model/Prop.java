package model;

public class Prop extends GameObject{//Prop class inherited from GameObject class
	
	/**
	 *
	 * The Prop class creates objects on the map for the player to interact with.
	 * These prop objects contain important storyline information which will help better the 
	 * user's undertsanding of the storyline and provide them with important hints and information to 
	 * win the game. The intention of the props is to add more atmosphere to the game while remaining purposeful. 
	 *
	 */

	/**
	 * This is the copy contructor for Prop.
	 *
	 * @param prop Prop object to be copied
	 */
	public Prop(Prop prop)
	{
		super(prop);
	}
	
	/**
	 * The Prop object constructor
	 * To help place the prop in the respective location and give it the relative decription.
	 * @param des prop description text
	 * @param x integer representing x position
	 * @param y integer representing y position
	 */
	public Prop(String des, int x, int y) {
		super(x,y,des);
	} 
	
	
	/**
	 * The getDescription method is a getter method which retrieves the prop description string.
	 * The prop requires a description for the user to read so that it maintains a purpose.
	 *
	 * @return string representing the description of the Prop object
	 */
//	public String getDescription() {
//		return description;
//	}
//	
//	/**
//	 * The getX methos is a getter method to retrive a prop's x-value.
//	 * The x-value is required to give the prop it's x position on the level map.
//	 * @return int X position
//	 */
//	public int getX() {
//		return super.getX();//Call parent class Getter method
//	}
//	
//	/**
//	 * The getY methos is a getter method to retrive a prop's y-value.
//	 * The y-value is required to give the prop it's x position on the level map.
//	 * @return int Y position
//	 */
//	public int getY() {
//		return super.getY();
//	}	//Call parent class Getter method
}
