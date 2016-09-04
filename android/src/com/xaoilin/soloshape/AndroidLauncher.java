package com.xaoilin.soloshape;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.content.Intent;
import android.os.Bundle;

public class AndroidLauncher extends AndroidApplication {
	SSGame game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		game = new SSGame();
		initialize(game, config);

		if (game.getAppStore() == SSGame.APPSTORE_GOOGLE) {
			SSGame.setPlatformResolver(new GooglePlayResolver(game));
		}

		game.getPlatformResolver().installIAP();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// InApp: dispose payment system(s)
		game.getPlatformResolver().dispose();
	}
}
