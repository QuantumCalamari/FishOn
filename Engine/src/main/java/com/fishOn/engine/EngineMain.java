package main.java.com.fishOn.engine;

import javax.swing.JFrame;

public class EngineMain
{
	public static void main(String[] args)
	{
		GameEngine gameEngine = new GameEngine();
		
		gameEngine.setResizable(false);
		gameEngine.run();
		System.exit(0);
	}

}
