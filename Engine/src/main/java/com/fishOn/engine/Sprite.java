package main.java.com.fishOn.engine;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Sprite
{
	Image icon;
	ImageHandler imageHandler = new ImageHandler();
	ImageIcon imageIcon;
	int posx, posy, width, height;
	Rectangle hitBox;
	
	//Create a sprite with a specified image
	public Sprite(String imageName)
	{
		imageIcon = imageHandler.getImage(imageName);
		hitBox = new Rectangle();
		icon = imageIcon.getImage();
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		hitBox.setSize(width - 5, height - 5);
	}
	
	//Create a sprite with a scaled instance of a specified image
	public Sprite(String imageName, int width, int height)
	{
		imageIcon = imageHandler.getImage(imageName, width, height);
		hitBox = new Rectangle(width, height);
		icon = imageIcon.getImage();
		this.width = width;
		this.height = height;
	}

	public void setVisible(boolean visible)
	{
		
	}
	
	public Image getIcon()
	{
		return icon;
	}

	public ImageIcon getImageIcon()
	{
		return imageIcon;
	}

	public int getPosx()
	{
		return posx;
	}

	public int getPosy()
	{
		return posy;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public Rectangle getHitBox()
	{
		return hitBox;
	}

	public void setIcon(Image icon)
	{
		this.icon = icon;
	}

	public void setImageIcon(ImageIcon imageIcon)
	{
		this.imageIcon = imageIcon;
	}

	public void setPosx(int posx)
	{
		this.posx = posx;
	}

	public void setPosy(int posy)
	{
		this.posy = posy;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public void setHitBox(Rectangle hitBox)
	{
		this.hitBox = hitBox;
	}
}
