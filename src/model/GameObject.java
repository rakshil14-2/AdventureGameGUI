package model;


public abstract class GameObject {//Declare Abstract Class GameObject
	/**
	 * GameObject is a abstract class,
	 * Which is a parent class of prop and puzzle.
	 * it has all the instance variables of prop and puzzle
	 * 
	 */
	
    private int xPos = 0;//Declare and initialize xpos Variable
    private int yPos = 0;//Declare and initialize ypos Variable
    private String text;//Declare text Variable
    
    
    
    
    /**
	 * The GameObject object constructor
	 * To help place the prop and puzzle in the respective location and give them the relative decription and answer.
	 * @param t prop description text and Question for puzzle
	 * @param x integer representing x position
	 * @param y integer representing y position
	 */
    public GameObject(int x,int y,String t) {
    	this.xPos = x;
    	this.yPos = y;
    	this.text = t;
    }
    
    
    
    
    /**
	 * This is the copy constructor for GameObject.
	 *
	 * @param g GameObject object to be copied
	 */
    public GameObject(GameObject g) {
    	this.xPos=g.xPos;
    	this.yPos = g.yPos;
    	this.text=g.text;
    }
    
    
    
    
    /**
     * Getter Method for ypos variable
     * @return ypos variable
     */
    public int getY()
    {
        return yPos;
    }
    
    
    
    
    
    /**
     * Getter Method for xpos variable
     * @return xpos variable
     * 
     * */
    public int getX()
    {
        return xPos;
    }
    
    
    
    
    
    /**
     * Getter Method for text Variale
     * @return text Variable
     * 
     * */
    public String getText() {
    	return this.text;
    }
}




