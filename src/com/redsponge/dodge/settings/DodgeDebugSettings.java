package com.redsponge.dodge.settings;

import com.redsponge.dodge.settings.config.ConfigManager;

public class DodgeDebugSettings {

	public static final boolean invulnerablePress = ConfigManager.configFiles.get("config")
			.getBoolean("InvulnerableOnClick");

}
