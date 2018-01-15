package com.redsponge.dodge.waves;

import com.redsponge.dodge.Handler;
import java.util.ArrayList;

public abstract class Wave {
	protected Handler handler;

	public Wave(Handler handler) {
		this.handler = handler;
	}

	public abstract ArrayList<EnemyWaveComponent> getWaveEnemies();
}
