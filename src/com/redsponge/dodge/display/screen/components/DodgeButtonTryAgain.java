package com.redsponge.dodge.display.screen.components;

import java.awt.Color;

import com.redsponge.dodge.GameActions;
import com.redsponge.dodge.Handler;
import com.redsponge.dodge.display.screen.DodgeButton;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.states.GameOverState;

public class DodgeButtonTryAgain extends DodgeButton {

	private GameOverState state;
	
	public DodgeButtonTryAgain(Handler handler, GameOverState state) {
		super(handler, handler.getCanvasWidth()/2-280, 300, 120, 50, "Try Again", DodgeColor.DARK_GREEN, DodgeFont.TRY_AGAIN_FONT, Color.BLACK, Color.GREEN);
		this.state = state;
	}
	
	public void trigger() {
		if ((state.canTryAgain)) {
			state.hasTriedAgain = true;
			GameActions.reset();
		}
	}

}
