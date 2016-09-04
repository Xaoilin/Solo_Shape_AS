package com.xaoilin.GameWorld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.xaoilin.Efficiency.DrawMenus;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.Levels.CheckWin;
import com.xaoilin.Levels.DrawOutlines;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.Levels.WinAnimation;
import com.xaoilin.SSHelpers.AssetLoader;
import com.xaoilin.SSHelpers.Memory;
import com.xaoilin.SSHelpers.ReadFiles;
import com.xaoilin.Screens.GameScreen;
import com.xaoilin.ui.Item;

public class GameWorld {

    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;

    public static int score = 0;
    public static ArrayList<Integer> scoreArray = new ArrayList<Integer>();
    private float runTime = 0;
    public static float VOLUME = 0;
    public String userLevel = "";
    private ArrayList<int[]> targetStars = new ArrayList<int[]>();

    public static int gameWidth;
    public static int gameHeight;
    public boolean wonLevel;
    public boolean once = false;

    private LevelFiles myLevelFiles;
    private static Shapes myShapes;
    private CheckWin myCheck;
    private static Helper myHelper;
    private static GameRenderer myRenderer;
    private static WinAnimation myWin;
    private Memory myMemory;
    private DrawOutlines myOutlines;

    private static GameState currentState;
    public GameMode gameMode;

    public enum GameState {
        MENU, MENU_TIER_SELECTION, TIER_ONE_MENU, TIER_TWO_MENU, READY, RUNNING, GAME_OVER, NEXT_LEVEL, CONTINUE_MENU, CONTINUE_ANIMATION, PURCHASE_MENU
    }

    public enum GameMode {
        TIER_ONE, TIER_TWO
    }

    public GameWorld(int gameWidth, int gameHeight) {
        currentState = GameState.MENU;
        GameWorld.gameWidth = gameWidth;
        GameWorld.gameHeight = gameHeight;
        myShapes = new Shapes(this);
        myHelper = new Helper(this);
        myLevelFiles = new LevelFiles();
        myWin = new WinAnimation(this);
        myMemory = new Memory(this);
        myOutlines = new DrawOutlines(this);
        // myCheck = new CheckWin(this);
        initVariables();
        initTargets();

    }

    private void initVariables() {
        cam = new OrthographicCamera();
        cam.setToOrtho(true, GameWorld.gameWidth, GameWorld.gameHeight);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        if (Memory.getHighestUserLevel() < 1) {
            Memory.setHighestLevel(1);
        }
    }

    // SCORES
    private void initTargets() {

        ReadFiles readFiles = new ReadFiles();
        for (int i = 0; i < LevelFiles.maxLvl; i++) {
            int[] temp = readFiles.readStarTargets(i + 1);
            targetStars.add(temp);
        }

    }

    public void update(float delta) {
//		System.out.println("Circle: " + myShapes.circleObjects.get(0).radius);
        runTime += delta;
//		System.out.println("Current State: " + getCurrentState());
        switch (currentState) {
            case MENU:
                updateReady(delta);
                break;
            case TIER_ONE_MENU:

                break;
            case READY:
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            case NEXT_LEVEL:
                // Update High score
                if (score > Memory.getHighScore(LevelFiles.gameLvl)) {
                    Memory.setHighScore(LevelFiles.gameLvl, score);
                }
                break;
            default:
                break;
        }

        //for scroller and buttons to work
        if (currentState == GameState.TIER_ONE_MENU) {
            Gdx.input.setInputProcessor(GameScreen.inputMultiplexer);
        } else {
            Gdx.input.setInputProcessor(GameScreen.inputMultiplexer.getProcessors().peek());
        }

    }


    private void updateReady(float delta) {
        // shapes.update(runTime);
    }

    public void updateRunning(float delta) {

        if (delta > .15f) {
            delta = .15f;
        }

        myShapes.update(delta);

        if (myShapes.isAlive() == false) {

            myRenderer.prepareTransition(255, 0, 0, .3f); // Flash red for loss
            AssetLoader.gameover.play(VOLUME);
            currentState = GameState.CONTINUE_MENU;
//			currentState = GameState.GAME_OVER;
        }
    }

    public static void reset() {
        score = 0;
        myWin.localReset();
        myShapes.onRestart();
        myRenderer.resetVariables();
        myHelper.resetVariables();
        DrawMenus.reset();
//		System.out.println("MY WORLD RESET");
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public void setGameModeOne() {
        gameMode = GameMode.TIER_ONE;
    }

    public void setGameModeTwo() {
        gameMode = GameMode.TIER_TWO;
    }

    public boolean isGameModeOne() {
        return gameMode == GameMode.TIER_ONE;
    }

    public boolean isGameModeTwo() {
        return gameMode == GameMode.TIER_TWO;
    }

    public void setGameOver() {
        currentState = GameState.GAME_OVER;
    }

    public void setRunning() {
        currentState = GameState.RUNNING;
    }

    public static void setMenu() {
        currentState = GameState.MENU;
    }

    public static void setReady() {
        currentState = GameState.READY;
    }

    public void setNextLevel() {
        currentState = GameState.NEXT_LEVEL;

    }

    public void setMenuTierSelection() {
        currentState = GameState.MENU_TIER_SELECTION;
    }

    public void setTierOneMenu() {
        currentState = GameState.TIER_ONE_MENU;
    }

    public void setContinueMenu() {
        currentState = GameState.CONTINUE_MENU;
    }

    public void setPurchaseMenu() {
        currentState = GameState.PURCHASE_MENU;
    }


    public void setContinueAnimation() {
        currentState = GameState.CONTINUE_ANIMATION;
    }

    public boolean isTierOneMenu() {
        return currentState == GameState.TIER_ONE_MENU;
    }

    public boolean isTierTwoMenu() {
        return currentState == GameState.TIER_TWO_MENU;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public boolean isGameOver() {

        return currentState == GameState.GAME_OVER;
    }

    public boolean isContinueMenu() {
        return currentState == GameState.CONTINUE_MENU;
    }

    public boolean isPurchaseMenu() {
        return currentState == GameState.PURCHASE_MENU;
    }

    public boolean isContinueAnimation() {
        return currentState == GameState.CONTINUE_ANIMATION;
    }

    public boolean isMenu() {
        return currentState == GameState.MENU;
    }

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }

    public boolean isNextLevel() {
        return currentState == GameState.NEXT_LEVEL;
    }

    public boolean isMenuTierSelection() {
        return currentState == GameState.MENU_TIER_SELECTION;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        GameWorld.currentState = currentState;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public ArrayList<int[]> getStarTarget() {
        return targetStars;
    }

    public WinAnimation getWinAnimation() {
        return myWin;
    }

    public LevelFiles getLevelFiles() {
        return myLevelFiles;
    }

    public Shapes getShapes() {
        return myShapes;
    }

    public Helper getHelper() {
        return myHelper;
    }

    public CheckWin getCheckWin() {
        return myCheck;
    }

    public GameRenderer getRenderer() {
        return myRenderer;
    }

    public Memory getMemory() {
        return myMemory;
    }

    public DrawOutlines getOutlines() {
        return myOutlines;
    }

    public void setRenderer(GameRenderer renderer) {
        GameWorld.myRenderer = renderer;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public SpriteBatch getBatcher() {
        return batcher;
    }

}
