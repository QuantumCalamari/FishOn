package main.java.com.fishOn.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameEngine extends JFrame
{
	private static final long serialVersionUID = -5024743624066497330L;
	static boolean isRunning = true;
	static int fps, windowWidth, windowHeight, x, y, dx, dy;

	static BufferedImage background;
	static Color color;
	static InputHandler input;
	static Insets insets;

	public void run()
	{
		initialize();

		while(isRunning)
		{
			long time;

			time = System.currentTimeMillis();

			update();
			draw();

			time = (1000 / fps) - (System.currentTimeMillis() - time);

			if(time > 0)
			{
				try
				{
					Thread.sleep(time);
				}
				catch (InterruptedException e)
				{
					System.err.println("");
					e.printStackTrace();
				}
			}
		}
		setVisible(false);
	}

	public void initialize()
	{
		fps = 60;
		windowWidth = 800;
		windowHeight = 600;
		x = 10;
		y = 10;
		color = Color.YELLOW;
		setTitle("Title");
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		input = new InputHandler(this);
		addMouseListener(input);
		insets = getInsets();
		setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
		background = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
	}

	public void update()
	{
		move(5);
	}
	
	public void move(int step)
	{
		if(input.isKeyDown(KeyEvent.VK_A))
		{
			if (x < step)
				x = step;
			else
				x -= step;
		}

		if(input.isKeyDown(KeyEvent.VK_D))
		{
			if (x > (windowWidth - step - 50))
				x = windowWidth - step - 50;
			else
				x += step;
		}

		if(input.isKeyDown(KeyEvent.VK_W))
		{
			if (y < step)
				y = step;
			else
				y -= step;
		}

		if(input.isKeyDown(KeyEvent.VK_S))
		{
			if (y > (windowHeight - step - 50))
				y = windowHeight - step - 50;
			else
				y += step;
		}
	}

	public void draw()
	{
		Graphics graphics, backgroundGraphics;

		backgroundGraphics = background.getGraphics();
		graphics = getGraphics();		

		backgroundGraphics.setColor(Color.BLACK);
		backgroundGraphics.fillRect(0, 0, windowWidth, windowHeight);

		backgroundGraphics.setColor(color);
		backgroundGraphics.fillOval(x, y, 50, 50);		

		graphics.drawImage(background, insets.left, insets.top, this);
	}
}