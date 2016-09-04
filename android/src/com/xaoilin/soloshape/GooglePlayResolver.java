package com.xaoilin.soloshape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.pay.PurchaseManagerConfig;
import com.xaoilin.soloshape.SSGame;
import com.xaoilin.soloshape.PlatformResolver;

public class GooglePlayResolver extends PlatformResolver {
	private final static String GOOGLEKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi/YnxVfj44eBtHCCkXlL7b2WSj+Kqssp+IRdLKQZil6x0TsMbrYS0sgMc/5vl3/Ow5mL1wET2LsqwGHzP/FpQP3aQy49HlAxMpR9ABIIm5hSzTnA1j/CvAbZCzCZWAx1q0l3vMx7XyLnW3FZdBv23qvz50IeIuY0Jqmh2MKRm1/ymIDlFwTfAp7kEmTIpVd/RYgcNR8GWr41uT5iyOeQHBy1ENAvLaaADL/4pUjAqMVxUHUme9LUOYcal5h2PT9fo57HDvxYujnFdvYmqdWGIuNVkhVgxvQNLrsTIWx00An1HsQ2dHfZBsx3/CdLijg2AoZRVZOvKfcIYMtfZE4iqQIDAQAB";

	static final int RC_REQUEST = 10001; // (arbitrary) request code for the
											// purchase flow

	public GooglePlayResolver(SSGame game) {
		super(game);
//		Gdx.app.log("1","");
		PurchaseManagerConfig config = game.purchaseManagerConfig;
//		Gdx.app.log("2","");
		config.addStoreParam(PurchaseManagerConfig.STORE_NAME_ANDROID_GOOGLE, GOOGLEKEY);
//		Gdx.app.log("3","");
		initializeIAP(null, game.purchaseObserver, config);
//		Gdx.app.log("4","");
	}
}
