package com.redsponge.dodge.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.UUID;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.utils.Utils;

public abstract class Entity {
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	protected Handler handler;
	protected Color color;
	protected UUID uuid;

	public Entity(Handler handler, float x, float y, Color color, int width, int height, boolean center) {
		this.handler = handler;
		init(x, y, color, width, height, center);
	}

	private void init(float x, float y, Color color, int width, int height, boolean center) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.width = width;
		this.height = height;
		this.uuid = UUID.randomUUID();
		if (center)
			this.center();
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public void center() {
		Utils.centerEntity(this);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Handler getGameHandler() {
		return this.handler;
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public static float getEntityXCenter(Handler handler, Entity e) {
		return handler.getCanvasWidth() / 2 - e.getWidth() / 2;
	}

	public static float getEntityYCenter(Handler handler, Entity e) {
		return handler.getCanvasHeight() / 2 - e.getHeight() / 2;
	}
}
