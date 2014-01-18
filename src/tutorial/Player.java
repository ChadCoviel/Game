package tutorial;
//import tutorial.Example2;
import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class Player extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;
	private int xpos;
	private int ypos;
	
//	Player(String name,boolean multiple,double x,double y, int ID, String animation,
//			StdGame eng){
//		super(name, //The name of the object (the player)
//				multiple, //Allows for multiple objects of same name
//				x,  // X position
//				y, // Y Position 
//				1, //Collision ID
//				animation); //name of sprite/animation
//		myEngine = eng;
//	}
	
	public Player(double x, double y, double speed, StdGame eng){
		super("player",true,x,y,1,null, 0,0,32,16,0,0,speed,speed,-1);
		myEngine = eng;
	}
	
	/** Draw the object. */
	public void paint() {
		// Draw a yellow ball
		myEngine.setColor(JGColor.yellow);
		myEngine.drawOval(x,y,16,16,true,true);
	}
	
//	//Manually moving the character
//	private void move(){
//		
//	}
	
//	/** Handle collision with other objects. Called by checkCollision. */
//	private void hit(JGObject obj) {
//		if (checkCollision() {
//			// reverse direction
//
//		}
//	}
	
	public void move(){
		setDir(0,0);
		if (myEngine.getKey(myEngine.key_up)    && y > yspeed)               ydir=-1;
		if (myEngine.getKey(myEngine.key_down)  && y < myEngine.pfHeight()-16-yspeed) ydir=1;
		if (myEngine.getKey(myEngine.key_left)  && x > xspeed)               xdir=-1;
		if (myEngine.getKey(myEngine.key_right) && x < myEngine.pfWidth()-32-yspeed)  xdir=1;
		//super.move();
		//whatever code you need
		
	}
}