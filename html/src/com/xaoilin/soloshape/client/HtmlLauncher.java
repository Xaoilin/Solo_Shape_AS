package com.xaoilin.soloshape.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.xaoilin.soloshape.SSGame;

public class HtmlLauncher extends GwtApplication {

	@Override
	public GwtApplicationConfiguration getConfig() {
		return new GwtApplicationConfiguration(540, 960);
	}

	@Override
	public ApplicationListener createApplicationListener() {
		SSGame game = new SSGame();

		// Configure platform dependent code
		HTMLResolver res = new HTMLResolver(game);
		SSGame.setPlatformResolver(res);
		return game;
	}
}