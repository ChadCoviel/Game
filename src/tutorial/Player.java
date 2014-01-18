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
	
	Player(String name,boolean multiple,double x,double y, int ID, String animation,
			StdGame eng){
		super(name, //The name of the object (the player)
				multiple, //Allows for multiple objects of same name
				x,  // X position
				y, // Y Position 
				1, //Collision ID
				animation); //name of sprite/animation
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
		if(myEngine.getKey(myEngine.KeyLeft));
		myEngine.getKey(myEngine.KeyRight);
		myEngine.getKey(myEngine.KeyDown);
		myEngine.getKey(myEngine.KeyUp);
		//whatever code you need
		
	}
}