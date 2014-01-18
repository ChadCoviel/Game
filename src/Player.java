//import tutorial.Example2;
import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class Player extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private JGEngine engine;
	
	Player(String name,boolean multiple,double x,double y, int ID, String animation){
		super(name, //The name of the object (the player)
				multiple, //Allows for multiple objects of same name
				x,  // X position
				y, // Y Position 
				1, //Collision ID
				animation); //name of sprite/animation
	}
	
	/** Draw the object. */
//	public void paint() {
//		// Draw a yellow ball
//		engine.setColor(JGColor.yellow);
//		engine.drawOval(x,y,16,16,true,true);
//	}
	
	//Manually moving the character
	public void move(){
		
	}
	
	/** Handle collision with other objects. Called by checkCollision. */
	public void hit(JGObject obj) {
		if (checkCollision() {
			// reverse direction

		}
	}
}
