//Chad M. Coviel
import jgame.JGObject;
import jgame.platform.StdGame;

//Player object. This is the character that the human user will control
//via input.
public class Player extends JGObject{
	
	//Used as a proxy for redirecting method requests here because Java
	//doesn't allow multiple inheritance
	private StdGame myEngine;
	private int bullettime = 0;

	
	public Player(double x, double y, double speed,StdGame eng){
		super("player",true,x,y,1,null, 0,0,32,16,0,0,speed,speed,-1);
		myEngine = eng;
		
		//Defines the image to be used for the player and sets it
		myEngine.defineImage("player","-",1,"limbo.png","-");
		this.setImage("player");
		
		//Resizes the player collision boundaries
		setBBox(this.getImageBBox().x,this.getImageBBox().y,this.getImageBBox().width-70,
				this.getImageBBox().height-50);
	}
		
	public void move(){
		setDir(0,0);
		if (myEngine.getKey(myEngine.key_up)    && y > yspeed)               ydir=-1;
		if (myEngine.getKey(myEngine.key_down)  && y < myEngine.pfHeight()-16-yspeed) ydir=1;
		if (myEngine.getKey(myEngine.key_left)  && x > xspeed)               xdir=-1;
		if (myEngine.getKey(myEngine.key_right) && x < myEngine.pfWidth()-32-yspeed)  xdir=1;
		
		//Checks to see if the user is trying to fire a projectile and does so
		checkFire();
	}

	public void hit(JGObject obj){
		//player dies if the enemy makes physical contact (or projectile)
		//if(myEngine.checkCollision(this.colid,2))
		if(obj.colid == 2 || obj.colid == 4){
			remove();
			myEngine.lifeLost();
		}
		
	}
	
	private void checkFire() {
		// TODO Auto-generated method stub

		// shoot a black star in the +x direction
		if(myEngine.getKey('Z') && bullettime <= 0){
			new BlackStar(x+100.0,y+50.0,25.0,myEngine);
			bullettime = 8;
		}
	    
	    if(bullettime > 0) bullettime--;
	}
}