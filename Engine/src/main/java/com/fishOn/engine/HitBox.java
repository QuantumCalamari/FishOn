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
		int x1, x2, y1, y2, w1, w2, h1, h2;
		xCollide = true;
		yCollide = true;
		x1 = rectangle.x;
		x2 = spriteHitbox.x;
		y1 = rectangle.y;
		y2 = spriteHitbox.y;
		w1 = rectangle.width;
		w2 = spriteHitbox.width;
		h1 = rectangle.height;
		h2 = spriteHitbox.height;		
		
		if (((x2 + w2) < x1) || (x2 > (x1 + w1)))
			xCollide = false;
		if (((y2 + h2) < y1) || (y2 > (y1 + h1)))
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
