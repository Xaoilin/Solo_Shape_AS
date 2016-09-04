package com.xaoilin.soloshape.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.xaoilin.soloshape.SSGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SoloShape";
		// config.useGL20 = true;
		config.width = 1080 / 3;
		config.height = 1920 / 3;
		// new LwjglApplication(new SSGame(), config);

		SSGame game = new SSGame();

		// Configure platform dependent code
		DesktopResolver res = new DesktopResolver(game);
		SSGame.setPlatformResolver(res);
		new LwjglApplication(game, config);
		//test
	}
}
