package com.redsponge.dodge.entities.actors.enemies.killer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.Enemy;
import com.redsponge.dodge.entities.actors.enemies.ICanKillEnemy;
import com.redsponge.dodge.gfx.AssetsHandler;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.utils.math.MathUtils;

public class EnemyKiller extends Enemy implements ICanKillEnemy {

	private Point goTo;
	private float speed;
	private int waitCounter;
	private int waitDelay;
	private boolean waiting;
	
	private List<Point> lastPoints;
	
	private boolean displayGoTo;
	
	public EnemyKiller(Handler handler, float x, float y, int width, int height, float speed, boolean center, int waitDelay) {
		super(handler, x, y, DodgeColor.PURPLE, width, height, speed, speed, true, Integer.MAX_VALUE, center);
		this.speed = speed;
		sprite = AssetsHandler.getImage(handler, "/assets/textures/entity/enemy/killer/enemy_killer.png");
		goTo = new Point();
		getTargetPoint();
		displayGoTo = false;
		lastPoints = new ArrayList<Point>();
		waitCounter = 0;
		this.waitDelay = waitDelay;
		waiting = false;
	}

	public void tick() {
		detectPlayer();
		if(waiting) {
			waitCounter++;
			if(waitCounter >= waitDelay) {
				waiting = false;
			}
			return;
		}
		if(!MathUtils.isRectangleTouchingPoint(this.asRectangle(), goTo)) {
			double angleToPoint = MathUtils.getAngleBetweenTwoPoints(this.x, this.y, goTo.getX(), goTo.getY());
			speedX = (float) MathUtils.getSpeedXByAngle(angleToPoint, speed);
			speedY = (float) MathUtils.getSpeedYByAngle(angleToPoint, speed);
			if(lastPoints.size() > 3) {
				lastPoints.remove(0);
			}
			lastPoints.add(new Point((int) x, (int) y));
			if(lastPoints.size() > 2) {
				if(lastPoints.get(0).equals(lastPoints.get(2))) {
					getTargetPoint();
				}
			}
			move();
		} else {
			getTargetPoint();
		}
		
	}
	
	public void getTargetPoint() {
		goTo.setLocation(Math.floor(Math.random()*handler.getCanvasWidth()), Math.floor(Math.random()*handler.getCanvasHeight()));
		waitCounter = 0;
		waiting = true;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, (int)x, (int)y, width, height, null);
		if(displayGoTo) {
			g.setColor(Color.RED);
			g.fillOval((int) goTo.getX()+5, (int) goTo.getY()+5, 10, 10);
		}
	}
	
}
