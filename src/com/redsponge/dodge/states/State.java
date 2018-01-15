package com.redsponge.dodge.states;

import java.awt.Graphics;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.waves.Wave;

public abstract class State {
	protected Handler handler;
	private static State state;

	public abstract void tick();

	public abstract void render(Graphics paramGraphics);

	public abstract void reset();

	public State(Handler handler) {
		this.handler = handler;
	}

	public static void setState(State newState) {
		state = newState;
		state.reset();
	}

	public static void setState(State newState, boolean regular, Wave w) {
		state = newState;
		if (!(state instanceof GameState)) {
			return;
		}
		((GameState) state).reset(regular, w);
	}

	public static State getState() {
		return state;
	}
}
