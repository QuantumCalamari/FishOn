package main.java.com.fishOn.engine;

import java.awt.Rectangle;

public class HitBox
{
	int x, y, width, height;
	boolean tangible;
	Rectangle rectangle;
	
	public HitBox(int originX, int originY, int lengthX, int lengthY)
	{	
		tangible = true;
		x = originX;
		y = originY; 
		width = lengthX;
		height = lengthY;
		rectangle = new Rectangle(x, y, width, height);
	}
	
	public boolean isCollide(Rectangle spriteHitbox)
	{
		boolean xCollide, yCollide;		
		
		xCollide = true;
		yCollide = true;
		
		if (((spriteHitbox.x + spriteHitbox.width) < rectangle.x) || (spriteHitbox.x > (rectangle.x + rectangle.width)))
			xCollide = false;
		if (((spriteHitbox.y + spriteHitbox.height) < rectangle.y) || (spriteHitbox.y > (rectangle.y + rectangle.height)))
			yCollide = false;
		
		return (xCollide && yCollide);
	}
	
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public boolean isTangible()
	{
		return tangible;
	}

	public void setX(int x)
	{
		this.x = x;
		rectangle.setLocation(x, y);
	}

	public void setY(int y)
	{
		this.y = y;
		rectangle.setLocation(x, y);
	}

	public void setWidth(int width)
	{
		this.width = width;
		rectangle.setSize(width, height);
	}

	public void setHeight(int height)
	{
		this.height = height;
		rectangle.setSize(width, height);
	}

	public void setTangible(boolean tangible)
	{
		this.tangible = tangible;
	}
}
