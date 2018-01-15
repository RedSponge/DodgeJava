package com.redsponge.dodge.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	public static boolean[] keys = new boolean[256];
	public boolean left;
	public boolean right;
	public boolean up;
	public boolean down;

	public void tick() {
		this.left = keys[37];
		this.right = keys[39];
		this.up = keys[38];
		this.down = keys[40];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}
}
