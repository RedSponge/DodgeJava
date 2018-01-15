package com.redsponge.dodge.waves.parsing;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.Enemy;
import com.redsponge.dodge.entities.actors.enemies.EnemyBasic;
import com.redsponge.dodge.waves.EnemyWaveComponent;

public class WaveParser {

	public static EnemyWaveComponent parseEnemy(Handler handler, String enemy) throws EnemyIdNotFoundException {
		Enemy e = null;
		String[] parts = enemy.split(" ");
		String enemyID = parts[0];
		int x = 0, y = 0, width = 20, height = 20, speedX = 2, speedY = 2, lifetime = 10, spawnDelay = 10;
		boolean bounce = true;
		try {
			for (String s : parts) {
				s = s.trim();
				if (s.startsWith("x:")) {
					s = s.substring(2);
					x = Integer.parseInt(s);
				} else if (s.startsWith("y:")) {
					s = s.substring(2);
					y = Integer.parseInt(s);
				} else if (s.startsWith("width:")) {
					s = s.substring(6);
					width = Integer.parseInt(s);
				} else if (s.startsWith("height:")) {
					s = s.substring(7);
					height = Integer.parseInt(s);
				} else if (s.startsWith("spdx:")) {
					s = s.substring(5);
					speedX = Integer.parseInt(s);
				} else if (s.startsWith("spdy:")) {
					s = s.substring(5);
					speedY = Integer.parseInt(s);
				} else if (s.startsWith("lifetime:")) {
					s = s.substring(9);
					lifetime = Integer.parseInt(s);
				} else if (s.startsWith("spawndelay:")) {
					s = s.substring(11);
					spawnDelay = Integer.parseInt(s);
				} else if (s.startsWith("bounce:")) {
					s = s.substring(7);
					bounce = Boolean.parseBoolean(s);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}
		Class<?> c;
		Constructor<?> con;
		switch (enemyID) {
		case "enemy_basic":
			c = EnemyBasic.class;
			try {
				con = c.getConstructor(Handler.class, float.class, float.class, int.class, int.class, boolean.class,
						int.class, float.class, float.class, boolean.class);
				e = (Enemy) con.newInstance(handler, x, y, width, height, bounce, lifetime, speedX, speedY, false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		default:
			throw new EnemyIdNotFoundException(enemyID);
		}
		return new EnemyWaveComponent(e, spawnDelay);
	}

	public static ArrayList<EnemyWaveComponent> parseEnemies(Handler handler, String[] enemies) {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		for (String e : enemies) {
			try {
				if (e.trim().isEmpty() || e.trim().startsWith("[i]")) {
					continue;
				}
				ar.add(parseEnemy(handler, e));
			} catch (EnemyIdNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return ar;
	}

}
