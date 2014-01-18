

//import tutorial.Example2;
import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class BlackStar extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;
//	private int xpos;
//	private int ypos;
	
//	myEngine.defineImage(
//			"ball", // graphic name
//			"-", 0, // tile name and tile cid (in case we use it as a tile)
//			"ball20-red.gif", // file
//			"-" // graphical operation (may be one or two out of
//			    //"x","y", "l","r","u")
//		);
	
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
	
	public BlackStar(double x, double y, double speed, StdGame eng){
		super("BlackStar",true,x,y,3,null, 0,0,32,16,0,0,speed,speed,expire_off_view);
		myEngine = eng;
		
		//Defines and sets an image of a black star
		myEngine.defineImage(
				"star", // graphic name
				"-", 3, // tile name and tile cid (in case we use it as a tile)
				"Black_star.png", // file
				"-" // graphical operation (may be one or two out of
				    //"x","y", "l","r","u")
		);
		this.setImage("star");
	}
	
	/** Draw the object. */
//	public void paint() {
//		// Draw a yellow ball
//		myEngine.setColor(JGColor.yellow);
//		myEngine.drawOval(x,y,16,16,true,true);
//	}
	
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
		xdir = 1;
		ydir = 0;
		//super.move();
		//whatever code you need
		
	}
}