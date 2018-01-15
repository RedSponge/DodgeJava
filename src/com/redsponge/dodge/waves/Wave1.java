package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.EnemyBasic;
import com.redsponge.dodge.entities.actors.enemies.EnemySplitter;
import com.redsponge.dodge.utils.timing.TimeUtils;

public class Wave1 extends Wave {
	public Wave1(Handler handler) {
		super(handler);
	}

	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		ar.addAll(WaveMoves.getBasicEnemySequence(handler,
				new EnemyBasic(handler, 0.0F, 0.0F, 20, 20, false, 100, 1.0F, 0.0F, false), 'y', false, 60,
				TimeUtils.getTicksFromMilliseconds(200)));
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth() / 2 - 5,
				handler.getCanvasHeight() / 2 - 5, 10, 10, true, 500, 10, 2, false),
				TimeUtils.getTicksFromMilliseconds(500)));
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth() / 2 - 15,
				handler.getCanvasHeight() / 2 - 15, 30, 30, true, 500, 10, 2, false),
				TimeUtils.getTicksFromMilliseconds(500)));
		ar.add(new EnemyWaveComponent(new EnemySplitter(handler, handler.getCanvasWidth() / 2 - 25,
				handler.getCanvasHeight() / 2 - 25, 50, 50, true, 500, 10, 2, false),
				TimeUtils.getTicksFromMilliseconds(500)));
		return ar;
	}
}
