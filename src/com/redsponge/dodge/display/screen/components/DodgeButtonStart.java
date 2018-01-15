package com.redsponge.dodge.display.screen.components;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.display.screen.DodgeButton;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.states.State;
import java.awt.Color;

public class DodgeButtonStart extends DodgeButton {
	public DodgeButtonStart(Handler handler) {
		super(handler, 250, 300, 100, 50, "start", DodgeColor.LIGHT_BLUE, DodgeFont.START_FONT, Color.BLACK, DodgeColor.LIGHTER_BLUE);
	}

	public void trigger() {
		State.setState(this.handler.getGameState());
	}
}
