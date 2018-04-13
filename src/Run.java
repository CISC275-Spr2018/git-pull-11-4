package pkgLab8;

import java.awt.Color;

import javax.swing.JFrame;

public class Run //Starts the animation sequence
{
	public static void main(String[] args) 
	{
		Images LOADIMAGES = Images.FIRE_EAST;//Loads the images so they don't have to load when the first button is pressed
    	Controller c1 = new Controller(); //Makes a new controller
		c1.start(); //Start the animation
	}
}
