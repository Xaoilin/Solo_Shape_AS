package com.xaoilin.Efficiency;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ArrayMap;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.GameWorld.Helper;
import com.xaoilin.Levels.CheckWin;
import com.xaoilin.Levels.LevelDrawing;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.SSHelpers.AssetLoader;
import com.xaoilin.SSHelpers.Continue;
import com.xaoilin.SSHelpers.InputHandler;
import com.xaoilin.SSHelpers.Memory;
import com.xaoilin.Screens.GameScreen;
import com.xaoilin.soloshape.PlatformResolver;
import com.xaoilin.soloshape.SSGame;
import com.xaoilin.ui.Item;
import com.xaoilin.ui.SimpleButton;

public class DrawMenus {

	// Game Objects
	private Shapes myShapes;
	private GameWorld myWorld;
	private Helper helper;
	private LevelDrawing myLevelDrawing;
	private Continue continueClass;

	// Scroller
	private AssetManager assetManager;
	private Skin uiSkin;
	private Table scrollTable;
	ScrollPane scroll;
	public static ArrayMap<Integer, Item> levelBoxes;
	private Image[] greyStar = new Image[50];
	private Image[] goldStar = new Image[50];
	private Image[] threeStars = new Image[50];
	private Image[] twoStars = new Image[50];
	private Image[] oneStar = new Image[50];
	private Image[] noStars = new Image[50];

	// Assets
	private Sprite ssLogo;

	// Continue variables
	static int continueCounter = 0;
	static int continueMenuCounter = 0;
	static int onceColor = 0;
	double originalShapeColor;
	public static int coinIncrement = 10;
	// Game over variables
	static int gameOverCounter = 0;
	static int onceGameOver = 0;

	public static OrthographicCamera cam;
	private ArrayList<int[]> target;
	int gameWidth = GameWorld.gameWidth;
	int gameHeight = GameWorld.gameHeight;
	private List<SimpleButton> menuButtons, menuBadgesButtons, gameOverButtons, nextLevelButtons, continueButtons,
			purchaseButtons;
	SpriteBatch batcher;

