package com.redsponge.dodge.entities.actors.enemies;

import java.util.ArrayList;
import java.util.List;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.Entity;
import com.redsponge.dodge.states.GameState;

public interface ICanBeKilled {
	
	public default void detectKillers(Handler handler) {
		GameState state = handler.getGameState();
		List<ICanKillEnemy> enemies = new ArrayList<ICanKillEnemy>();
		for(Entity e : state.getEntities()) {
			if(e instanceof ICanKillEnemy) {
				enemies.add(e);
			}
		}
	}
	
}
