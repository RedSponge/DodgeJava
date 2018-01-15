package com.redsponge.dodge.utils;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.redsponge.dodge.Handler;
import com.redsponge.dodge.entities.Entity;

public class Utils {
	public static void centerEntity(Entity e) {
		e.setX(e.getGameHandler().getCanvasWidth() / 2 - e.getWidth() / 2);
		e.setY(e.getGameHandler().getCanvasHeight() / 2 - e.getHeight() / 2);
	}

	public static boolean twoRectCollision(Rectangle rect1, Rectangle rect2) {
		return (rect1.x < rect2.x + rect2.width) && (rect1.x + rect1.width > rect2.x)
				&& (rect1.y < rect2.y + rect2.height) && (rect1.y + rect1.height > rect2.y);
	}

	public static Rectangle getRectangleFromEntity(Entity entity) {
		return new Rectangle((int) entity.getX(), (int) entity.getY(), entity.getWidth(), entity.getHeight());
	}

	public static void drawCenteredString(Graphics g, String text, Rectangle rect, java.awt.Font font) {
		FontMetrics metrics = g.getFontMetrics(font);
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + (rect.height - metrics.getHeight()) / 2 + metrics.getAscent();
		g.setFont(font);
		g.drawString(text, x, y);
	}

	public static boolean isCoordInRect(int x, int y, Rectangle rect) {
		return (x > rect.x) && (x < rect.x + rect.width) && (y > rect.y) && (y < rect.y + rect.height);
	}

	public static float getMidX(Entity e) {
		return e.getGameHandler().getCanvasWidth() / 2 - e.getWidth() / 2;
	}

	public static float getMidY(Entity e) {
		return e.getGameHandler().getCanvasHeight() / 2 - e.getHeight() / 2;
	}

	public static float getMidX(Handler handler, float width) {
		return handler.getCanvasWidth() / 2 - width / 2;
	}

	public static float getMidY(Handler handler, float height) {
		return handler.getCanvasHeight() / 2 - height / 2;
	}
}
