//Chad M. Coviel
import jgame.*;
import jgame.platform.*;

//Player object. This is the character that the human user will control
//via input.
public class Fireball extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;

	public Fireball(double x, double y, double speed,StdGame eng){
		super("fireball",true,x,y,4,null, 0,0,32,16,0,0,speed,speed,expire_off_view);
		myEngine = eng;
		
		//Defines the image to be used for the enemy projectile
		myEngine.defineImage("fireball","-",4,"fireball.png","-");
		this.setImage("fireball");
	}
	
	//If this object hits the player a life is lost
	public void hit(JGObject obj){
		if(obj.colid == 1)
			myEngine.lifeLost();
	}
	
	public void move(){
		setDir(0,0);
		//Moves left
		xdir = -1;
		ydir = 0;		
	}
}