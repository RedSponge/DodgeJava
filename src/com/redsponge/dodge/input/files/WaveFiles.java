package com.redsponge.dodge.input.files;

public class WaveFiles {

	public static String[] WAVE_CUSTOM_TEST;

	public static void init(FileManager f) {
		WAVE_CUSTOM_TEST = f.readInternalFile("waves/custom/test.wave").split("\n");
	}

}
