package com.redsponge.dodge.entities.actors.enemies;

import com.redsponge.dodge.Handler;

public class EnemyFollowerKillable extends EnemyFollower {

	public EnemyFollowerKillable(Handler handler, float x, float y, int width, int height, float speed, boolean center) {
		super(handler, x, y, width, height, speed, Integer.MAX_VALUE, center);
	}
	
	public void tick() {
		super.tick();
	}

}
