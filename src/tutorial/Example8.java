package tutorial;
import jgame.*;
import jgame.platform.*;

/** Tutorial example 8: Using StdGame.  Defines a minimal game with the
 * StdGame framework.  StdGame defines a game state machine with some useful
 * default behaviour in the different states.  
 */
public class Example8 extends StdGame {

	private static int dimx,dimy;
	private Player player;
	
	public static void main(String [] args) {
		dimx =800;
		dimy=540;
		new Example8(new JGPoint(dimx,dimy));
	}

	/** Application constructor. */
	public Example8(JGPoint size) { initEngine(size.x,size.y); }

	/** Applet constructor. */
	public Example8() { initEngineApplet(); }

	//Able to change the number of tiles in the x,y directions based on
	//the default and updated dimensions of the window
	public void initCanvas() { setCanvasSettings((dimx*40)/640,(dimy*30)/480,
			16,16,null,JGColor.blue,null); }

	public void initGame() {
		setFrameRate(35,2);
		defineImage("level1","-",0,"bg1.jpg","-");
		// If you want to have highscores in StdGame, add the following line.
		setHighscores(
			10, // number of highscores
			new Highscore(0,"nobody"), // default entry for highscore
			25 // max length of the player name
		);
	}

	/** Called when a new level is started. */
	public void defineLevel() {
		// remove any remaining objects
		removeObjects(null,0);
		//Create player object
		player = new Player(0, dimy/2,
				10.0,this);
		// create as many objects as the level number
		for (int i=0; i<=level; i++)
			new Hound(dimx, this.random(20,pfHeight()),
					10.0,this);
		setBGImage("level1");
	}

	/** Called when a new life is introduced (that is, at the beginning of the
	 * game and every time the player dies. */
	public void initNewLife() {
		// ... initialise player sprite ...
		defineLevel();
	}

	/** This is the most important method you have to fill in in StdGame. */
	public void doFrameInGame() {
		moveObjects(null,0);

		this.checkCollision(1,2 | 4);
		
		//Level won when no more enemy objects on field
		if(countObjects("hound", 2) == 0)
			levelDone();
		//Game over when the player runs out of lives
		if(lives <= 0)
			gameOver();
	}

	public void paintFrameInGame() {
		// display instructions
		setFont(new JGFont("arial",0,15));
		drawString("Press N for the next level, or D to lose a life.",
			pfWidth()/2,180,0);
		
	}

}