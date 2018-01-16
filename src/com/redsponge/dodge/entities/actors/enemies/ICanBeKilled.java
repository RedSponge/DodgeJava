package com.redsponge.dodge.entities.actors.enemies;

import java.util.ArrayList;
import java.util.List;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.Entity;
import com.redsponge.dodge.states.GameState;
import com.redsponge.dodge.utils.Utils;

public interface ICanBeKilled {
	
	public default List<ICanKillEnemy> getKillers(Handler handler) {
		GameState state = handler.getGameState();
		List<ICanKillEnemy> enemies = new ArrayList<ICanKillEnemy>();
		for(Entity e : state.getEntities().values()) {
			if(e instanceof ICanKillEnemy) {
				enemies.add((ICanKillEnemy) e);
			}
		}
		return enemies;
	}
	
	public default boolean tickKillerTouch(Handler handler, Enemy me) {
		List<ICanKillEnemy> enemies = getKillers(handler);
		for(ICanKillEnemy e : enemies) {
			Enemy en = (Enemy) e;
			if(Utils.twoRectCollision(en.asRectangle(), me.asRectangle())) {
				en.kill();
				me.kill();
				return true;
			}	
		}
		return false;
	}
	
}
