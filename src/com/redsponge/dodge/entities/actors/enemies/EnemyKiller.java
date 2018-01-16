package com.redsponge.dodge.entities.actors.enemies;

import com.redsponge.dodge.Handler;

public class EnemyKiller extends EnemyFollower implements ICanKillEnemy {

	public EnemyKiller(Handler handler, float x, float y, int width, int height, float speed,
			boolean center) {
		super(handler, x, y, width, height, speed, Integer.MAX_VALUE, center);
	}

}
