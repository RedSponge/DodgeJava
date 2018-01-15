package com.redsponge.dodge.waves;

import com.redsponge.dodge.entities.actors.enemies.Enemy;

public class EnemyWaveComponent {
	private Enemy enemy;
	private int timeUntilSpawn;

	public String toString() {
		return enemy.toString() + ", " + timeUntilSpawn;
	}

	public EnemyWaveComponent(Enemy enemy, int timeUntilSpawn) {
		this.enemy = enemy;
		this.timeUntilSpawn = timeUntilSpawn;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public int getTimeUntilSpawn() {
		return timeUntilSpawn;
	}
}
