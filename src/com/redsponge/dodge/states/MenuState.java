
package com.redsponge.dodge.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.display.screen.DodgeScreenComponent;
import com.redsponge.dodge.display.screen.components.DodgeButtonImportFile;
import com.redsponge.dodge.display.screen.components.DodgeButtonStart;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.utils.Utils;

public class MenuState extends State {
	private ArrayList<DodgeScreenComponent> components = new ArrayList<DodgeScreenComponent>();

	public MenuState(Handler handler) {
		super(handler);
		init();
	}

	public void init() {
		components.add(new DodgeButtonStart(handler));
		components.add(new DodgeButtonImportFile(handler));
	}

	public void tick() {
		for (DodgeScreenComponent c : this.components) {
			c.tick();
		}
	}

	public void render(Graphics g) {
		renderTitle(g);
		for (DodgeScreenComponent c : this.components) {
			c.render(g);
		}
		renderVersion(g);
	}

	private void renderTitle(Graphics g) {
		g.setColor(Color.BLACK);
		Utils.drawCenteredString(g, "Java Dodge", new Rectangle(0, 0, handler.getCanvasWidth(), 300),
				DodgeFont.TITLE_FONT);
		Utils.drawCenteredString(g, "by RedSponge", new Rectangle(0, 0, handler.getCanvasWidth(), 450), DodgeFont.CREDIT_FONT);
	}

	private void renderVersion(Graphics g) {
		g.setColor(Color.BLACK);
		Utils.drawCenteredString(g, "Version: 0.2a", new Rectangle(0, handler.getCanvasHeight() - 20, 120, 20),
				DodgeFont.VERSION_FONT);
	}

	public void reset() {
	}
}
