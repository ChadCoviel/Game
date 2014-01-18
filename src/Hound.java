
//import tutorial.Example2;
//import tutorial.Example7.Shooter;
import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class Hound extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;
//	private int xpos;
//	private int ypos;
	private int bullettime = 0;
	
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
	
	public Hound(double x, double y, double speed, StdGame eng){
		super("hound",true,x,y,2,null, 0,0,32,16,0,0,speed,speed,expire_off_view);
		myEngine = eng;
		
		//Defines and set an image of a hell hound
		myEngine.defineImage(
				"hound", // graphic name
				"-", 2, // tile name and tile cid (in case we use it as a tile)
				"Enemy1.gif", // file
				"-" // graphical operation (may be one or two out of
				    //"x","y", "l","r","u")
		);
		this.setImage("hound");
		
		//Reconfigures image box for more accurate collision events (i.e. reduces
		//apparent gaps between images on collision
		setBBox(this.getImageBBox().x,this.getImageBBox().y,this.getImageBBox().width-70,
				this.getImageBBox().height-50);
	} 
	
	public void hit(JGObject obj){
		//player dies if the enemy makes physical contact (or projectile)
		//if(myEngine.checkCollision(this.colid,2))
		if(obj.colid == 1)
			myEngine.lifeLost();
		if(obj.colid == 3){
			remove();
			myEngine.score += 50;
		}
	}
	
	public void move(){
		setDir(0,0);
		xdir=-1;
		ydir=0;
		
		//fire projectile towards player
		FireProjectiles();
	}

	private void FireProjectiles() {
		//A sort of timer to allow for properly spaced projectile launches
		if(bullettime <= 0){
			// shoot a fireball at the player
			new Fireball(x,y+50.0,20.0,myEngine);
			bullettime = 32;
		}
		
		//Decrements bullettime counter
		if(bullettime > 0)bullettime--;
	}
}