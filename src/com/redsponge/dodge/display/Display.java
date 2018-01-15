package com.redsponge.dodge.display;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private int width;
	private int height;
	private String title;
	private Canvas canvas;

	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		setupFrame();
	}

	private void setupFrame() {
		this.frame = new JFrame(this.title);
		this.frame.setPreferredSize(new java.awt.Dimension(this.width, this.height));
		this.frame.setMinimumSize(new java.awt.Dimension(this.width, this.height));
		this.frame.setMaximumSize(new java.awt.Dimension(this.width, this.height));
		this.frame.setDefaultCloseOperation(3);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);

		this.canvas = new Canvas();
		this.canvas.setFocusable(false);
		this.frame.add(this.canvas);
		this.frame.pack();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}
}
