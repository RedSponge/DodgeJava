package com.redsponge.dodge.entities.actors.enemies.follower;

import java.awt.Color;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.ICanBeKilled;
import com.redsponge.dodge.gfx.AssetsHandler;

public class EnemyFollowerKillable extends EnemyFollower implements ICanBeKilled {

	public EnemyFollowerKillable(Handler handler, float x, float y, int width, int height, float speed, boolean center) {
		super(handler, x, y, width, height, speed, Integer.MAX_VALUE, center);
		setColor(Color.YELLOW);
		sprite = AssetsHandler.getImage(handler, "/assets/textures/entity/enemy/follower/enemy_follower_killable.png");
	}
	
	public void tick() {
		super.tick();
		tickKillerTouch(handler, this);
	}
}
