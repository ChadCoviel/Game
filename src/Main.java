//package tutorial;
//import tutorial.Example2.MyObject;
import tutorial.Example2;
//import tutorial.Example7.Shooter;
import jgame.*;
import jgame.platform.*;

/** Tutorial example 1: a minimal program.  A "bare skeleton" program
 * displaying a moving text "hello world".
 *
 * In order to run as both applet and application, you need to define a main()
 * method (this is the entry point for an application) and a parameterless
 * constructor (this is the entry point for an applet).  We use a second
 * constructor with a size parameter to initialise the engine as an
 * application.
 */
public class Main extends JGEngine {

	public static void main(String [] args) {
		// We start the engine with a fixed window size (which happens to
		// be twice the size of the defined playfield, scaling the playfield
		// by a factor 2).  Normally, you'd want this size to be configurable,
		// for example by means of command line parameters.
		new Main(new JGPoint(800,700));
	}

	/** The parameterless constructor is called by the browser, in case we're
	 * an applet. */
	public Main() {
		// This inits the engine as an applet.
		initEngineApplet(); 
	}

	/** We use a separate constructor for starting as an application. */
	public Main(JGPoint size) {
		// This inits the engine as an application.
		initEngine(size.x,size.y); 
	}

	/** This method is called by the engine when it is ready to intialise the
	 * canvas (for an applet, this is after the browser has called init()).
	 * Note that applet parameters become available here and not
	 * earlier (don't try to access them from within the parameterless
	 * constructor!).  Use isApplet() to check if we started as an applet.
	 */
	public void initCanvas() {
		final JGColor foreground = new JGColor(20,40,30);
		final JGColor background = new JGColor(10,30,200);
//		final JGColor foreground = new JGColor(20,40,30);
//		final JGColor background = new JGColor(10,30,50);
		// The only thing we need to do in this method is to tell the engine
		// what canvas settings to use.  We should not yet call any of the
		// other game engine methods here!
		setCanvasSettings(
			20,  // width of the canvas in tiles
			15,  // height of the canvas in tiles
			16,  // width of one tile
			16,  // height of one tile
			     //    (note: total size = 20*16=320  x  15*16=240)
			foreground,// foreground colour -> use default colour white
			JGColor.blue,// background colour -> use default colour black
			null // standard font -> use default font
		);
	}

	/** This method is called when the engine has finished initialising and is
	 * ready to produce frames.  Note that the engine logic runs in its own
	 * thread, separate from the AWT event thread, which is used for painting
	 * only.  This method is the first to be called from within its thread.
	 * During this method, the game window shows the intro screen. */
	public void initGame() {
		// We can set the frame rate, load graphics, etc, at this point. 
		// (note that we can also do any of these later on if we wish)
		setFrameRate(
			35,// 35 = frame rate, 35 frames per second
			2  //  2 = frame skip, skip at most 2 frames before displaying
			   //      a frame again
		);
		
		//Enables the use and display of a title screen upon launch
		setGameState("Title");
		
//		//User controlled object
//		new Player("player",
//				true,
//				this.random(0,pfWidth()),
//				this.random(0,pfHeight()),
//				1,
//				null);
		
	}

	/** A timer used to animate the "hello world" text. */
	//double texttimer=0;

	/** Called when the Title state is entered. */
	public void startTitle() {
		// we need to remove all game objects when we go from in-game to the
		// title screen
		removeObjects(null,0);
	}

	public void paintFrameTitle() {
		drawString("Title state. Press space to go to InGame",pfWidth()/2,90,0);
	}
	
	/** Frames the title screen **/
	public void doFrameTitle() {
		if (getKey(' ')) {
			// ensure the key has to be pressed again to register
			clearKey(' ');
			// Set both StartGame and InGame states simultaneously.
			// When setting a state, the state becomes active only at the
			// beginning of the next frame.
			setGameState("StartGame");
			addGameState("InGame");
			// set a timer to remove the StartGame state after a few seconds,
			// so only the InGame state remains.
			new JGTimer(
				70, // number of frames to tick until alarm
				true, // true means one-shot, false means run again
				      // after triggering alarm
				"StartGame" // remove timer as soon as the StartGame state
				            // is left by some other circumstance.
				            // In particular, if the game ends before
				            // the timer runs out, we don't want the timer to
				            // erroneously trigger its alarm at the next
				            // StartGame.
			) {
				// the alarm method is called when the timer ticks to zero
				public void alarm() {
					removeGameState("StartGame");
				}
			};
		}
	}
	
	/** Game logic is done here.  No painting can be done here, define
	* paintFrame to do that. */
	public void doFrame() {
		// Increment the angle of the moving text.
		//texttimer += 0.05;
		moveObjects(
				null,// object name prefix of objects to move (null means any)
				0    // object collision ID of objects to move (0 means any)
			);
	}
	
	/** Called once when game goes into the InGame state. */
	public void startInGame() {
		// when the game starts, we create a game object
		new Player("player",
		true,
		this.random(0,pfWidth()),
		this.random(0,pfHeight()),
		1,
		null);
	}

	/** Any graphics drawing beside objects or tiles should be done here.
	 * Usually, only status / HUD information needs to be drawn here. */
	public void paintFrame() {}
//		setColor(JGColor.yellow);
//		// Draw a text that moves around in a circle.
//		// Note: viewWidth returns the width of the view;
//		//       viewHeight the height.
//		drawString("Hello world",
//			viewWidth()/2  + 50*Math.sin(texttimer), // xpos
//			viewHeight()/2 + 50*Math.cos(texttimer), // ypos
//			0 // the text alignment
//			  // (-1 is left-aligned, 0 is centered, 1 is right-aligned)
//		);
//	}
}