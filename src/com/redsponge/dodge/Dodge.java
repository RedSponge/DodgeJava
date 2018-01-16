package com.redsponge.dodge;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.redsponge.dodge.display.Display;
import com.redsponge.dodge.entities.actors.Player;
import com.redsponge.dodge.input.KeyManager;
import com.redsponge.dodge.input.MouseManager;
import com.redsponge.dodge.input.files.FileManager;
import com.redsponge.dodge.input.files.WaveFiles;
import com.redsponge.dodge.settings.config.ConfigManager;
import com.redsponge.dodge.states.GameOverState;
import com.redsponge.dodge.states.GameState;
import com.redsponge.dodge.states.MenuState;
import com.redsponge.dodge.states.State;
import com.redsponge.dodge.utils.timing.TimeHandler;

public class Dodge implements Runnable {
	private Display display;
	private String title;
	private int width;
	private int height;
	private boolean running;
	private Thread thread;
	private Graphics g;
	private BufferStrategy bs;
	private Handler handler;
	private GameState gameState;
	private GameOverState gameOverState;
	private MenuState menuState;
	private Player player;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private TimeHandler timeHandler;

	private FileManager fileManager;

	public Dodge(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;

		handler = new Handler(this);
	}

	private void init() {
		GameActions.init(handler);
		display = new Display(width, height, title);

		fileManager = new FileManager();

		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);

		WaveFiles.init(fileManager);

		mouseManager = new MouseManager();
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		player = new Player(handler, 0.0F, 0.0F, 3.0F, 20, 20);
		gameState = new GameState(handler, player);
		gameOverState = new GameOverState(handler);
		menuState = new MenuState(handler);

		timeHandler = new TimeHandler(handler);

		ConfigManager.init(handler);

		State.setState(menuState);
	}

	public void tick() {
		keyManager.tick();
		timeHandler.tick();
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height);

		if (State.getState() != null) {
			State.getState().render(g);
		}

		bs.show();
		g.dispose();
	}

	public synchronized void start() {
		if (running) {
			System.out.println("[!] Recieved call to start a running game, Aborting!");
			return;
		}
		thread = new Thread(this);
		running = true;
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			System.out.println("[!] Recieved call to stop a stopped game, Aborting!");
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0.0D;

		long lastTime = System.nanoTime();
		long timer = 0L;
		int ticks = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta=0;
			}

			if (timer >= 1000000000L) {
				if (Launcher.showFPS) {
					System.out.println("[i] Fps: " + ticks);
				}
				ticks = 0;
				timer = 0L;
			}
		}
		stop();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public Display getDisplay() {
		return display;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameState getGameState() {
		return gameState;
	}

	public GameOverState getGameOverState() {
		return gameOverState;
	}

	public MenuState getMenuState() {
		return menuState;
	}

	public TimeHandler getTimeHandler() {
		return timeHandler;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public void resetStates() {
		gameState.reset();
		gameOverState.reset();
		menuState.reset();
	}
}
