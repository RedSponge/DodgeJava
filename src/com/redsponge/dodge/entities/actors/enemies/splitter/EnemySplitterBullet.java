package com.redsponge.dodge.entities.actors.enemies.splitter;

import java.awt.Color;
import java.awt.Graphics;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.Enemy;
import com.redsponge.dodge.gfx.AssetsHandler;

public class EnemySplitterBullet extends Enemy {
	public EnemySplitterBullet(Handler handler, float x, float y, Color color, int width, int height, float speedX,
			float speedY, boolean bouncesFromWalls) {
		super(handler, x, y, color, width, height, speedX, speedY, bouncesFromWalls, Integer.MAX_VALUE, false);
		sprite = AssetsHandler.getImage(handler, "/assets/textures/entity/enemy/splitter/enemy_splitter.png");
	}

	public void render(Graphics g) {
		g.drawImage(sprite, (int)x, (int)y, width, height, null);
	}

	public void tick() {
		move();
		detectPlayer();
	}
}
