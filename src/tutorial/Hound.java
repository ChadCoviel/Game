package tutorial;
//import tutorial.Example2;
import tutorial.Example7.Shooter;
import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class Hound extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;
	//Used to time each projectile launch
	private int bullettime = 0;
	
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
		//Enemy dies if hit by player projectile which inceases the user's score
		if(obj.colid == 3){
			remove();
			myEngine.score += 50;
		}
	}
	
	public void move(){
		setDir(0,0);
		//Moves to the left
		xdir=-1;
		ydir=0;
		
		//fire projectile towards player
		FireProjectiles();
	}

	private void FireProjectiles() {
		//A sort of timer to allow for properly spaced projectile launches
		if(bullettime <= 0){
			// shoot a fireball at the player
			new Fireball(x,y+50.0,17.5,myEngine);
			bullettime = 50;
		}
		
		//Decrements bullettime counter
		if(bullettime > 0)bullettime--;
	}
}