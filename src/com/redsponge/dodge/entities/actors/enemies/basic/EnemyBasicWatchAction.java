package com.redsponge.dodge.entities.actors.enemies.basic;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.IWatchAllAction;
import com.redsponge.dodge.gfx.AssetsHandler;
import com.redsponge.dodge.utils.math.Vector;

public class EnemyBasicWatchAction extends EnemyBasic implements IWatchAllAction {

	public EnemyBasicWatchAction(Handler handler, float x, float y, int width, int height, boolean bouncesFromWalls, int lifeTime,
			boolean center) {
		super(handler, x, y, width, height, bouncesFromWalls, lifeTime, 3f, 3f, center);
		init();
	}

	public EnemyBasicWatchAction(Handler handler, float x, float y, int width, int height, boolean bouncesFromWalls, int lifeTime,
			float speedX, float speedY, boolean center) {
		super(handler, x, y, width, height, bouncesFromWalls, lifeTime, speedX, speedY, center);
		init();
	}

	public EnemyBasicWatchAction(Handler handler, float x, float y, int width, int height, boolean bouncesFromWalls, int lifeTime,
			Vector speed, boolean center) {
		super(handler, x, y, width, height, bouncesFromWalls, lifeTime, speed, center);
		init();
	}
	
	public EnemyBasicWatchAction(Handler handler, float x, float y, int width, int height, boolean bouncesFromWalls, int lifeTime, float speedX, float speedY) {
		this(handler, x, y, width, height, bouncesFromWalls, lifeTime, speedX, speedY, false);
	}
	
	public void init() {
		sprite = AssetsHandler.getImage(handler, "/assets/textures/entity/enemy/basic/enemy_basic_action.png");
	}
	
	public void tick() {
		tickCheckState(handler.getGameState(), this);
		super.tick();
	}

}
