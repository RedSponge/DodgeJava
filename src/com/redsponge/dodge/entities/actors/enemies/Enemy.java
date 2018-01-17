package com.redsponge.dodge.entities.actors.enemies;

import java.awt.Color;

import com.redsponge.dodge.GameActions;
import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.LivingEntity;
import com.redsponge.dodge.states.GameState;
import com.redsponge.dodge.states.State;
import com.redsponge.dodge.utils.Utils;
import com.redsponge.dodge.utils.math.Vector;

public abstract class Enemy extends LivingEntity {
	protected boolean bouncesFromWalls;
	protected int lifeTime;

	public Enemy(Handler handler, float x, float y, Color color, int width, int height, float speedX, float speedY,
			boolean bouncesFromWalls, int lifeTime, boolean center) {
		super(handler, x, y, color, width, height, speedX, speedY, center);
		this.bouncesFromWalls = bouncesFromWalls;
		this.lifeTime = lifeTime;
	}

	public Enemy(Handler handler, float x, float y, Color color, int width, int height, Vector speed,
			boolean bouncesFromWalls, int lifeTime, boolean center) {
		this(handler, x, y, color, width, height, (float) speed.getSpeedX(), (float) speed.getSpeedY(),
				bouncesFromWalls, lifeTime, center);
	}

	public void move() {
		super.move();
		if (bouncesFromWalls) {
			if ((x < 0.0F) || (x + width > handler.getCanvasWidth())) {
				speedX *= -1.0F;
			}
			if ((y < 0.0F) || (y + height > handler.getCanvasHeight())) {
				speedY *= -1.0F;
			}

		} else if ((x < 0.0F) || (x + width > handler.getCanvasWidth()) || (y < 0.0F)
				|| (y + height > handler.getCanvasHeight())) {
			kill();
		}
	}

	public void updateLifeTime() {
		lifeTime -= 1;

		if (lifeTime <= 0) {
			kill();
		}
	}

	public void tick() {
		updateLifeTime();
		move();
		detectPlayer();
	}

	public void kill() {
		((GameState) State.getState()).removeEntity(this);
	}

	public void detectPlayer() {
		if (((State.getState() instanceof GameState))
				&& Utils.twoRectCollision(Utils.getRectangleFromEntity(this),
						Utils.getRectangleFromEntity(((GameState) State.getState()).getPlayer()))
				&& !((GameState) State.getState()).getPlayer().isInvulnerable()) {
			GameActions.lose();
		}
	}

	public boolean isBouncingFromWalls() {
		return bouncesFromWalls;
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}
}
