package com.xaoilin.GameWorld;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.xaoilin.Efficiency.DrawMenus;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.Levels.LevelDrawing;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.Levels.TierOneCheckWin;
import com.xaoilin.SSHelpers.AssetLoader;
import com.xaoilin.SSHelpers.InputHandler;
import com.xaoilin.SSHelpers.Memory;
import com.xaoilin.Screens.GameScreen;
import com.xaoilin.TweenAccessors.Value;
import com.xaoilin.TweenAccessors.ValueAccessor;
import com.xaoilin.ui.SimpleButton;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class GameRenderer {
	boolean locked = true;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;

	// Other
	private int gameHeight;
	private int gameWidth;

	public static boolean tier1Displayed;
	public static boolean tier2Displayed;
	public static boolean tier3Displayed;

	// Assets
	private Sprite ssLogo;

	// Game Objects
	private Shapes myShapes;
	private GameWorld myWorld;
	private Helper helper;
	private LevelDrawing myLevelDrawing;
	private DrawMenus myMenus;
	private Memory myMemory;

	// Tween stuff
	private TweenManager manager;
	private Value alpha = new Value();

	// Buttons
	private List<SimpleButton> nextLevelButtons;
	private Color transitionColor;

	public GameRenderer(GameWorld world) {
		myWorld = world;

		this.gameWidth = GameWorld.gameWidth;
		this.gameHeight = GameWorld.gameHeight;

		this.nextLevelButtons = ((InputHandler) GameScreen.inputMultiplexer.getProcessors().peek())
				.getNextLevelButtons();

		cam = new OrthographicCamera();
		cam.setToOrtho(true, this.gameWidth, this.gameHeight);
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		initGameObjects();
		initAssets();

		transitionColor = new Color();
		prepareTransition(255, 255, 255, .5f);
	}

	private void initGameObjects() {
		myShapes = myWorld.getShapes();
		helper = new Helper(myWorld);
		myLevelDrawing = new LevelDrawing(myWorld);
		myMemory = new Memory(myWorld);
		myMenus = new DrawMenus(myWorld);
	}

	private void initAssets() {
		ssLogo = new Sprite(AssetLoader.ssLogo);
		ssLogo.flip(false, true);
	}

	public void render(float delta, float runTime) {

		Gdx.gl.glClearColor(255 / 255f, 255 / 255f, 240 / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		int starsTierOne = myMemory.starsAchieved(1);
		// int starsTierTwo = myMemory.starsAchieved(2);
		int starsTierTwo = 0;

		if (myWorld.isMenu()) {
			myMenus.drawMenuUI();
		} else if (myWorld.isTierOneMenu()) {
			myMenus.drawTierOneMenu(starsTierOne);
		} else if (myWorld.isReady()) {

			// if the level exists the draw it else go to menu
			if (LevelFiles.gameLvl <= LevelFiles.maxLvl) {
				myMenus.drawLevelTarget(LevelFiles.gameLvl);
			} else {
				GameWorld.setMenu();
			}

		} else if (myWorld.isRunning()) {
			helper.drawScore();
			LevelDrawing.drawAllLevels();
		} else if (myWorld.isNextLevel()) {
			drawNextLevelUI();
		} else if (myWorld.isGameOver()) {
			myMenus.drawGameOverUI();
		} else if (myWorld.isContinueMenu()) {
			myMenus.drawContinueMenu();
		} else if (myWorld.isContinueAnimation()) {
			myMenus.drawContinueAnimation();
		}

		drawTransition(delta);

	}

	// *****************************************OTHER**********************************//

	private void drawNextLevelUI() {
		// Draw the levels and the score
		helper.drawScore();
		LevelDrawing.drawAllLevels();
		// // Draw buttons on score board
		batcher.begin();
		for (SimpleButton button : nextLevelButtons) {
			button.draw(batcher);
		}
		batcher.end();

	}

	public void prepareTransition(int r, int g, int b, float duration) {
		transitionColor.set(r / 255.0f, g / 255.0f, b / 255.0f, 1);
		alpha.setValue(1);
		Tween.registerAccessor(Value.class, new ValueAccessor());
		manager = new TweenManager();
		Tween.to(alpha, -1, duration).target(0).ease(TweenEquations.easeOutQuad).start(manager);
	}

	private void drawTransition(float delta) {
		if (alpha.getValue() > 0) {
			manager.update(delta);
			Gdx.gl.glEnable(GL20.GL_BLEND);
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(transitionColor.r, transitionColor.g, transitionColor.b, alpha.getValue());
			shapeRenderer.rect(0, 0, gameWidth, gameHeight);
			shapeRenderer.end();
			Gdx.gl.glDisable(GL20.GL_BLEND);

		}
	}

	public void resetVariables() {
		// reset variables
		LevelDrawing.once = true;
		LevelDrawing.orderArray.clear();
		LevelDrawing.colorArray.clear();
		LevelDrawing.obstacleArray.clear();
		
		// Must clear obstacle array in LevelFiles because it's not present in
		// every level therefore it's not overwritten
		LevelFiles.obstacleArray = new float[0][0];
	}

}
