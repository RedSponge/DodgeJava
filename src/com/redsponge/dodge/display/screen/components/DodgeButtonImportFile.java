package com.redsponge.dodge.display.screen.components;

import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.display.screen.DodgeButton;
import com.redsponge.dodge.gfx.DodgeColor;
import com.redsponge.dodge.gfx.DodgeFont;
import com.redsponge.dodge.states.State;
import com.redsponge.dodge.waves.Wave;
import com.redsponge.dodge.waves.WaveCustom;
import com.redsponge.dodge.waves.parsing.WaveParser;

public class DodgeButtonImportFile extends DodgeButton {

	public DodgeButtonImportFile(Handler handler) {
		super(handler, 250, 375, 100, 50, "Import File", DodgeColor.LIGHT_BLUE, DodgeFont.VERSION_FONT, Color.BLACK,
				DodgeColor.LIGHTER_BLUE);
	}

	public void trigger() {

		JFileChooser fChooser = new JFileChooser();
		if (fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File f = fChooser.getSelectedFile();
			Wave w = new WaveCustom(handler, WaveParser.parseEnemies(handler, handler.getFileManager().readExternalFile(f.getPath()).split("\n")));
			while(!((WaveCustom) w).isReady()) {
				System.out.flush();
			}
			State.setState(handler.getGameState(), false, w);
			
		}
	}

}
