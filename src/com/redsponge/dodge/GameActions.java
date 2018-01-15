package com.redsponge.dodge;

import com.redsponge.dodge.states.State;

public class GameActions {
	private static Handler handler;

	public static void init(Handler gameHandler) {
		handler = gameHandler;
	}

	public static void lose() {
		State.getState().render(handler.getDisplay().getCanvas().getBufferStrategy().getDrawGraphics());
		State.setState(handler.getGameOverState());
	}

	public static void reset() {
		handler.getDodge().resetStates();
		State.setState(handler.getGameState());
	}
}
