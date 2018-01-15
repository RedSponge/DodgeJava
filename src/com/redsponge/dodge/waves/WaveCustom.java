package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;

public class WaveCustom extends Wave {

	private ArrayList<EnemyWaveComponent> wave;
	
	private boolean ready;

	public WaveCustom(Handler handler, ArrayList<EnemyWaveComponent> wave) {
		super(handler);
		this.wave = wave;
		this.ready = true;
	}

	@Override
	public ArrayList<EnemyWaveComponent> getWaveEnemies() {
		return wave;
	}
	
	public boolean isReady() {
		return ready;
	}

}
