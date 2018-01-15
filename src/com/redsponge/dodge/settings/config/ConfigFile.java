package com.redsponge.dodge.settings.config;

import com.redsponge.dodge.Handler;

public class ConfigFile {

	private String config;
	private String[] lines;

	public ConfigFile(Handler handler, String filepath, boolean isInternal) {
		if (isInternal) {
			config = handler.getFileManager().readInternalFile(filepath);
		} else {
			config = handler.getFileManager().readExternalFile(filepath);
		}
		lines = config.split("\n");
	}

	public ConfigFile(Handler handler, String filepath) {
		this(handler, filepath, true);
	}

	private String getEntry(String entry) {
		for (String line : lines) {
			if (line.startsWith(entry)) {
				return line.substring(entry.length() + 1);
			}
		}
		return "";
	}

	public boolean getBoolean(String entry) {
		return Boolean.parseBoolean(getEntry(entry));
	}

	public String getString(String entry) {
		return getEntry(entry);
	}

	public int getInt(String entry) {
		return Integer.parseInt(getEntry(entry));
	}

	public float getFloat(String entry) {
		return Float.parseFloat(getEntry(entry));
	}

}
