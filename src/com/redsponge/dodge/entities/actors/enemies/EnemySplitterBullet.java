package com.redsponge.dodge.entities.actors.enemies;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.gfx.DodgeColor;
import java.awt.Color;
import java.awt.Graphics;

public class EnemySplitterBullet extends Enemy {
	public EnemySplitterBullet(Handler handler, float x, float y, Color color, int width, int height, float speedX,
			float speedY, boolean bouncesFromWalls) {
		super(handler, x, y, color, width, height, speedX, speedY, bouncesFromWalls, Integer.MAX_VALUE, false);
	}

	public void render(Graphics g) {
		g.setColor(DodgeColor.LIGHT_BLUE);
		g.fillRect((int) this.x, (int) this.y, this.width, this.height);
	}

	public void tick() {
		move();
		detectPlayer();
	}
}