	public DrawMenus(GameWorld world) {
		this.myWorld = world;
		this.menuButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek()).getMenuButtons();
		this.gameOverButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek()).getGameOverButtons();
		this.nextLevelButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek())
				.getNextLevelButtons();
		this.menuBadgesButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek())
				.getMenuBadgesButtons();
		this.continueButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek()).getContinueButtons();
		this.purchaseButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek()).getPurchaseButtons();
		target = myWorld.getStarTarget();

		cam = new OrthographicCamera();
		cam.setToOrtho(true, this.gameWidth, this.gameHeight);
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		initAssets();
		initGameObjects();
		initScroller();

	}

	private void initAssets() {
		ssLogo = new Sprite(AssetLoader.ssLogo);
		ssLogo.flip(false, true);
		for (int i = 0; i < goldStar.length; i++) {
			goldStar[i] = new Image(AssetLoader.yesStarTable);
			greyStar[i] = new Image(AssetLoader.noStarTable);
			threeStars[i] = new Image(AssetLoader.threeStars);
			twoStars[i] = new Image(AssetLoader.twoStars);
			oneStar[i] = new Image(AssetLoader.oneStar);
			noStars[i] = new Image(AssetLoader.noStars);
		}

	}

	private void initScroller() {
		levelBoxes = new ArrayMap<Integer, Item>();
		assetManager = new AssetManager();
		assetManager.load("data/scroller/animvs-logo.png", Texture.class);
		assetManager.load("data/scroller/uiskin.atlas", TextureAtlas.class);
		assetManager.finishLoading();
		// Choose font
		LabelStyle blackFont = new LabelStyle(AssetLoader.blackFontStage, Color.BLACK);

		// Loads the ui's skin to be used on this example:
		uiSkin = new Skin(Gdx.files.internal("data/scroller/uiskin.json"),
				assetManager.get("data/scroller/uiskin.atlas", TextureAtlas.class));

		Color novaCor = new Color(MathUtils.random(0.5f), MathUtils.random(0.5f), MathUtils.random(0.5f), 1f);
		Color blue = new Color(0, 0, 255, 1);
		// Decides which image to put into the item
		for (int i = 0; i < 100; i++) {
			levelBoxes.put(i, new Item(i, "LevelBox " + i, AssetLoader.levelBox, Color.WHITE, uiSkin));
		}

		scrollTable = new Table();

		// scrollTable.add(new Label("Tier 1", blackFont)).padLeft(210);
		// scrollTable.add(goldStar[0]).prefSize(100).padLeft(0);
		// scrollTable.add(new Label("1/26", blackFont));
		// scrollTable.row();

		// FONTS
		Label[] levelLabels = new Label[50];

		for (int i = 0; i < levelLabels.length; i++) {
			// make i final here so you can reference it inside
			// the anonymous class
			final int index = i;

			levelLabels[i] = new Label(i + 1 + "", blackFont);
			levelLabels[i].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					// When you click the button it will print this value you
					// assign.
					// That way you will know 'which' button was clicked and can
					// perform
					// the correct action based on it.
					// Gdx.app.log("button", "clicked " + index);
					if (Memory.getHighestUserLevel() > index) {
						LevelFiles.gameLvl = index + 1;
						GameWorld.reset();
						GameWorld.setReady();
					}
				};
			});
		}

		for (int j = 0; j < LevelFiles.maxLvl; j += 3) {
			// Level Boxes
			for (int i = j; i < j + 3; i++) {
				if (i < LevelFiles.maxLvl) {
					if (i == j)
						scrollTable.add(levelBoxes.getValueAt(i).getImage()).center().size(200, 300).padBottom(70);
					if (i == j + 1)
						scrollTable.add(levelBoxes.getValueAt(i).getImage()).center().size(200, 300).pad(0, 100, 70,
								100);
					if (i == j + 2)
						scrollTable.add(levelBoxes.getValueAt(i).getImage()).center().size(200, 300).padBottom(70);
				}
			}
			scrollTable.row();
			// Fonts

			for (int i = j; i < j + 3; i++) {
				if (i < LevelFiles.maxLvl) {
					scrollTable.add(levelLabels[i]).padTop(-450);
				}
			}
			scrollTable.row();
			Label ex = new Label(1 + "", blackFont);
			ex.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					// When you click the button it will print this value you
					// assign.
					// That way you will know 'which' button was clicked and can
					// perform
					// the correct action based on it.
					Gdx.app.log("button", "clicked ");

				};
			});
			// Stars
			for (int i = j; i < j + 3; i++) {
				if (i < LevelFiles.maxLvl) {
					if (Memory.getHighScore(i + 1) >= target.get(i)[2]) {
						scrollTable.add(threeStars[i]).prefHeight(100).prefWidth(262).padRight(0).padTop(-200);
					} else if (Memory.getHighScore(i + 1) >= target.get(i)[1]) {
						scrollTable.add(twoStars[i]).prefHeight(100).prefWidth(262).padRight(0).padTop(-200);
					} else if (Memory.getHighScore(i + 1) >= target.get(i)[0]) {
						scrollTable.add(oneStar[i]).prefHeight(100).prefWidth(262).padRight(0).padTop(-200);
					} else if (Memory.getHighScore(i + 1) < target.get(i)[0]) {
						scrollTable.add(noStars[i]).prefHeight(100).prefWidth(262).padRight(0).padTop(-200);
					}
				}

			}
			scrollTable.row();

		}

		final ScrollPane scroller = new ScrollPane(scrollTable);
		scroller.setScrollingDisabled(true, false);

		final Table table = new Table();
		table.setBounds(0, 300, 1080, GameWorld.gameHeight - 600);

		table.add(scroller);

		GameScreen.stage.addActor(table);
	}

	private void initGameObjects() {
		myShapes = myWorld.getShapes();
		helper = new Helper(myWorld);
		myLevelDrawing = new LevelDrawing(myWorld);
		continueClass = new Continue(myWorld, helper, myLevelDrawing, myShapes);
	}

	public void drawMenuTiers() {

		batcher.begin();
		menuBadgesButtons.get(0).draw(batcher); // Back button
		batcher.end();
	}

	public void drawTierOneMenu(int starsTierOne) {
		int maxUserLevel = Memory.getHighestUserLevel();

		// Draw Number of Stars at top
		// helper.drawText(starsTierOne + "/" + LevelFiles.maxLvl * 3, gameWidth
		// * 0.25, (gameHeight * 0.07), 0);
		// helper.drawTexture((gameWidth * 0.1), (gameHeight * 0.06), 0.6,
		// AssetLoader.yesStar);
		// Draw Coins at the top
		helper.drawTexture((gameWidth * 0.1), (gameHeight * 0.01), 1, AssetLoader.starCoin);
		helper.drawText("" + Memory.getCoins(), (gameWidth * 0.25), (gameHeight * 0.06), 5);

		drawMenuTiers();

		for (int i = 0; i < scrollTable.getCells().size; i++) {
			if (maxUserLevel >= i + 1) { // if the user has reached the level
				levelBoxes.getValueAt(i).getImage().setColor(Color.WHITE);
			} else {
				levelBoxes.getValueAt(i).getImage().setColor(Color.GRAY);
			}
		}

		// Scroll table
		GameScreen.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
		GameScreen.stage.draw();
	}

	public void drawStarTargets(double x, double y, int level) {
		double scale = 0.5;

		if (Memory.getHighScore(level) >= target.get(level - 1)[0]) {
			helper.drawTexture(gameWidth * (x), gameHeight * y, scale, AssetLoader.yesStar);
		} else {
			helper.drawTexture(gameWidth * (x), gameHeight * y, scale, AssetLoader.noStar);
		}

		if (Memory.getHighScore(level) >= target.get(level - 1)[1]) {
			helper.drawTexture(gameWidth * (x + 0.07), gameHeight * y, scale, AssetLoader.yesStar);
		} else {
			helper.drawTexture(gameWidth * (x + 0.07), gameHeight * y, scale, AssetLoader.noStar);
		}

		if (Memory.getHighScore(level) >= target.get(level - 1)[2]) {
			helper.drawTexture(gameWidth * (x + 0.14), gameHeight * y, scale, AssetLoader.yesStar);
		} else {
			helper.drawTexture(gameWidth * (x + 0.14), gameHeight * y, scale, AssetLoader.noStar);
		}
	}

	public void drawLevelUI() {

		helper.drawText("Level " + LevelFiles.gameLvl, gameWidth * 0.2870, gameHeight * 0.1042, 0);

		helper.drawTargetStars(target, 0.7);
	}

	public void drawNextLevelUI() {
		// Draw the levels and the score
		helper.drawScore();
		LevelDrawing.drawAllLevels();
		// Draw buttons on score board
		batcher.begin();
		for (SimpleButton button : nextLevelButtons) {
			button.draw(batcher);
		}
		batcher.end();

	}

	public void drawGameOverUI() {

		helper.drawScore();
		// Draw Loss Message
		if (CheckWin.gameOverMessage.startsWith("Not")) {
			helper.drawText(CheckWin.gameOverMessage, gameWidth * 0.1869, gameHeight * 0.2238, 0);
		} else if (CheckWin.gameOverMessage.startsWith("Screen")) {
			helper.drawText(CheckWin.gameOverMessage, gameWidth * 0.0569, gameHeight * 0.2538, 0);
		} else if (CheckWin.gameOverMessage.startsWith("Shape")) {
			helper.drawText(CheckWin.gameOverMessage, gameWidth * 0.0569, gameHeight * 0.2538, 0);
		}

		helper.drawText("Target: " + target.get(LevelFiles.gameLvl - 1)[0], gameWidth * 0.1269, gameHeight * 0.8438, 0);

		// Draw all game over buttons
		batcher.begin();
		for (SimpleButton button : gameOverButtons) {
			button.draw(batcher);
		}
		batcher.end();

		// Game Over Animation
		gameOverAnimation();
	}

	void gameOverAnimation() {
		gameOverCounter++;
		// System.out.println(myWorld.getScore());
		if (gameOverCounter == 1) {
			int coinsEarned = myWorld.getScore() / 100;
			// System.out.println(x);
			// Memory.setCoins(Memory.getCoins()+coinsEarned);
		}
	}

	public void drawPurchaseMenu() {
		continueClass.drawPurchaseMenu();

		batcher.begin();
		purchaseButtons.get(0).draw(batcher);
		purchaseButtons.get(1).draw(batcher);
		purchaseButtons.get(2).draw(batcher);
		purchaseButtons.get(3).draw(batcher);
		batcher.end();

		//purchase button 1
		helper.drawText("0.99", GameWorld.gameWidth*0.64, GameWorld.gameHeight*0.43, 5);
		helper.drawText("4.99", GameWorld.gameWidth*0.64, GameWorld.gameHeight*0.53, 5);
		helper.drawText("9.99", GameWorld.gameWidth*0.64, GameWorld.gameHeight*0.63, 5);

		helper.drawText("OKAY", GameWorld.gameWidth*0.39, GameWorld.gameHeight*0.710, 5);
	}

	public void drawContinueMenu() {
		continueClass.drawContinueMenu();
		if (Continue.continueMenuCounter > 150) {
			batcher.begin();
			continueButtons.get(0).draw(batcher); // End game button
			continueButtons.get(1).draw(batcher); // Play on button
			batcher.end();
			// number of coins required to continue level
			double resHeightOne = 0;
			double resHeightTwo = 0;
			if (gameHeight == 1728) {
				// Gdx.app.log("gameheight", "" + gameHeight);
				resHeightOne = 0.72625;
				resHeightTwo = 0.699;
			} else if (gameHeight == 1920) {
				// Gdx.app.log("gameheight", "" + gameHeight);
				resHeightOne = 0.65625;
				resHeightTwo = 0.694;
			}
			helper.drawText("" + coinIncrement, GameWorld.gameWidth * resHeightTwo, GameWorld.gameHeight * resHeightOne,
					6);
		}

	}

	public void drawContinueAnimation() {
		continueClass.drawContinueAnimation();
	}

	public void drawMenuUI() {

		helper.drawText("Solo Shape", (gameWidth * 0.2), (gameHeight * 0.1), 0);
		helper.drawText("RESET", (gameWidth * 0.33), (gameHeight * 0.74), 0);

		batcher.begin();
		ssLogo.setOrigin(ssLogo.getWidth() / 2, ssLogo.getHeight() / 2);
		ssLogo.setBounds((float) (gameWidth * 0.4), (float) (gameHeight * 0.2), 200, 200);
		ssLogo.rotate(1);
		ssLogo.draw(batcher);

		//Draws every menu button
//		for (SimpleButton button : menuButtons) {
//			button.draw(batcher);
//		}

		//Draws specific menu buttons - Preferred
		menuButtons.get(0).draw(batcher);
		if (GameWorld.VOLUME == 1.0f) {
			menuButtons.get(1).draw(batcher);
		} else {
			menuButtons.get(2).draw(batcher);
		}
		batcher.end();

	}

	public void drawLevelTarget(int level) {
		switch (level) {
			case 1:
				myShapes.setInstructions(true);
				if (myShapes.getClickCounterInstructions() == 0) {
					drawLevelUI();
				} else if (myShapes.getClickCounterInstructions() == 1) {
					helper.drawInstructions(LevelFiles.gameLvl);

				} else if (myShapes.getClickCounterInstructions() == 2) {
					helper.drawInstructions(LevelFiles.gameLvl);

				} else if (myShapes.getClickCounterInstructions() > 2) {
					myShapes.setInstructions(false);
					myWorld.setRunning();
					myShapes.setClickCounter(1);
				}
				break;
			case 3:
				myShapes.setInstructions(true);
				if (myShapes.getClickCounterInstructions() == 0) {
					drawLevelUI();
				} else if (myShapes.getClickCounterInstructions() == 1) {
					helper.drawInstructions(LevelFiles.gameLvl);
				} else if (myShapes.getClickCounterInstructions() > 1) {
					myShapes.setInstructions(false);
					myWorld.setRunning();
					myShapes.setClickCounter(1);
				}
				break;
			case 5:
				myShapes.setInstructions(true);
				if (myShapes.getClickCounterInstructions() == 0) {
					drawLevelUI();
				} else if (myShapes.getClickCounterInstructions() == 1) {
					helper.drawInstructions(LevelFiles.gameLvl);
				} else if (myShapes.getClickCounterInstructions() > 1) {
					myShapes.setInstructions(false);
					myWorld.setRunning();
					myShapes.setClickCounter(1);
				}
				break;
			default:
				if (myShapes.getClickCounterInstructions() <= 0) {
					drawLevelUI();
				} else {
					myWorld.setRunning();
					myShapes.setClickCounter(1);
				}
				break;
		}
	}

	public static void reset() {
		coinIncrement = 10;
		continueCounter = 0; // resets count down
		continueMenuCounter = 0;
		onceColor = 0;
	}

}
