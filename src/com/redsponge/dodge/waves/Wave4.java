package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.basic.EnemyBasic;
import com.redsponge.dodge.entities.actors.enemies.follower.EnemyFollower;
import com.redsponge.dodge.utils.timing.TimeUtils;

public class Wave4 extends Wave {

	public Wave4(Handler handler) {
		super(handler);
	}

	@Override
	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		for(int i = 0; i < 10; i++) {
			for(int y = 0; y < handler.getCanvasHeight()-20; y+= 50) {
				ar.add(new EnemyWaveComponent(new EnemyBasic(handler, 0, y, 20, 20, true, 100, 2, 0, false), 0));
			}
			for(int y = 25; y < handler.getCanvasHeight()-20; y+= 50) {
				ar.add(new EnemyWaveComponent(new EnemyBasic(handler, handler.getCanvasWidth()-20, y, 20, 20, true, 100, -2, 0, false), 0));
			}
		}
		ar.add(new EnemyWaveComponent(new EnemyFollower(handler, 0, 0, 20, 20, 2, TimeUtils.getTicksFromSeconds(10), false), 100));
		return ar;
	}
	
	
	
}
