package com.redsponge.dodge.entities.actors.enemies.follower;

import java.awt.Color;
import java.awt.Graphics;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.Player;
import com.redsponge.dodge.entities.actors.enemies.Enemy;
import com.redsponge.dodge.gfx.AssetsHandler;
import com.redsponge.dodge.utils.math.MathUtils;

public class EnemyFollower extends Enemy {

	private float speed;

	public EnemyFollower(Handler handler, float x, float y, int width, int height, float speed, int lifeTime,
			boolean center) {
		super(handler, x, y, Color.WHITE, width, height, speed, speed, true, lifeTime, center);
		this.speed = speed;
		sprite = AssetsHandler.getImage(handler, "/assets/textures/entity/enemy/follower/enemy_follower_basic.png");
		System.out.println(sprite);
		updateSpeed();
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(color);
		g.drawImage(sprite, (int) x, (int) y, width, height, null);
	}

	public void move() {
		updateSpeed();
		super.move();
	}

	private void updateSpeed() {
		Player player = handler.getGameState().getPlayer();
		double angleToPlayer = MathUtils.getAngleBetweenTwoPoints(x, y, player.getX(), player.getY());
		speedX = (float) MathUtils.getSpeedXByAngle(angleToPlayer, speed);
		speedY = (float) MathUtils.getSpeedYByAngle(angleToPlayer, speed);
	}

}
