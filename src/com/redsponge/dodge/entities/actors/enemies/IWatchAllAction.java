package com.redsponge.dodge.entities.actors.enemies;

import com.redsponge.dodge.entities.Entity;
import com.redsponge.dodge.states.GameState;

public interface IWatchAllAction {
	
	public default void tickCheckState(GameState s, Enemy me) {
		me.setLifeTime(Integer.MAX_VALUE);
		for(Entity e : s.getEntities().values()) {
			if(e instanceof ICanBeKilled || e instanceof ICanKillEnemy) {
				return;
			}
		}
		me.kill();
	}
	
}
