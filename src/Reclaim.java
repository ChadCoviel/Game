//Chad M. Coviel
import jgame.*;
import jgame.platform.*;

/** Tutorial example 8: Using StdGame.  Defines a minimal game with the
 * StdGame framework.  StdGame defines a game state machine with some useful
 * default behaviour in the different states.  
 */
public class Reclaim extends StdGame {

	private static int dimx,dimy;
	//Determines at what level the player the user has won the game
	private static int maxLevel=10;
	private Player player;
	
	public static void main(String [] args) {
		dimx =800;
		dimy=540;
		new Reclaim(new JGPoint(dimx,dimy));
	}

	/** Application constructor. */
	public Reclaim(JGPoint size) { initEngine(size.x,size.y); }

	/** Applet constructor. */
	public Reclaim() { initEngineApplet(); }

	//Able to change the number of tiles in the x,y directions based on
	//the default and updated dimensions of the window
	public void initCanvas() { setCanvasSettings((dimx*40)/640,(dimy*30)/480,
			16,16,null,JGColor.blue,null); }

	public void initGame() {
		setFrameRate(35,2);
		defineImage("title","-",0,"reclaim.jpg","-");
		defineImage("level1","-",0,"bg1.jpg","-");
		setBGImage("title");
		// If you want to have highscores in StdGame, add the following line.
		setHighscores(
			10, // number of highscores
			new Highscore(0,"nobody"), // default entry for highscore
			25 // max length of the player name
		);
	}

	/** Called when a new level is started. */
	public void defineLevel() {
		
		//Once you've beaten all 9 levels you have won the game!
		if(level == maxLevel){
			paintFrameInGame();
		}
		
		// remove any remaining objects
		removeObjects(null,0);
		
		//Create player object
		player = new Player(0, dimy/2,
				10.0,this);

		// create as many enemies as the level number
		for (int i=0; i<=level; i++)
			new Hound(dimx, this.random(20,pfHeight()),
					10.0,this);
		setBGImage("level1");
	}

	/** Called when a new life is introduced (that is, at the beginning of the
	 * game and every time the player dies. */
	public void initNewLife() {
		//Start the level over from the beginning when the player dies
		defineLevel();
	}

	/** This is the most important method you have to fill in in StdGame. */
	public void doFrameInGame() {
		moveObjects(null,0);

		//Check for collisions between the player and 
		//enemies/enemy projectiles
		this.checkCollision(1,2 | 4);
		
		//Level won when no more enemy objects on field
		if(countObjects("hound", 2) == 0)
			levelDone();
		
		//Game over when the player runs out of lives
		if(lives <= 0)
			gameOver();
	}

	public void paintFrameInGame() {
		// display instruction
		setFont(new JGFont("arial",0,15));
		
		if(level < maxLevel)
			drawString("Press 'Z' to shoot and arrow keys to move!",
					pfWidth()/2,180,0);
		
		//Font settings specifically for the victory message
		setFont(new JGFont("arial",0,50));
		//Victory message!
		if(level >= maxLevel){
			drawString("YOU WON!",
					pfWidth()/2,300,0);
			// we define a timer as an inner class, that shoots a bullet every
			// 50 frames.
			new JGTimer(
				500,    // timer alarms after 10 frames
				false
				             // automatically when the parent is removed.
			) {
				//Game over
				public void alarm() {
					gameOver();
				}
			};
		}
		
	}

}