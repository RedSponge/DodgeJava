package com.redsponge.dodge.entities.actors.enemies;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.gfx.DodgeColor;
import java.awt.Graphics;
import java.util.ArrayList;

public class EnemySplitter extends Enemy {
	private int timeUntilSplit;
	private boolean splitted;
	private int splitterSpeed;
	private int startLifeTime;
	private ArrayList<EnemySplitterBullet> bullets = new ArrayList<EnemySplitterBullet>();

	public EnemySplitter(Handler handler, float x, float y, int width, int height, boolean bouncesFromWalls,
			int lifeTime, int timeUntilSplit, int splitterSpeed, boolean center) {
		super(handler, x, y, DodgeColor.LIGHT_BLUE, width, height, 0.0F, 0.0F, true, lifeTime * 2, center);
		this.timeUntilSplit = timeUntilSplit;
		this.splitterSpeed = splitterSpeed;
		this.startLifeTime = lifeTime;
		this.splitted = false;
	}

	public void render(Graphics g) {
		if (!this.splitted) {
			g.setColor(DodgeColor.LIGHT_BLUE);
			g.fillRect((int) this.x, (int) this.y, this.width, this.height);
		}
		if (this.splitted) {
			for (EnemySplitterBullet e : this.bullets) {
				e.render(g);
			}
		}
	}

	public void tick() {
		if (!this.splitted) {
			detectPlayer();
			this.timeUntilSplit -= 1;
			if ((this.timeUntilSplit <= 0) || (this.lifeTime <= 1)) {
				this.splitted = true;
				spawnSplitters();
			}
		} else if (this.splitted) {
			updateLifeTime();
			for (EnemySplitterBullet e : this.bullets) {
				e.tick();
			}
		}
	}

	private void spawnSplitters() {
		this.bullets.add(new EnemySplitterBullet(this.handler, this.x, this.y, this.color, this.width / 2,
				this.height / 2, -this.splitterSpeed, -this.splitterSpeed, this.bouncesFromWalls));
		this.bullets.add(new EnemySplitterBullet(this.handler, this.x + this.width / 2, this.y, this.color,
				this.width / 2, this.height / 2, this.splitterSpeed, -this.splitterSpeed, this.bouncesFromWalls));
		this.bullets.add(new EnemySplitterBullet(this.handler, this.x, this.y + this.height / 2, this.color,
				this.width / 2, this.height / 2, -this.splitterSpeed, this.splitterSpeed, this.bouncesFromWalls));
		this.bullets.add(new EnemySplitterBullet(this.handler, this.x + this.width / 2, this.y + this.height / 2,
				this.color, this.width / 2, this.height / 2, this.splitterSpeed, this.splitterSpeed,
				this.bouncesFromWalls));
		this.lifeTime = this.startLifeTime;
	}

	public void kill() {
		this.bullets.clear();
		super.kill();
	}
}
