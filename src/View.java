package pkgLab8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class View extends JPanel{
	private int frameCount = 10;
	final private int jumpFrameCount = 8;//Change the value here
	final private int fireFrameCount = 4;//Change the value here
	final private int frameStartSize = 600;
	final private int drawDelay = 20;//In msec(15 seems to look the best)
	private int picNum = 0;
	private int picJumpNum = 0;
	private int picFireNum = 0;
    private BufferedImage[] picsMove;
    private BufferedImage[] picsJump;
    private BufferedImage[] picsFire;
    private int xloc;
    private int yloc;
    
    private Boolean jumping = false;
    private Boolean firing = false;
    private Boolean running = false;
    private Boolean midJump = false;
    private Boolean midFire = false;
 
    private Direction direction;
    private JFrame frame;
	    
    final static int frameWidth = 500;//500
    final static int frameHeight = 400;//400
    final static int imageWidth = 165;
    final static int imageHeight = 165;
    
  //Constructor: get image, segment and store in array
    public View(){
    	BufferedImage img = createImage();
    	picsMove = new BufferedImage[frameCount];
    	picsJump = new BufferedImage[jumpFrameCount];
    	picsFire = new BufferedImage[fireFrameCount];
    	
    	for(int i = 0; i < frameCount; i++)
    		picsMove[i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    } 
    
    public void makeFrame() {
    	frame = new JFrame();
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	
    	frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void update(int x, int y, Direction direction, Boolean jumping, Boolean firing, Boolean running){
    	this.xloc = x;
    	this.yloc = y;
    	this.direction = direction;
    	this.jumping = jumping;
    	this.firing = firing;
    	this.running = running;
    	
    	frame.repaint();
		try {
			Thread.sleep(100);//was 100
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void paintJump(Graphics g){
    	//System.out.println(picJumpNum + "/" + jumpFrameCount + "    MidJump?: " + midJump);
    	if(picJumpNum+1 >= jumpFrameCount){
    		midJump = false;
    		jumping = false;
    	}
    	
    	picJumpNum = (picJumpNum + 1) % jumpFrameCount;
    	
    	
    	
    	changeJumpImage();
    	g.drawImage(picsJump[picJumpNum], xloc, yloc, Color.gray, this);
    	
    	/*for(int x = 0; x < jumpFrameCount; x++){
    		g.drawImage(picsJump[x], xloc, yloc, Color.gray, this);
		}*/
    }
    
    public void paintFire(Graphics g){
    	if(picFireNum+1 >= jumpFrameCount){
    		midFire = false;
    		firing = false;
    	}
    	
    	picFireNum = (picFireNum + 1) % fireFrameCount;
    	changeFireImage();
    	g.drawImage(picsFire[picFireNum], xloc, yloc, Color.gray, this);
    	
    }

    //Override this JPanel's paint method to cycle through picture array and draw images
    @Override
    public void paint(Graphics g) {
    	//Check flags to see what animation you need to run
    	//Check/run jumping
    	//Check/run firing
    	//Run 
    	
    	if(jumping || midJump){//Jumping has highest 'priority'
    		jumping = false;
    		midJump = true;
    		paintJump(g);
    	}
    	else if(firing){//If not jumping	
    		//Run FULL firing animation
    		firing = false;
    		midFire = true;
    		paintFire(g);
    	}
    	else if(running){
    		//IF !firing && !jumping && running
    		//Run partial running animation
    		picNum = (picNum + 1) % frameCount;
    		
        	//BufferedImage img = changeImage();
        	changeImage();
        	g.drawImage(picsMove[picNum], xloc, yloc, Color.gray, this);
        	
    	}
    	else if(!running){
    		BufferedImage img = changeImage();
    		
    		//Commenting this out makes the animation restart each time you move(Good thing I think)
        	for(int i = 0; i < frameCount; i++)
            	picsMove[i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
        	
        	g.drawImage(picsMove[0], xloc, yloc, Color.gray, this);
    	}
  
    } 
    

    
    private BufferedImage changeImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc_forward_south.png"));//ORIGINAL LINE********//southeast
       		if(direction == Direction.NORTH){
    			bufferedImage = Images.MOVE_NORTH.getImage();
    		}
    		else if(direction == Direction.SOUTH){
    			bufferedImage = Images.MOVE_SOUTH.getImage();
    		}
    		else if(direction == Direction.EAST){
    			bufferedImage = Images.MOVE_EAST.getImage();
    		}
    		else if(direction == Direction.WEST){
    			bufferedImage = Images.MOVE_WEST.getImage();
    		}
       		for(int i = 0; i < frameCount; i++)
            	picsMove[i] = bufferedImage.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
    private BufferedImage changeJumpImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc_jump_south.png"));
       		if(direction == Direction.NORTH){
    			bufferedImage = Images.JUMP_NORTH.getImage();
    		}
    		else if(direction == Direction.SOUTH){
    			bufferedImage = Images.JUMP_SOUTH.getImage();
    		}
    		else if(direction == Direction.EAST){
    			bufferedImage = Images.JUMP_EAST.getImage();
    		}
    		else if(direction == Direction.WEST){
    			bufferedImage = Images.JUMP_WEST.getImage();
    		}
       		for(int i = 0; i < jumpFrameCount; i++)
            	picsJump[i] = bufferedImage.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    private BufferedImage changeFireImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc_fire_south.png"));
       		if(direction == Direction.NORTH){
    			bufferedImage = Images.FIRE_NORTH.getImage();
    		}
    		else if(direction == Direction.SOUTH){
    			bufferedImage = Images.FIRE_SOUTH.getImage();
    		}
    		else if(direction == Direction.EAST){
    			bufferedImage = Images.FIRE_EAST.getImage();
    		}
    		else if(direction == Direction.WEST){
    			bufferedImage = Images.FIRE_WEST.getImage();
    		}
       		for(int i = 0; i < fireFrameCount; i++)
            	picsFire[i] = bufferedImage.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    //Read image from file and return
    private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc_forward_south.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    //GETTERS
    public int getWidth(){
    	return frameWidth;
    }
    public int getHeight(){
    	return frameHeight;
    }
	public int getImageWidth() {	
		return imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public int getDrawDelay(){
		return drawDelay;
	}
	public JFrame getFrame(){
		return frame;
	}
	public Boolean getJumping(){
		return jumping;
	}
	public Boolean getFiring(){
		return firing;
	}
	public Boolean getMidJump(){
		return midJump;
	}
}
