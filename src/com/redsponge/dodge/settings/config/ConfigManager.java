package com.redsponge.dodge.settings.config;

import java.util.HashMap;

import com.redsponge.dodge.Handler;

public class ConfigManager {

	public static HashMap<String, ConfigFile> configFiles;

	public static void init(Handler handler) {
		configFiles = new HashMap<String, ConfigFile>();

		configFiles.put("config", new ConfigFile(handler, "settings/config.dodgeconfig"));
	}

}
