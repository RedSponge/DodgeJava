package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.EnemyBasic;
import com.redsponge.dodge.entities.actors.enemies.EnemySplitter;

public class Wave3 extends Wave {

	public Wave3(Handler handler) {
		super(handler);
	}

	@Override
	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		for(int i = 0; i < 10; i++) {
			ar.add(new EnemyWaveComponent(new EnemyBasic(handler, 0, 0, 20, 20, true, 100, 5, 5), 1));
			ar.add(new EnemyWaveComponent(new EnemyBasic(handler, handler.getCanvasWidth()-20, 0, 20, 20, true, 100, -5, 5), 0));
			ar.add(new EnemyWaveComponent(new EnemyBasic(handler, 0, handler.getCanvasHeight()-20, 20, 20, true, 100, 5, -5), 0));
			ar.add(new EnemyWaveComponent(new EnemyBasic(handler, handler.getCanvasWidth()-20, handler.getCanvasHeight()-20, 20, 20, true, 100, -5, -5), 0));
		}
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth()/2-25, 0, 50, 50, true, 1000, 5, 5, false), 10));
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth()/2-25, handler.getCanvasHeight()-50, 50, 50, true, 1000, 5, 5, false), 0));
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth()/2-25, 0, 50, 50, true, 1000, 5, 5, false), 0));
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth()/2-25, 0, 50, 50, true, 1000, 5, 5, false), 0));
		return ar;
	}

}
