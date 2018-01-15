package com.redsponge.dodge.utils.timing;

public class TimeUtils {

	public static int getTicksFromSeconds(int seconds) {
		return seconds * 60;
	}

	public static int getTicksFromMilliseconds(int mil) {
		return (mil * 60) / 1000;
	}

}
