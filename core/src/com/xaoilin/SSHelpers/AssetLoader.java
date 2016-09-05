package com.xaoilin.SSHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	//Shapes
	public static Texture whiteCircle, blackCircle, snowflake, fourStar;

	public static Texture clockTexture, endGameTexture, playOnTexture, ButtonsTexture, BadgesTexture, logoTexture,
			ssLogo, noStars, oneStar, twoStars, threeStars, starCoin, blackButton,
			transparentButton, continueBackgroundTexture, purchaseMenuTexture, purchaseBoxTexture;

	public static TextureRegion clock, logo, tier1Badge, tier2Badge, tier3Badge, noStar, yesStar, goldStar, menuButton,
			retryButton, playButton, muteButton, speakerButton, rightArrow, leftArrow, backButton, levelBox, padlock,
			scoreboard, noStarTable, yesStarTable, continueBackground, purchaseMenu, purchaseBox, endGameBtn, playOnBtn;

	public static Music soundtrack;
	public static Sound nextlevel, gameover, starAchieved;
	public static BitmapFont coinFont, blackFont, whiteFont, redFont, blackFontStage, continueBlackFont, continueWhiteFont;
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"�`'<>";

	public static void load() {
		soundtrack = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
		nextlevel = Gdx.audio.newSound(Gdx.files.internal("sounds/nextlevel.wav"));
		gameover = Gdx.audio.newSound(Gdx.files.internal("sounds/gameover.wav"));
		starAchieved = Gdx.audio.newSound(Gdx.files.internal("sounds/starSound.wav"));

		ButtonsTexture = new Texture(Gdx.files.internal("data/ui/ButtonsTextureCompressed.png"));
		BadgesTexture = new Texture(Gdx.files.internal("data/ui/BadgesTexture.png"));

		clockTexture = new Texture(Gdx.files.internal("data/ui/potatoIce.png"));
		clock = new TextureRegion(clockTexture, 0, 0, 191, 229);
		clock.flip(false, true);

		endGameTexture = new Texture(Gdx.files.internal("data/ui/endGameBtn2.png"));
		endGameBtn = new TextureRegion(endGameTexture, 0, 0, 256, 124);
		endGameBtn.flip(false, true);
		playOnTexture = new Texture(Gdx.files.internal("data/ui/playOnBtn.png"));
		playOnBtn = new TextureRegion(playOnTexture, 0, 0, 245, 148);
		playOnBtn.flip(false, true);
		transparentButton = new Texture(Gdx.files.internal("data/ui/transparentBox.png"));
		continueBackgroundTexture = new Texture(Gdx.files.internal("data/ui/continueMenu.png"));
		continueBackground = new TextureRegion(continueBackgroundTexture, 0, 0, 586, 612);
		continueBackground.flip(false, true);
		purchaseMenuTexture = new Texture(Gdx.files.internal("data/ui/purchaseMenu.png"));
		purchaseMenu = new TextureRegion(purchaseMenuTexture, 0, 0, 586, 612);
		purchaseMenu.flip(false, true);
		purchaseBoxTexture = new Texture(Gdx.files.internal("data/ui/purchaseBox1.png"));
		purchaseBox = new TextureRegion(purchaseBoxTexture, 0, 0, 213, 99);
		starCoin = new Texture(Gdx.files.internal("data/ui/starCoin.png"));

		noStars = new Texture(Gdx.files.internal("data/ui/noStars.png"));
		oneStar = new Texture(Gdx.files.internal("data/ui/oneStar.png"));
		twoStars = new Texture(Gdx.files.internal("data/ui/twoStars.png"));
		threeStars = new Texture(Gdx.files.internal("data/ui/threeStars.png"));
		threeStars.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		levelBox = new TextureRegion(ButtonsTexture, 423, 520, 85, 132);
		padlock = new TextureRegion(ButtonsTexture, 610, 0, 203, 281);
		padlock.flip(false, true);
		backButton = new TextureRegion(ButtonsTexture, 184, 490, 203, 207);
		rightArrow = new TextureRegion(ButtonsTexture, 560, 510, 95, 150);
		leftArrow = new TextureRegion(ButtonsTexture, 560, 510, 95, 150);
		leftArrow.flip(true, false);
		tier1Badge = new TextureRegion(BadgesTexture, 0, 0, 204, 224);
		tier1Badge.flip(false, true);
		tier2Badge = new TextureRegion(BadgesTexture, 204, 0, 204, 224);
		tier2Badge.flip(false, true);
		tier3Badge = new TextureRegion(BadgesTexture, 408, 0, 204, 224);
		tier3Badge.flip(false, true);

		scoreboard = new TextureRegion(new Texture(Gdx.files.internal("data/ui/ScoreboardBlank.png")));
		scoreboard.flip(false, true);

		noStar = new TextureRegion(ButtonsTexture, 612, 281, 203, 207);
		noStar.flip(false, true);
		yesStar = new TextureRegion(ButtonsTexture, 409, 281, 203, 207);
		yesStar.flip(false, true);
		goldStar = new TextureRegion(ButtonsTexture, 0, 512, 150, 140);
		goldStar.flip(false, true);

		noStarTable = new TextureRegion(ButtonsTexture, 612, 281, 203, 207);
		yesStarTable = new TextureRegion(ButtonsTexture, 409, 281, 203, 207);

		menuButton = new TextureRegion(ButtonsTexture, 204, 281, 203, 207);
		retryButton = new TextureRegion(ButtonsTexture, 203, 0, 203, 207);
		playButton = new TextureRegion(ButtonsTexture, 406, 0, 203, 207);

		muteButton = new TextureRegion(ButtonsTexture, 0, 279, 202, 190);
		speakerButton = new TextureRegion(ButtonsTexture, 0, 0, 203, 172);

		//Shapes
		snowflake = new Texture(Gdx.files.internal("data/shapes/other/snowflake.png"));
		fourStar = new Texture(Gdx.files.internal("data/shapes/other/fourStar.png"));
		whiteCircle = new Texture(Gdx.files.internal("data/shapes/circles/whiteCircle.png"));

		blackCircle = new Texture(Gdx.files.internal("data/shapes/circles/blackCircle.png"));

		logoTexture = new Texture(Gdx.files.internal("data/logos/xaoilinLogo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 666);

		ssLogo = new Texture(Gdx.files.internal("data/logos/SSLogo.png"));

		blackFont = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		blackFont.getData().setScale(2f, -2f);
		blackFont.setColor(Color.BLACK);

		continueBlackFont = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		continueBlackFont.getData().setScale(1.3f, -1.3f);
		continueBlackFont.setColor(Color.BLACK);

		continueWhiteFont = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		continueWhiteFont.getData().setScale(1.1f, -1.1f);
		continueWhiteFont.setColor(Color.WHITE);
		
		coinFont = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		coinFont.getData().setScale(1.1f, -1.1f);
		coinFont.setColor(Color.WHITE);

		blackFontStage = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		blackFontStage.getData().setScale(2f, 2f);
		blackFontStage.setColor(Color.BLACK);

		whiteFont = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		whiteFont.getData().setScale(2f, -2f);
		whiteFont.setColor(Color.WHITE);

		redFont = new BitmapFont(Gdx.files.internal("data/fonts/King3.fnt"));
		redFont.getData().setScale(2f, -2f);
		redFont.setColor(Color.GOLD);

	}

	public static void dispose() {
		// We must dispose of the texture when we are finished.
		//Shapes
		whiteCircle.dispose();
		blackCircle.dispose();
		snowflake.dispose();
		fourStar.dispose();

		// Sounds
		soundtrack.dispose();
		nextlevel.dispose();
		gameover.dispose();
		starAchieved.dispose();

		// Fonts
		blackFont.dispose();
		whiteFont.dispose();
		redFont.dispose();
		blackFontStage.dispose();
		continueBlackFont.dispose();
		continueWhiteFont.dispose();
		coinFont.dispose();

		//Other
		noStars.dispose();
		oneStar.dispose();
		twoStars.dispose();
		threeStars.dispose();
		starCoin.dispose();
		continueBackgroundTexture.dispose();
		purchaseMenuTexture.dispose();
		clockTexture.dispose();
		purchaseBoxTexture.dispose();
		ButtonsTexture.dispose();
		BadgesTexture.dispose();
		logoTexture.dispose();
		ssLogo.dispose();
	}

}