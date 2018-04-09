import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Images {
	
	NORTHEAST(0),
	SOUTHEAST(1),
	SOUTHWEST(2),
	NORTHWEST(3),
	NORTHEASTF(4),
	SOUTHEASTF(5),
	SOUTHWESTF(6),
	NORTHWESTF(7),
	NORTHEASTJ(8),
	SOUTHEASTJ(9),
	SOUTHWESTJ(10),
	NORTHWESTJ(11);
	
    private BufferedImage bufferedImageNE;
    private BufferedImage bufferedImageNW;
    private BufferedImage bufferedImageSE;
    private BufferedImage bufferedImageSW;
    private BufferedImage bufferedImageNEf;
    private BufferedImage bufferedImageNWf;
    private BufferedImage bufferedImageSEf;
    private BufferedImage bufferedImageSWf;
    private BufferedImage bufferedImageNEj;
    private BufferedImage bufferedImageNWj;
    private BufferedImage bufferedImageSEj;
    private BufferedImage bufferedImageSWj;
	
	private BufferedImage image;
    
	private Images(int s){
		BufferedImage bufferedImage = null;
    	try {
    		bufferedImageNE = ImageIO.read(new File("images/orc_forward_northeast.png")); 
    		bufferedImageNW = ImageIO.read(new File("images/orc_forward_northwest.png"));
    		bufferedImageSE = ImageIO.read(new File("images/orc_forward_southeast.png"));
    		bufferedImageSW = ImageIO.read(new File("images/orc_forward_southwest.png"));
    		bufferedImageNEf = ImageIO.read(new File("images/orc_fire_northeast.png")); 
    		bufferedImageNWf = ImageIO.read(new File("images/orc_fire_northwest.png"));
    		bufferedImageSEf = ImageIO.read(new File("images/orc_fire_southeast.png"));
    		bufferedImageSWf = ImageIO.read(new File("images/orc_fire_southwest.png"));
    		bufferedImageNEj = ImageIO.read(new File("images/orc_jump_northeast.png")); 
    		bufferedImageNWj = ImageIO.read(new File("images/orc_jump_northwest.png"));
    		bufferedImageSEj = ImageIO.read(new File("images/orc_jump_southeast.png"));
    		bufferedImageSWj = ImageIO.read(new File("images/orc_jump_southwest.png"));
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
    		bufferedImage = bufferedImageNEf;
    		break;
    	case 5:
    		bufferedImage = bufferedImageSEf;
    		break;
    	case 6: 
    		bufferedImage = bufferedImageSWf;
    		break;
    	case 7: 
    		bufferedImage = bufferedImageNWf;
    		break;
    	case 8: 
    		bufferedImage = bufferedImageNEj;
    		break;
    	case 9:
    		bufferedImage = bufferedImageSEj;
    		break;
    	case 10: 
    		bufferedImage = bufferedImageSWj;
    		break;
    	case 11: 
    		bufferedImage = bufferedImageNWj;
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
