import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Images {
	
	MOVE_NORTHEAST(0),
	MOVE_SOUTHEAST(1),
	MOVE_SOUTHWEST(2),
	MOVE_NORTHWEST(3),
	MOVE_NORTH(4),
	MOVE_SOUTH(5), 
	MOVE_EAST(6), 
	MOVE_WEST(7),
	JUMP_NORTH(8),
	JUMP_SOUTH(9),
	JUMP_EAST(10),
	JUMP_WEST(11),
	FIRE_NORTH(12),
	FIRE_SOUTH(13),
	FIRE_EAST(14),
	FIRE_WEST(15);
	
    private BufferedImage bufferedImageNE;
    private BufferedImage bufferedImageNW;
    private BufferedImage bufferedImageSE;
    private BufferedImage bufferedImageSW;
    
    private BufferedImage bufferedImageMoveN;
    private BufferedImage bufferedImageMoveS;
    private BufferedImage bufferedImageMoveE;
    private BufferedImage bufferedImageMoveW;
    
    private BufferedImage bufferedImageJumpN;
    private BufferedImage bufferedImageJumpS;
    private BufferedImage bufferedImageJumpE;
    private BufferedImage bufferedImageJumpW;
    
    private BufferedImage bufferedImageFireN;
    private BufferedImage bufferedImageFireS;
    private BufferedImage bufferedImageFireE;
    private BufferedImage bufferedImageFireW;
	
	private BufferedImage image;
    
	private Images(int s){
		BufferedImage bufferedImage = null;
    	try {
    		bufferedImageNE = ImageIO.read(new File("images/orc_forward_northeast.png")); 
    		bufferedImageNW = ImageIO.read(new File("images/orc_forward_northwest.png"));
    		bufferedImageSE = ImageIO.read(new File("images/orc_forward_southeast.png"));
    		bufferedImageSW = ImageIO.read(new File("images/orc_forward_southwest.png"));
    		
    		bufferedImageMoveN = ImageIO.read(new File("images/orc_forward_north.png"));
    		bufferedImageMoveS = ImageIO.read(new File("images/orc_forward_south.png"));
    		bufferedImageMoveE = ImageIO.read(new File("images/orc_forward_east.png"));
    		bufferedImageMoveW = ImageIO.read(new File("images/orc_forward_west.png"));
    		
    		bufferedImageJumpN = ImageIO.read(new File("images/orc_jump_north.png"));
    		bufferedImageJumpS = ImageIO.read(new File("images/orc_jump_south.png"));
    		bufferedImageJumpE = ImageIO.read(new File("images/orc_jump_east.png"));
    		bufferedImageJumpW = ImageIO.read(new File("images/orc_jump_west.png"));
    		
    		bufferedImageFireN = ImageIO.read(new File("images/orc_fire_north.png"));
    		bufferedImageFireS = ImageIO.read(new File("images/orc_fire_south.png"));
    		bufferedImageFireE = ImageIO.read(new File("images/orc_fire_east.png"));
    		bufferedImageFireW = ImageIO.read(new File("images/orc_fire_west.png"));
    		
    	switch (s) {
    	case 0: 
    		bufferedImage = bufferedImageNE;
    		break;
    	case 1:
    		bufferedImage = bufferedImageSE;
    		break;
    	case 2: 
    		bufferedImage = bufferedImageSW;
    		break;
    	case 3: 
    		bufferedImage = bufferedImageNW;
    		break;
    	case 4:
    		bufferedImage = bufferedImageMoveN;
    		break;
    	case 5:
    		bufferedImage = bufferedImageMoveS;
    		break;
    	case 6:
    		bufferedImage = bufferedImageMoveE;
    		break;
    	case 7:
    		bufferedImage = bufferedImageMoveW;
    		break;
    	case 8:
    		bufferedImage = bufferedImageJumpN;
    		break;
    	case 9:
    		bufferedImage = bufferedImageJumpS;
    		break;
    	case 10:
    		bufferedImage = bufferedImageJumpE;
    		break;
    	case 11:
    		bufferedImage = bufferedImageJumpW;
    		break;
    	case 12:
    		bufferedImage = bufferedImageFireN;
    		break;
    	case 13:
    		bufferedImage = bufferedImageFireS;
    		break;
    	case 14:
    		bufferedImage = bufferedImageFireE;
    		break;
    	case 15:
    		bufferedImage = bufferedImageFireW;
    		break;
    	}
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	image = bufferedImage;
	}
	public BufferedImage getImage() {
		return image;
	}
	

}
