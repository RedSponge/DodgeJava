package com.redsponge.dodge.entities.actors.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.redsponge.dodge.Handler;

public class EnemyKiller extends Enemy implements ICanKillEnemy {

	private Point goTo;
	
	public EnemyKiller(Handler handler, float x, float y, int width, int height, float speed, boolean center) {
		super(handler, x, y, Color.BLACK, width, height, speed, speed, false, Integer.MAX_VALUE, center);
	}

	public void tick() {
		if(this.x != goTo.getX() || this.y != goTo.getY()) {
			
		}
	}
	
	public void getTargetPoint() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
	}
	
}
