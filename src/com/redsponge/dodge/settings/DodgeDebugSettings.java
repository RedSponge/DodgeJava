package com.redsponge.dodge.settings;

import com.redsponge.dodge.settings.config.ConfigManager;

public class DodgeDebugSettings {

	public static final boolean invulnerablePress = ConfigManager.configFiles.get("config").getBoolean("InvulnerableOnClick");
	public static final boolean[] registerWaves = {
			ConfigManager.configFiles.get("config").getBoolean("register1"),
			ConfigManager.configFiles.get("config").getBoolean("register2"),
			ConfigManager.configFiles.get("config").getBoolean("register3"),
			ConfigManager.configFiles.get("config").getBoolean("register4")
	};

}
