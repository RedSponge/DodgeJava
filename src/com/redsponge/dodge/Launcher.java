package com.redsponge.dodge;

public class Launcher {
	public static boolean showFPS = false;

	public static void main(String[] args) {
		System.out.println("[+] Starting Game");
		Dodge game = new Dodge(640, 480, "Java Dodge");
		game.start();
		System.out.println("[+] Game started successfully");
	}
}
