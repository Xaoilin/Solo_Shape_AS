package com.xaoilin.soloshape;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.pay.Offer;
import com.badlogic.gdx.pay.OfferType;
import com.badlogic.gdx.pay.PurchaseManagerConfig;
import com.badlogic.gdx.pay.PurchaseObserver;
import com.badlogic.gdx.pay.Transaction;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.xaoilin.SSHelpers.AssetLoader;
import com.xaoilin.SSHelpers.Memory;
import com.xaoilin.Screens.SplashScreen;

public class SSGame extends Game {

	// ----- app stores -------------------------
	public static final int APPSTORE_UNDEFINED	= 0;
	public static final int APPSTORE_GOOGLE 	= 1;
	public static final int APPSTORE_OUYA 		= 2;
	public static final int APPSTORE_AMAZON 	= 3;
	public static final int APPSTORE_DESKTOP 	= 4;

	private int isAppStore = APPSTORE_UNDEFINED;

	//In App Products
//	public final static String productID_fullVersion = "fullversion";
	public final static String productID_200coins = "200coins";
	public final static String productID_1000coins = "1000coins";
	public final static String productID_2000coins = "2000coins";

	public static PlatformResolver m_platformResolver;
	public PurchaseManagerConfig purchaseManagerConfig;

	public PurchaseObserver purchaseObserver = new PurchaseObserver() {
		@Override
		public void handleRestore (Transaction[] transactions) {
			for (int i = 0; i < transactions.length; i++) {
				if (checkTransaction(transactions[i].getIdentifier(), true) == true) break;
			}
		}
		@Override
		public void handleRestoreError (Throwable e) {
			throw new GdxRuntimeException(e);
		}
		@Override
		public void handleInstall () {	}

		@Override
		public void handleInstallError (Throwable e) {
			Gdx.app.log("ERROR", "PurchaseObserver: handleInstallError!: " + e.getMessage());
			throw new GdxRuntimeException(e);
		}
		@Override
		public void handlePurchase (Transaction transaction) {
			checkTransaction(transaction.getIdentifier(), false);
		}
		@Override
		public void handlePurchaseError (Throwable e) {	//--- Amazon IAP: this will be called for cancelled
			throw new GdxRuntimeException(e);
		}
		@Override
		public void handlePurchaseCanceled () {	//--- will not be called by amazonIAP
		}
	};

	protected boolean checkTransaction (String ID, boolean isRestore) {
		boolean returnbool = false;

		if (productID_200coins.equals(ID)) {
			Gdx.app.log("checkTransaction", "Applying 200 coins!");
			Memory.setCoins(Memory.getCoins()+200);
			returnbool = true;
		}else if (productID_1000coins.equals(ID)) {
			Gdx.app.log("checkTransaction", "Applying 1000 coins!");
			Memory.setCoins(Memory.getCoins()+1000);
			returnbool = true;
		}else if (productID_2000coins.equals(ID)) {
			Gdx.app.log("checkTransaction", "Applying 2000 coins!");
			Memory.setCoins(Memory.getCoins()+2000);
			returnbool = true;
		}
		return returnbool;
	}

	public SSGame () {
		setAppStore(APPSTORE_GOOGLE);	// change this if you deploy to another platform

		// ---- IAP: define products ---------------------
		purchaseManagerConfig = new PurchaseManagerConfig();
		purchaseManagerConfig.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier(productID_200coins));
		purchaseManagerConfig.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier(productID_1000coins));
		purchaseManagerConfig.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier(productID_2000coins));
	}

	@Override
	public void create() {
		getPlatformResolver().requestPurchaseRestore();	// check for purchases in the past
		AssetLoader.load();

		setScreen(new SplashScreen(this));
		// setScreen(new GameScreen());
	}



	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

	public PlatformResolver getPlatformResolver() {
		return m_platformResolver;
	}
	public static void setPlatformResolver (PlatformResolver platformResolver) {
		m_platformResolver = platformResolver;
	}

	public int getAppStore () {
		return isAppStore;
	}
	public void setAppStore (int isAppStore) {
		this.isAppStore = isAppStore;
	}
}
