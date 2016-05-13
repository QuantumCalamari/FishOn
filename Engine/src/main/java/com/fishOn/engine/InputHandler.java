package main.java.com.fishOn.engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler implements KeyListener, MouseListener
{
	boolean keys[];
	
	public InputHandler(Component c)
	{
		c.addKeyListener(this);
		keys = new boolean[256];	
	}
	
	public boolean isKeyDown(int keyCode)
	{
		return keys[keyCode];
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if((e.getKeyCode() > 0) && (e.getKeyCode() < 256))
		{
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if((e.getKeyCode() > 0) && (e.getKeyCode() < 256))
		{
			keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		//Not used
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		GameEngine.x = e.getX();
		GameEngine.y = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		GameEngine.color = Color.MAGENTA;
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		GameEngine.color = Color.YELLOW;
	}
}
