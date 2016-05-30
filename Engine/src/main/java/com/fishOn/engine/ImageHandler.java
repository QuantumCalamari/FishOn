package main.java.com.fishOn.engine;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class ImageHandler
{
	public ImageHandler()
	{
		
	}
	
	//gets an image
	public ImageIcon getImage(String imageName)
	{
		return new ImageIcon(this.getClass().getResource("resource" + File.separator + "images" + File.separator + imageName + ".png"));
	}
	
	//gets a scaled instance of an image
	public ImageIcon getImage(String imageName, int height, int width)
	{
		return new ImageIcon(new ImageIcon(this.getClass().getResource("resource\\images\\" + imageName + ".png")).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
}
