package com.redsponge.dodge.display.screen;

import com.redsponge.dodge.Handler;

public abstract class DodgeScreenComponent {
	protected Handler handler;

	public abstract void tick();

	public abstract void render(java.awt.Graphics paramGraphics);

	public DodgeScreenComponent(Handler handler) {
		this.handler = handler;
	}
}
