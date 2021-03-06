package com.redsponge.dodge.entities.actors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.Entity;
import com.redsponge.dodge.gfx.AssetsHandler;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.input.KeyManager;

public class Player extends LivingEntity {
	protected float speed;
	protected boolean invulnerable;
	@SuppressWarnings("unused")
	private static final Color INVULNERABLE_COLOR = DodgeColor.GOLD;
	private static BufferedImage INVULNERABLE_IMAGE;

	public Player(Handler handler, float x, float y, float speed, int width, int height) {
		super(handler, x, y, Color.GREEN, width, height, speed, speed, true);
		this.speed = speed;
		invulnerable = false;
		sprite = AssetsHandler.getImage(handler, "/assets/textures/entity/player/player.png");
		INVULNERABLE_IMAGE = AssetsHandler.getImage(handler, "/assets/textures/entity/player/player_invulnerable.png");
		init();
	}

	private void init() {
		x = Entity.getEntityXCenter(handler, this);
		y = Entity.getEntityYCenter(handler, this);
	}

	public void tick() {
		updateMovement();
	}

	public void render(Graphics g) {
		//g.setColor((invulnerable) ? INVULNERABLE_COLOR : color);
		g.drawImage((invulnerable)?INVULNERABLE_IMAGE:sprite, (int) x, (int) y, width, height, null);
	}

	private void updateMovement() {
		speedX = 0;
		speedY = 0;
		KeyManager km = handler.getKeyManager();
		if (km.left) {
			speedX -= speed;
		}
		if (km.right) {
			speedX += speed;
		}
		if (km.up) {
			speedY -= speed;
		}
		if (km.down) {
			speedY += speed;
		}
		move();
	}

	public float getSpeed() {
		return speed;
	}

	public void moveX() {
		x += speedX;
		if (x < 0.0F) {
			x = 0.0F;
		} else if (x + width > handler.getCanvasWidth())
			x = (handler.getCanvasWidth() - width);
	}

	public void moveY() {
		y += speedY;
		if (y < 0.0F) {
			y = 0.0F;
		} else if (y + height > handler.getCanvasHeight()) {
			y = (handler.getCanvasHeight() - height);
		}
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

	public boolean isInvulnerable() {
		return invulnerable;
	}
}
