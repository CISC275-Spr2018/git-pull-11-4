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
	final private int frameCountForward = 10;
	final private int frameCountJump = 8;
	final private int frameCountFire = 4;
	final private int frameStartSize = 600;
	final private int drawDelay = 15;//In msec(15 seems to look the best)
	private int picNum = 0;
    private BufferedImage[] picsMove;
    private BufferedImage[] picsJump;
    private BufferedImage[] picsFire;
    private int xloc = 0;
    private int yloc = 38;
    //private int counter = 0;
 
    private Direction direction;
    private JFrame frame;
    private JPanel panel;
    private JButton toggleRunButton;
    private JButton reverseButton;
    private Action drawAction;
    private Action reverseAction;	    
    final int xIncr = 8;//8 
    final int yIncr = 2;//2 
    final static int frameWidth = 500;//500
    final static int frameHeight = 400;//400
    final static int imageWidth = 165;
    final static int imageHeight = 165;
    
  //Constructor: get image, segment and store in array
    public View(){
    	BufferedImage img = createImage();
    	picsMove = new BufferedImage[10];
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

    	//panel = new JPanel();
    	//frame.add(panel);
    	toggleRunButton =  new JButton("Go/Pause");
    	reverseButton = new JButton("Reverse");
    	
    	//panel.add(toggleRunButton);
    	//panel.add(reverseButton);
    	frame.setVisible(true);
    	//panel.setBackground(Color.gray);
    	
    	frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void update(int x, int y, Direction direction){
    	this.xloc = x;
    	this.yloc = y;
    	this.direction = direction;
    	
    	frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	picNum = (picNum + 1) % frameCount;
    	BufferedImage img = changeImage();
    	g.drawImage(picsMove[picNum], xloc, yloc, Color.gray, this);
    		
        for(int i = 0; i < frameCount; i++)
        	picsMove[i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
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
	public Action getDrawAction(){
		return drawAction;
	}
	public Action getReverseAction(){
		return reverseAction;
	}
	public JButton getToggleRunButton(){
		return toggleRunButton;
	}
	public JButton getReverseButton(){
		return reverseButton;
	}
	public JPanel getPanel(){
		return panel;
	}
	public JFrame getFrame(){
		return frame;
	}
}
