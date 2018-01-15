package com.redsponge.dodge.utils.math;

public class Vector {

	private double speedX, speedY, speed;

	public Vector(double speedX, double speedY, double speed) {
		this.speedX = speedX;
		this.speedY = speedY;
		this.speed = speed;
	}

	public Vector(double angle, double speed, boolean reverseAngle) {
		this(MathUtils.getSpeedXByAngle((reverseAngle) ? (MathUtils.reverseAngle(angle)) : angle, speed),
				MathUtils.getSpeedYByAngle((reverseAngle) ? (MathUtils.reverseAngle(angle)) : (angle), speed), speed);
	}

	public Vector(float x1, float y1, float x2, float y2, double speed, boolean reverseAngle) {
		this(MathUtils.getAngleBetweenTwoPoints(x1, y1, x2, y2), speed, reverseAngle);
	}

	public double getSpeedX() {
		return speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public double getSpeed() {
		return speed;
	}

}
