package model;

public abstract class GameObject {//Declare Abstract Class GameObject
    protected int xPos = 0;//Declare and initialize xpos Variable
    protected int yPos = 0;//Declare and initialize ypos Variable
    private String text;
    public GameObject(int x,int y,String t) {
    	this.xPos = x;
    	this.yPos = y;
    	this.text = t;
    }
    public GameObject(GameObject g) {
    	this.xPos=g.xPos;
    	this.yPos = g.yPos;
    	this.text=g.text;
    }
    public int getY()//Getter Method for ypos Variale
    {
        return yPos;//Return ypos Variable
    }
    public int getX()//Getter Method for xpos Variale
    {
        return xPos;//Return xpos Variable
    }
    public String getText() {
    	return this.text;
    }
}
