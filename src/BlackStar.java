//Chad M. Coviel

import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class BlackStar extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;
	
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
	
	public void move(){
		setDir(0,0);
		//moves right
		xdir = 1;
		ydir = 0;
	}
}