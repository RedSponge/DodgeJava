package com.redsponge.dodge.utils.timing;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.LivingEntity;
import com.redsponge.dodge.waves.EnemyWaveComponent;

public class TaskSpawnLivingEntity extends TaskOneTime {

	protected LivingEntity entity;

	public TaskSpawnLivingEntity(Handler handler, int timeUntilExecution, LivingEntity entity) {
		super(handler, timeUntilExecution);
		this.entity = entity;
	}

	public TaskSpawnLivingEntity(Handler handler, int timeUntilExecution, EnemyWaveComponent component) {
		this(handler, timeUntilExecution, component.getEnemy());
	}

	public void execute() {
		handler.getGameState().addEntity(entity);
	}

}
