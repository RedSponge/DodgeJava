package com.redsponge.dodge;

import com.redsponge.dodge.display.Display;
import com.redsponge.dodge.input.KeyManager;
import com.redsponge.dodge.input.MouseManager;
import com.redsponge.dodge.input.files.FileManager;
import com.redsponge.dodge.states.GameOverState;
import com.redsponge.dodge.states.GameState;
import com.redsponge.dodge.states.MenuState;
import com.redsponge.dodge.utils.timing.TimeHandler;

public class Handler {
	private Dodge game;

	public Handler(Dodge game) {
		this.game = game;
	}

	public int getFrameWidth() {
		return game.getWidth();
	}

	public int getFrameHeight() {
		return game.getHeight();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public int getCanvasWidth() {
		return game.getDisplay().getCanvas().getWidth();
	}

	public int getCanvasHeight() {
		return game.getDisplay().getCanvas().getHeight();
	}

	public Display getDisplay() {
		return game.getDisplay();
	}

	public GameState getGameState() {
		return game.getGameState();
	}

	public GameOverState getGameOverState() {
		return game.getGameOverState();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public Dodge getDodge() {
		return game;
	}

	public TimeHandler getTimeHandler() {
		return game.getTimeHandler();
	}

	public FileManager getFileManager() {
		return game.getFileManager();
	}

	public MenuState getMenuState() {
		return game.getMenuState();
	}
}
