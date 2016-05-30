package main.java.com.fishOn.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameEngine extends JFrame implements Runnable
{
	private static final long serialVersionUID = -5024743624066497330L;
	static boolean isRunning = true;
	static int fps, windowWidth, windowHeight, x, y, dx, dy;
	//bulbasaur values
	int xb, yb, bulbaHeight, bulbaWidth;

	private static Thread thread;
	private static boolean running = false;
	static BufferedImage bufferedImage;
	static Color color;
	static ImageHandler imageHandler;
	static InputHandler input;
	static Insets insets;
	Sprite mudkip;
	Sprite bulbasaur;
	HitBox island, obstacle;
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		fps = Integer.parseInt(ResourceString.getString("FPS"));		
		imageHandler = new ImageHandler();
		input = new InputHandler(this);
		mudkip = new Sprite("mudkip");
		//I added a bulbasaur so I didn't have to untangle your mudkip and I could start again with it
		bulbasaur = new Sprite("bulba");
		windowWidth = Integer.parseInt(ResourceString.getString("WindowWidth"));
		windowHeight = Integer.parseInt(ResourceString.getString("WindowHeight"));
		
		//for collision
		bulbaHeight = bulbasaur.getHeight();
		bulbaWidth = bulbasaur.getWidth();
		
		x = 500;
		y = 10;
		//bulbasaur's position
		//the -10 is -50 for the height of the ground and -36 for the size of the sprite
		xb = 20;
		yb = windowHeight-86;
	
		
		setTitle(ResourceString.getString("Title"));
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		createBufferStrategy(2);
		
		island = new HitBox(200, 200, 200, 200);
		obstacle = new HitBox((windowWidth/2), (windowHeight-100), 50, 80);
		//System.out.println(windowWidth/2);
		//System.out.println(windowWidth/2+50);
		
		addMouseListener(input);
		insets = getInsets();
		setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
		bufferedImage = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
	}

	public void update()
	{
		move(10);
	}
	
	public void move(int step)
	{		
		if(input.isKeyDown(KeyEvent.VK_A))
		{
			
			if (xb < step && (obstacle.isCollide(bulbasaur.getHitBox().rectangle)))
				xb = step;
			else
				xb -= step;
			
			/*if ((x < step) && (island.isCollide(mudkip.getHitBox().rectangle)))
				x = step;
			else
				x -= step;*/
		}

		if(input.isKeyDown(KeyEvent.VK_D))
		{
			
			if(obstacle.isCollide(bulbasaur.getHitBox().rectangle))
			{
				//System.out.println("COLLIDE!");
				
				//System.out.println(bulbasaur.getHitBox().width);
				
					xb = xb - step;

			}
			
			if ((x > (windowWidth - step - bulbasaur.getHitBox().getWidth())) && (obstacle.isCollide(bulbasaur.getHitBox().rectangle)))
				xb = xb + step;
			else
				xb += step;
			
			if ((x > (windowWidth - step - mudkip.getHitBox().getWidth())) && (island.isCollide(mudkip.getHitBox().rectangle)))
				x = (int) (windowWidth - step - mudkip.getHitBox().getWidth());
			else
				x += step;
		}

		if(input.isKeyDown(KeyEvent.VK_W))
		{
			if ((y < step) && (island.isCollide(mudkip.getHitBox().rectangle)))
				y = step;
			else
				y -= step;
		}

		if(input.isKeyDown(KeyEvent.VK_S))
		{
			if ((y > (windowHeight - step - mudkip.getHitBox().getHeight())) && (island.isCollide(mudkip.getHitBox().rectangle)))
				y = (int) (windowHeight - step - mudkip.getHitBox().getHeight());
			else
				y += step;
		}
		
		mudkip.setPosx(x);
		mudkip.setPosy(y);
		bulbasaur.setPosx(xb);		
		bulbasaur.setPosy(yb);
	}

	public void draw()
	{
		BufferStrategy bufferStrategy;
		Graphics graphics, background;

		background = bufferedImage.getGraphics();
		
		bufferStrategy = getBufferStrategy();
		if(bufferStrategy == null)
		{
			createBufferStrategy(3);
		}
		//System.out.println(xb);
		background.setColor(Color.CYAN);
		background.fillRect(0, 0, windowWidth, windowHeight);
		background.setColor(Color.RED);
		//obstacle
		background.fillRect((windowWidth/2), (windowHeight-100), 50, 80);
		background.setColor(Color.GREEN);
		//ground
		background.fillRect(0, (windowHeight-50), windowWidth, 50);
		//end wall
		background.fillRect((windowWidth-20), 0, 20, windowHeight);
		//background.drawImage(mudkip.getIcon(), mudkip.getPosx(), mudkip.getPosy(), this);
		background.drawImage(bulbasaur.getIcon(), bulbasaur.getPosx(), bulbasaur.getPosy(), this);
		graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(bufferedImage, insets.left, insets.top, this);
		graphics.dispose();
		bufferStrategy.show();
	}
}