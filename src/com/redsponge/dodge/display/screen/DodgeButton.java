package com.redsponge.dodge.display.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.utils.Utils;

public abstract class DodgeButton extends DodgeScreenComponent {
	protected Rectangle bounds;
	protected String text;
	protected boolean clicked;
	protected boolean active;
	protected boolean hovered;
	protected Color backgroundColor;
	protected Color fontColor;
	protected Color hoverColor;
	protected Font font;

	public DodgeButton(Handler handler, int x, int y, int width, int height, String text, Color backgroundColor,
			Font font, Color fontColor, Color hoverColor) {
		super(handler);
		this.bounds = new Rectangle(x, y, width, height);
		this.text = text;
		this.backgroundColor = backgroundColor;
		this.fontColor = fontColor;
		this.font = font;
		this.active = false;
		this.hovered = false;
		this.hoverColor = hoverColor;
	}

	public DodgeButton(Handler handler, int x, int y, int width, int height, String text, Color backgroundColor,
			Font font, Color fontColor) {
		this(handler, x, y, width, height, text, backgroundColor, font, fontColor, backgroundColor);
	}

	public abstract void trigger();

	public void tick() {
		updateClicked();
	}

	public void updateClicked() {
		clicked = false;
		hovered = Utils.isCoordInRect(handler.getMouseManager().x, handler.getMouseManager().y, bounds);
		if (hovered && handler.getMouseManager().left) {
			clicked = true;
		}
		if ((clicked) && (!active)) {
			active = true;
			trigger();
		} else if ((!clicked) && (active)) {
			active = false;
		}
	}

	public void render(Graphics g) {
		g.setColor((hovered) ? hoverColor : backgroundColor);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(fontColor);
		Utils.drawCenteredString(g, text, bounds, font);
	}
}
