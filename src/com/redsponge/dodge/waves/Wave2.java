package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.EnemyFollower;

public class Wave2 extends Wave {
	public Wave2(Handler handler) {
		super(handler);
	}

	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		ar.add(new EnemyWaveComponent(new EnemyFollower(handler, 0, 0, 20, 20, 3, 500, true), 0));
		ar.addAll(WaveMoves.getBasicEnemyMash(handler, 5, 100));
		return ar;
	}
}
