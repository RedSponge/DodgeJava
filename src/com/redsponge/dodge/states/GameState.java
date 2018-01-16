package com.redsponge.dodge.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.actors.LivingEntity;
import com.redsponge.dodge.entities.actors.Player;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.settings.DodgeDebugSettings;
import com.redsponge.dodge.utils.timing.TaskOneTime;
import com.redsponge.dodge.utils.timing.TaskSpawnLivingEntity;
import com.redsponge.dodge.waves.EnemyWaveComponent;
import com.redsponge.dodge.waves.Wave;
import com.redsponge.dodge.waves.Wave1;
import com.redsponge.dodge.waves.Wave2;
import com.redsponge.dodge.waves.Wave3;
import com.redsponge.dodge.waves.Wave4;
import com.redsponge.dodge.waves.WaveCustom;
import com.redsponge.dodge.waves.parsing.WaveParser;

public class GameState extends State {
	private Player player;
	private Map<UUID, LivingEntity> entities;
	private ArrayList<Wave> waves;
	private ArrayList<EnemyWaveComponent> waveEnemies;
	private Wave wave1;
	private Wave wave2;
	private Wave wave3;
	private Wave wave4;
	private boolean reseting;
	private boolean isWaveRunning;
	private int time;
	private boolean waitingForNextWave;
	private int currentWave;

	public GameState(Handler handler, Player player) {
		super(handler);
		this.player = player;
	}

	public void tick() {
		if (reseting) {
			return;
		}
		player.tick();
		for (LivingEntity e : entities.values()) {
			e.tick();
		}
		if (waitingForNextWave) {
			if (entities.isEmpty()) {
				System.out.println("RUNNING NEW WAVE!");
				runWave();
				waitingForNextWave = false;
			}
		}
		tickDebug();
	}

	private void tickDebug() {
		if (DodgeDebugSettings.invulnerablePress) {
			if (handler.getMouseManager().left) {
				player.setInvulnerable(true);
			}
			if (handler.getMouseManager().right) {
				player.setInvulnerable(false);
			}
		}
		//player.setInvulnerable(true);
	}

	public void render(Graphics g) {
		renderBG(g);
		player.render(g);
		for (LivingEntity e : entities.values()) {
			e.render(g);
		}
	}

	public void reset() {
		reset(true, null);
	}
	
	public void reset(boolean regular, Wave w) {
		init(regular, w);
	}

	private void renderBG(Graphics g) {
		g.setColor(DodgeColor.DARK_PURPLE);
		g.fillRect(0, 0, handler.getFrameWidth(), handler.getFrameHeight());
	}

	public void initNormal() {
		init(true, null);
	}
	
	public void init(boolean regular, Wave w) {
		reseting = true;
		entities = new ConcurrentHashMap<UUID, LivingEntity>();
		handler.getTimeHandler().clearOneTimeTasks();
		time = 0;
		player.center();
		if (regular) {
			registerWaves();
		} else {
			registerWaves(w);
		}
	}

	private void registerWaves() {
		wave1 = new Wave1(handler);
		wave2 = new Wave2(handler);
		wave3 = new Wave3(handler);
		wave4 = new Wave4(handler);

		waves = new ArrayList<Wave>();
		waves.add(wave1);
		waves.add(wave2);
		waves.add(wave3);
		waves.add(wave4);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			registerWaves();
			return;
		}
		reseting = false;
		waitingForNextWave = false;
		currentWave = 0;
		runWave();
	}
	
	public void registerWaves(Wave wave) {
		waves = new ArrayList<Wave>();
		waves.add(wave);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			registerWaves(wave);
			return;
		}
		reseting = false;
		waitingForNextWave = false;
		currentWave = 0;
		runWave();
	}

	public void runCustomWave(Wave wave) {
		waves = new ArrayList<Wave>();
		waves.add(wave);
		reseting = false;
		waitingForNextWave = false;
		currentWave = 0;
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			registerWaves();
			return;
		}
		runWave();
	}
	
	public void runCustomWaveFromFile(String path) {
		ArrayList<EnemyWaveComponent> enemies = WaveParser.parseEnemies(handler, handler.getFileManager().readExternalFile(path).split("\n"));
		Wave w = new WaveCustom(handler, enemies);
		runCustomWave(w);
	}

	public void addEntity(LivingEntity entity) {
		entities.put(entity.getUUID(), entity);
	}

	public void removeEntity(LivingEntity entity) {
		entities.remove(entity.getUUID());
	}

	public Player getPlayer() {
		return player;
	}

	public void runWave() {
		if (reseting) {
			return;
		}
		try {
			waves.get(currentWave);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("We're done here!");
			return;
		}
		time = 0;

		waveEnemies = ((Wave) waves.get(currentWave)).getWaveEnemies();
		isWaveRunning = true;
		EnemyWaveComponent ewc;
		for (int i = 0; i < waveEnemies.size();) {
			ewc = waveEnemies.get(i);
			time += ewc.getTimeUntilSpawn();
			handler.getTimeHandler().scheduleOneTimeTask(new TaskSpawnLivingEntity(handler, time, ewc));
			waveEnemies.remove(i);
			if (waveEnemies.isEmpty()) {
				handler.getTimeHandler().scheduleOneTimeTask(new TaskOneTime(handler, 100) {
					public void execute() {
						System.out.println("WAITING!");
						handler.getGameState().setWaitingForNextWave(true);
						currentWave++;
					}
				});
			}
		}
	}

	public boolean isWaveRunning() {
		return isWaveRunning;
	}

	public void setWaveRunning(boolean isWaveRunning) {
		this.isWaveRunning = isWaveRunning;
	}

	public void setWaitingForNextWave(boolean waitingForNextWave) {
		this.waitingForNextWave = waitingForNextWave;
	}
}
