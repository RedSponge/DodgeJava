package com.redsponge.dodge.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.utils.Utils;

public class GameOverState extends State {
	private int loseTextOpacity;
	private boolean canTryAgain;
	private boolean hasTriedAgain;
	private int counter;

	public GameOverState(Handler handler) {
		super(handler);
		this.loseTextOpacity = 0;
		this.canTryAgain = false;
		this.counter = 0;
		this.hasTriedAgain = false;
	}

	public void tick() {
		this.counter += 1;
		int cMax = 500;
		if (this.hasTriedAgain) {
			cMax = 100;
		}
		if (this.counter > cMax) {
			this.canTryAgain = true;
		}
		if ((this.canTryAgain) && (this.handler.getMouseManager().left)) {
			this.hasTriedAgain = true;
			com.redsponge.dodge.GameActions.reset();
		}
	}

	public void render(Graphics g) {
		renderBG(g);
		renderLoseText(g);
	}

	public void reset() {
		this.loseTextOpacity = 0;
		this.canTryAgain = false;
		this.counter = 0;
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
		renderTryAgain(g);
	}

	private void renderTryAgain(Graphics g) {
		if (this.canTryAgain) {
			g.setColor(com.redsponge.dodge.gfx.DodgeColor.DARK_GREEN);
			Utils.drawCenteredString(
					g, "Click to try again", new Rectangle(0, this.handler.getCanvasHeight() / 2,
							this.handler.getCanvasWidth(), this.handler.getCanvasHeight() / 2),
					DodgeFont.TRY_AGAIN_FONT);
		}
	}
}
