import java.awt.event.KeyEvent;

import javax.swing.Timer;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {
	
	private int width;//Frame-width
	private int height;//Frame-height
	private int imageWidth;
	private int imageHeight;
	private int x;
	private int y = 38; //defined here to give space for the buttons
	private Direction direction;
	
	final private int xChange = 10;
	final private int yChange = 10;
	
	//Used to tell direction
	//Direction that orc begins moving is !north and east
	private boolean running = false;
	private boolean jumping = false;
	private boolean firing = false;
	
	private boolean up ;
	private boolean down;
	private boolean left; 
	private boolean right;
	
	public Model(int width, int height, int imageWidth, int imageHeight) {
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		
		this.up = false;
		this.down = false;
		this.left = false;
		this.right = false;
	}

	public Direction move(KeyEvent event){
		
		switch(event.getKeyCode()){
		case 37://Left KeyCode
			running = true;
			moveLeft();
			break;
		case 38://Up KeyCode
			running = true;
			moveUp();
			break;
		case 39://Right Left KeyCode
			running = true;
			moveRight();
			break;
		case 40://Down KeyCode
			running = true;
			moveDown();
			break;
		case 32://SpaceBar
			jumping = true;
			jump();
			break;
		case 70://F-key
			//Fire
			firing = true;
			fire();
			break;
		default:
			break;
		}
		//t.start();
		return direction;
	}
	
	
	public void release(KeyEvent event){
		switch(event.getKeyCode()){
		case 37://Left KeyCode
			running = false;
			left = false;
			break;
		case 38://Up KeyCode
			running = false;
			up = false;
			break;
		case 39://Right Left KeyCode
			running = false;
			right = false;
			break;
		case 40://Down KeyCode
			running = false;
			down = false;
			break;
		case 32://SpaceBar; Jump
			jumping = false;
			break;
		case 70://F-key; Fire
			firing = false;
			break;
		default:
			break;
		}
	}
	
	public void jump(){
		System.out.println("JUMP");
	}
	
	public void fire(){
		System.out.println("FIRE");
	}
	
	public void moveLeft(){//Make the 'left' boolean true and all others false
		//West
		System.out.println("LEFT");
		this.direction = Direction.WEST;
		left = true;
		right = false;
		up = false;
		down = false;
	}	
	public void moveDown(){//Make the 'down' boolean true and all others false
		//South
		System.out.println("DOWN");
		this.direction = Direction.SOUTH;
		left = false;
		right = false;
		up = false;
		down = true;
	}
	public void moveUp(){//Make the 'up' boolean true and all others false
		//North
		System.out.println("UP");
		this.direction = Direction.NORTH;
		left = false;
		right = false;
		up = true;
		down = false;
	}
	public void moveRight(){//Make the 'right' boolean true and all others false
		//East
		System.out.println("RIGHT");
		this.direction = Direction.EAST;
		left = false;
		right = true;
		up = false;
		down = false;
	}

	public void updateLocation(){
		if(up){
			if(y - yChange > 0){
				//update location
				y = y - yChange;
			}
		}
		else if(down){
			if(y + imageHeight + yChange < height){
				y = y + yChange;
			}
		}
		else if(left){
			if(x - xChange > 0){
				x = x - xChange;
			}
		}
		else if(right){
			if(x + imageWidth + xChange < width){
				x = x + xChange;
			}
		}
		else{
			//Do nothing
		}
	}

	
	public void startOrStop(Timer t){
		running = !running;//Change state of being
		if(running){
			t.start();
		}
		else if(!running){
			t.stop();
		}
	}
	
	public void printTestInfo()
	{
		System.out.println("Direction: " + getDirect() + "  xLoc: " + x + " yLoc: " + y);
	}
	
	//Getters
	
	public int getX(){	
		return x;
	}
	public int getY(){
		return y;
	}
	public Boolean getRunning(){
		return running;
	}
	public Direction getDirect(){
		return this.direction;
	}
	public Boolean getJumping(){
		return jumping;
	}
	public Boolean getFiring(){
		return firing;
	}
	
}
