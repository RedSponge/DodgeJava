package com.redsponge.dodge.utils.math;

import java.awt.Point;
import java.awt.Rectangle;

public class MathUtils {

	public static double getAngleBetweenTwoPoints(double x1, double y1, double x2, double y2) {
		double xDiff = x2 - x1;
		double yDiff = y2 - y1;
		return Math.toDegrees(Math.atan2(yDiff, xDiff));
	}

	public static double getSpeedXByAngle(double angle, double speed) {
		return Math.cos(Math.toRadians(angle)) * speed;
	}

	public static double getSpeedYByAngle(double angle, double speed) {
		return Math.sin(Math.toRadians(angle)) * speed;
	}

	public static double reverseAngle(double angle) {
		return Math.abs((angle + 180 >= 360) ? (angle - 180) : (angle + 180)); // if angle + 180 >= 360 then return																		// angle - 180, else, return angle + 180
	}
	
	public static boolean isRectangleTouchingPoint(Rectangle r, Point p) {
		return (p.getX() >= r.getX() &&
			   p.getX() <= r.getX()+r.getWidth() &&
			   p.getY() <= r.getY()+r.getHeight() &&
			   p.getY() >= r.getY());
	}
}
