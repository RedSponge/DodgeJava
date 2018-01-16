package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.EnemyFollowerKillable;

public class Wave5 extends Wave {
	
	public Wave5(Handler handler) {
		super(handler);
	}
	
	@Override
	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		ar.add(new EnemyWaveComponent(new EnemyFollowerKillable(handler, 0, 0, 20, 20, 2, true), 60));
		return ar;
	}
	
}
