package com.redsponge.dodge.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class MouseManager extends MouseAdapter {
	public boolean left;
	public boolean middle;
	public boolean right;
	public int x;
	public int y;

	public void mousePressed(MouseEvent e) {
		update(e, true);
	}

	public void mouseReleased(MouseEvent e) {
		update(e, false);
	}

	public void mouseMoved(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
	}

	public void update(MouseEvent e, boolean setTo) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			left = setTo;
		}
		;
		if (SwingUtilities.isRightMouseButton(e)) {
			right = setTo;
		}
		;
		if (SwingUtilities.isMiddleMouseButton(e)) {
			middle = setTo;
		}
		;
		x = e.getX();
		y = e.getY();
	}
}
