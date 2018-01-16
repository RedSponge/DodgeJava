package com.redsponge.dodge.display.screen.components;

import java.awt.Color;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.display.screen.DodgeButton;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.states.State;

public class DodgeButtonBackToMainScreen extends DodgeButton {

	public DodgeButtonBackToMainScreen(Handler handler) {
		super(handler, handler.getCanvasWidth()/2+100, 300, 200, 50, "Back 2 Menu", DodgeColor.GOLD, DodgeFont.TRY_AGAIN_FONT, Color.BLACK);
	}

	@Override
	public void trigger() {
		State.setState(handler.getMenuState());
	}

}
