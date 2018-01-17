package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.basic.EnemyBasicWatchAction;
import com.redsponge.dodge.entities.actors.enemies.follower.EnemyFollowerKillable;
import com.redsponge.dodge.entities.actors.enemies.killer.EnemyKiller;
import com.redsponge.dodge.utils.timing.TimeUtils;

public class Wave5 extends Wave {
	
	public Wave5(Handler handler) {
		super(handler);
	}
	
	@Override
	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		ar.add(new EnemyWaveComponent(new EnemyFollowerKillable(handler, 0, 0, 20, 20, 3, true), 60));
		ar.add(new EnemyWaveComponent(new EnemyKiller(handler, 0, 0, 20, 20, 5, false, TimeUtils.getTicksFromMilliseconds(100)), 0));
		ar.add(new EnemyWaveComponent(new EnemyBasicWatchAction(handler, 0, 0, 20, 20, true, 1, 1, 1, false), 100));
		return ar;
	}
	
}
