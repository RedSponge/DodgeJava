package com.redsponge.dodge.waves;

import java.util.ArrayList;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.enemies.Enemy;
import com.redsponge.dodge.entities.actors.enemies.EnemyBasic;
import com.redsponge.dodge.utils.Utils;
import com.redsponge.dodge.utils.math.MathUtils;
import com.redsponge.dodge.utils.math.Vector;

public class WaveMoves {
	public static ArrayList<EnemyWaveComponent> getBasicEnemySequence(Handler handler, Enemy enemy, char axis,
			boolean startsFromEnd, int spacesBetween, int delayBetween) {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		int x = 0;
		int y = 0;
		int xm = spacesBetween;
		int ym = spacesBetween;
		if (startsFromEnd) {
			if (axis == 'x') {
				x = handler.getCanvasWidth() - enemy.getWidth();
				xm *= -1;
			} else if (axis == 'y') {
				y = handler.getCanvasHeight() - enemy.getHeight();
				ym *= -1;
			}
		}
		if (axis == 'x') {
			for (int xx = x; xx < handler.getCanvasWidth() - enemy.getWidth() / spacesBetween; xx += xm) {
				if (xx + enemy.getWidth() > handler.getCanvasWidth()) {
					break;
				}
				EnemyBasic e = new EnemyBasic(handler, xx, 0, enemy.getWidth(), enemy.getHeight(),
						enemy.isBouncingFromWalls(), enemy.getLifeTime(), 0, enemy.getSpeedY(), false);
				ar.add(new EnemyWaveComponent(e, delayBetween));
			}

		} else if (axis == 'y') {
			for (int yy = y; yy < handler.getCanvasHeight() - enemy.getHeight() / spacesBetween; yy += ym) {
				if (y + enemy.getHeight() > handler.getCanvasHeight()) {
					break;
				}
				EnemyBasic e = new EnemyBasic(handler, 0, yy, enemy.getWidth(), enemy.getHeight(),
						enemy.isBouncingFromWalls(), enemy.getLifeTime(), enemy.getSpeedX(), 0, false);
				ar.add(new EnemyWaveComponent(e, delayBetween));
			}
		}

		return ar;
	}

	public static ArrayList<EnemyWaveComponent> getBasicEnemyX(Handler handler, float speed, int timeUntilSpawn) {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		double angle1 = MathUtils.getAngleBetweenTwoPoints(0, 0, handler.getCanvasWidth() + 20,
				handler.getCanvasHeight() + 10); // [\] <- ANGLE
		double angle2 = MathUtils.getAngleBetweenTwoPoints(handler.getCanvasWidth() + 20, 0, 0,
				handler.getCanvasHeight() + 10); // [/] <- ANGLE
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, 0, 0, 20, 20, false, Integer.MAX_VALUE,
				new Vector(angle1, speed, false), false), timeUntilSpawn));
		ar.add(new EnemyWaveComponent(
				new EnemyBasic(handler, handler.getCanvasWidth() - 20, handler.getCanvasHeight() - 20, 20, 20, false,
						Integer.MAX_VALUE, new Vector(angle1, speed, true), false),
				0));
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, 0, handler.getCanvasHeight() - 20, 20, 20, false,
				Integer.MAX_VALUE, new Vector(angle2, speed, true), false), 0));
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, handler.getCanvasWidth() - 20, 0, 20, 20, false,
				Integer.MAX_VALUE, new Vector(angle2, speed, false), false), 0));
		return ar;
	}

	public static ArrayList<EnemyWaveComponent> getBasicEnemyCross(Handler handler, float speed, int timeUntilSpawn) {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, Utils.getMidX(handler, 20), 0, 20, 20, false,
				Integer.MAX_VALUE, 0, speed / 1.5f, false), timeUntilSpawn));
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, 0, Utils.getMidY(handler, 20), 20, 20, false,
				Integer.MAX_VALUE, speed, 0, false), 0));
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, handler.getCanvasWidth() - 20, Utils.getMidY(handler, 20),
				20, 20, false, Integer.MAX_VALUE, -speed, 0, false), 0));
		ar.add(new EnemyWaveComponent(new EnemyBasic(handler, Utils.getMidX(handler, 20),
				handler.getCanvasHeight() - 20, 20, 20, false, Integer.MAX_VALUE, 0, -speed / 1.5f, false), 0));
		return ar;
	}

	public static ArrayList<EnemyWaveComponent> getBasicEnemyMash(Handler handler, float speed, int timeUntilSpawn) {
		ArrayList<EnemyWaveComponent> ar = new ArrayList<EnemyWaveComponent>();
		ar.addAll(getBasicEnemyCross(handler, speed, timeUntilSpawn));
		ar.addAll(getBasicEnemyX(handler, speed, 0));
		return ar;
	}
}
