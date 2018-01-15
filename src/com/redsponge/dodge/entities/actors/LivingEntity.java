package com.redsponge.dodge.entities.actors;

import java.awt.Color;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.Entity;
import com.redsponge.dodge.utils.math.Vector;

public abstract class LivingEntity extends Entity {
	public static final boolean BOUNCES_FROM_WALLS_DEFAULT = true;
	public static final float DEFAULT_SPEED = 3.0F;
	protected float speedX;
	protected float speedY;

	public LivingEntity(Handler handler, float x, float y, Color color, int width, int height, float speedX,
			float speedY, boolean center) {
		super(handler, x, y, color, width, height, center);
		init(speedX, speedY);
	}

	public LivingEntity(Handler handler, float x, float y, Color color, int width, int height, Vector speed,
			boolean center) {
		this(handler, x, y, color, width, height, (float) speed.getSpeedX(), (float) speed.getSpeedY(), center);
	}

	private void init(float speedX, float speedY) {
		this.speedX = speedX;
		this.speedY = speedY;
	}

	public void move() {
		moveX();
		moveY();
	}

	public void moveX() {
		this.x += this.speedX;
	}

	public void moveY() {
		this.y += this.speedY;
	}

	public float getSpeedX() {
		return this.speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public float getSpeedY() {
		return this.speedY;
	}
}
