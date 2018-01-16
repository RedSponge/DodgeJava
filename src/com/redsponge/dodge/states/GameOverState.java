package com.redsponge.dodge.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.display.screen.DodgeScreenComponent;
import com.redsponge.dodge.display.screen.components.DodgeButtonBackToMainScreen;
import com.redsponge.dodge.display.screen.components.DodgeButtonTryAgain;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.utils.Utils;

public class GameOverState extends State {
	private int loseTextOpacity;
	public boolean canTryAgain;
	public boolean hasTriedAgain;
	private int counter;
	private boolean buttonsCreated;
	
	private boolean resetting = false;
	
	public GameOverState(Handler handler) {
		super(handler);
		this.loseTextOpacity = 0;
		this.canTryAgain = false;
		this.counter = 0;
		this.hasTriedAgain = false;
		this.buttonsCreated = false;
		this.resetting = false;
	}

	public void tick() {
		if(resetting) {
			return;
		}
		this.counter += 1;
		int cMax = 500;
		if (this.hasTriedAgain) {
			cMax = 100;
		}
		if (this.counter > cMax) {
			if(!buttonsCreated) {
				components.add(new DodgeButtonTryAgain(handler, this));
				components.add(new DodgeButtonBackToMainScreen(handler));
			}
			buttonsCreated = true;
			this.canTryAgain = true;
		}
		if(canTryAgain) {
			for(DodgeScreenComponent c : components) {
				c.tick();
			}
		}
	}

	public void render(Graphics g) {
		renderBG(g);
		renderLoseText(g);
		for(DodgeScreenComponent c : components) {
			c.render(g);
		}
	}

	public void reset() {
		this.resetting = true;
		this.loseTextOpacity = 0;
		this.canTryAgain = false;
		this.counter = 0;
		this.buttonsCreated = false;
		this.components = new ArrayList<DodgeScreenComponent>();
		this.resetting = false;
	}

	public void renderBG(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.handler.getCanvasWidth(), this.handler.getCanvasHeight());
	}

	private void renderLoseText(Graphics g) {
		Color c;
		try {
			c = new Color(255, 255, 255, this.loseTextOpacity);
		} catch (Exception e) {
			c = new Color(255, 255, 255, 255);
		}
		g.setColor(c);
		if (this.loseTextOpacity < 255) {
			this.loseTextOpacity += 1;
			if (this.hasTriedAgain) {
				this.loseTextOpacity += 5;
			}
		}
		Utils.drawCenteredString(g, "Game Over",
				new Rectangle(0, 0, this.handler.getCanvasWidth(), this.handler.getCanvasHeight() - 100),
				DodgeFont.GAME_OVER_FONT);
	}
}
