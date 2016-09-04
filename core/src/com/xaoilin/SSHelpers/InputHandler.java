package com.xaoilin.SSHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.xaoilin.Efficiency.DrawMenus;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.soloshape.SSGame;
import com.xaoilin.ui.SimpleButton;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputProcessor, TextInputListener {
    private Shapes myShapes;
    private GameWorld myWorld;

    private List<SimpleButton> menuButtons, gameOverButtons, nextLevelButtons, menuBadgesButtons, tierOneLevels,
            tierTwoLevels, continueButtons, purchaseButtons;

    private SimpleButton playButton, retryButton, menuButton, tier1Badge, tier2Badge, tier3Badge, backButton,
            rightArrow, leftArrow, playButtonScoreboard, retryButtonScoreboard, menuButtonScoreboard, muteButton,
            speakerButton, endGameBtn, playOnBtn, purchaseBtn1, purchaseBtn2, purchaseBtn3, purchaseOkBtn;

    private float scaleFactorX;
    private float scaleFactorY;
    public String userLevel;
    int once = 0;
    private Rectangle resetBounds;

    public InputHandler(GameWorld myWorld, float scaleFactorX, float scaleFactorY) {
        this.myWorld = myWorld;
        this.myShapes = myWorld.getShapes();
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

        initVariables();
        initButtons();
    }

    public void initVariables() {
        resetBounds = new Rectangle((float) (GameWorld.gameWidth * 0.2976), (float) (GameWorld.gameHeight * 0.74),
                (float) (GameWorld.gameWidth * 0.3796), (float) (GameWorld.gameHeight * 0.0625));
    }

    public void initButtons() {
        menuButtons = new ArrayList<SimpleButton>();
        menuBadgesButtons = new ArrayList<SimpleButton>();
        gameOverButtons = new ArrayList<SimpleButton>();
        nextLevelButtons = new ArrayList<SimpleButton>();
        tierOneLevels = new ArrayList<SimpleButton>();
        tierTwoLevels = new ArrayList<SimpleButton>();
        continueButtons = new ArrayList<SimpleButton>();
        purchaseButtons = new ArrayList<SimpleButton>();

        // Menu
        playButton = createButton(GameWorld.gameWidth * 0.3861, (GameWorld.gameHeight * 0.5), AssetLoader.playButton, 1);
        speakerButton = createButton(GameWorld.gameWidth * 0.8861, (GameWorld.gameHeight * 0.03), AssetLoader.speakerButton, 0.5);
        muteButton = createButton((GameWorld.gameWidth * 0.8861), (GameWorld.gameHeight * 0.03), AssetLoader.muteButton, 0.45);

        menuButtons.add(playButton);
        menuButtons.add(speakerButton);
        menuButtons.add(muteButton);

        // Menu Badges
        tier1Badge = createButton(GameWorld.gameWidth * 0.2, GameWorld.gameHeight * 0.4, AssetLoader.tier1Badge, 3);
        tier2Badge = createButton(GameWorld.gameWidth * 0.2, GameWorld.gameHeight * 0.4, AssetLoader.tier2Badge, 3);
        tier3Badge = createButton(GameWorld.gameWidth * 0.2, GameWorld.gameHeight * 0.4, AssetLoader.tier3Badge, 3);
        backButton = createButton(GameWorld.gameWidth * 0.1, GameWorld.gameHeight * 0.85, AssetLoader.backButton, 1);
        rightArrow = createButton(GameWorld.gameWidth * 0.85, GameWorld.gameHeight * 0.5, AssetLoader.rightArrow, 1);
        leftArrow = createButton(GameWorld.gameWidth * 0.1, GameWorld.gameHeight * 0.5, AssetLoader.leftArrow, 1);

        menuBadgesButtons.add(backButton);
        menuBadgesButtons.add(rightArrow);
        menuBadgesButtons.add(leftArrow);
        menuBadgesButtons.add(tier1Badge);
        menuBadgesButtons.add(tier2Badge);
        menuBadgesButtons.add(tier3Badge);

        // Game Over
        retryButton = createButton((GameWorld.gameWidth * 0.4861), (GameWorld.gameHeight * 0.5), AssetLoader.retryButton, 1);
        menuButton = createButton(GameWorld.gameWidth * 0.2861, (GameWorld.gameHeight * 0.5), AssetLoader.menuButton, 1);

        gameOverButtons.add(retryButton);
        gameOverButtons.add(menuButton);

        // Next Level
        menuButtonScoreboard = createButton(GameWorld.gameWidth * 0.12, (GameWorld.gameHeight * 0.56), AssetLoader.menuButton, 0.6);
        retryButtonScoreboard = createButton(GameWorld.gameWidth * 0.42, GameWorld.gameHeight * 0.56, AssetLoader.retryButton, 0.6);
        playButtonScoreboard = createButton(GameWorld.gameWidth * 0.27, (GameWorld.gameHeight * 0.56), AssetLoader.playButton, 0.6);

        nextLevelButtons.add(menuButtonScoreboard);
        nextLevelButtons.add(playButtonScoreboard);
        nextLevelButtons.add(retryButtonScoreboard);

        //Continue
        endGameBtn = createButton(160, 1150, AssetLoader.endGameBtn, 1.5);
        playOnBtn = createButton(550, 1130, AssetLoader.playOnBtn, 1.5);

        continueButtons.add(endGameBtn);
        continueButtons.add(playOnBtn);

        //Purchase
        purchaseOkBtn = createButton(400, 1200, AssetLoader.purchaseBox, 1);
        purchaseBtn1 = createButton(675, 700, AssetLoader.purchaseBox, 1.2);
        purchaseBtn2 = createButton(675, 875, AssetLoader.purchaseBox, 1.2);
        purchaseBtn3 = createButton(675, 1050, AssetLoader.purchaseBox, 1.2);

        purchaseButtons.add(purchaseOkBtn);
        purchaseButtons.add(purchaseBtn1);
        purchaseButtons.add(purchaseBtn2);
        purchaseButtons.add(purchaseBtn3);
    }

    // simple method to create a button with given co-ordinates and texture
    private SimpleButton createButton(double x, double y, TextureRegion texture, double scale) {
        return new SimpleButton((int) x, (int) y, (int) (texture.getRegionWidth() * scale),
                (int) (texture.getRegionHeight() * scale), texture, texture);
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        // System.out.println("x: " + screenX + "\ny: "+ screenY);
        if (myWorld.isMenu()) {
            if (resetBounds.contains(screenX, screenY)) {
                Gdx.input.getTextInput(this, "Reset", "", "Type yes to reset all stats");
                return true;
            }

            if (GameWorld.VOLUME == 1.0f) {
                speakerButton.isTouchDown(screenX, screenY);
            } else {
                muteButton.isTouchDown(screenX, screenY);
            }

            playButton.isTouchDown(screenX, screenY);

        } else if (myWorld.isTierOneMenu()) {

            if (backButton.isClicked(screenX, screenY)) {
                GameWorld.setMenu();
                GameWorld.reset();
            }

        } else if (myWorld.isReady()) {
            if (myShapes.isInstructions() == true) {
                myShapes.instructions();
            } else {
                myWorld.setRunning();
                myShapes.onClick();
            }

        } else if (myWorld.isRunning()) {
            myShapes.onClick();

        } else if (myWorld.isNextLevel()) {

            menuButtonScoreboard.isTouchDown(screenX, screenY);
            playButtonScoreboard.isTouchDown(screenX, screenY);
            retryButtonScoreboard.isTouchDown(screenX, screenY);

        } else if (myWorld.isGameOver()) {
            retryButton.isTouchDown(screenX, screenY);
            menuButton.isTouchDown(screenX, screenY);
            if (resetBounds.contains(screenX, screenY)) {
                myWorld.setContinueAnimation();
            }
        } else if (myWorld.isContinueMenu()) {
            if (Continue.continueMenuCounter > 150) {
                playOnBtn.isTouchDown(screenX, screenY);
                endGameBtn.isTouchDown(screenX, screenY);
            }

        } else if (myWorld.isPurchaseMenu()) {
            purchaseOkBtn.isTouchDown(screenX, screenY);
            purchaseBtn1.isTouchDown(screenX, screenY);
            purchaseBtn2.isTouchDown(screenX, screenY);
            purchaseBtn3.isTouchDown(screenX, screenY);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if (myWorld.isMenu()) {
            if (playButton.isTouchUp(screenX, screenY)) {
                GameWorld.reset();

                if (Memory.getHighestUserLevel() == 1) {
                    LevelFiles.gameLvl = 1;
                    GameWorld.setReady();
                } else {
                    myWorld.setTierOneMenu();
                }
                return true;
            } else if (speakerButton.isTouchUp(screenX, screenY)) {
                GameWorld.VOLUME = 0f;
                AssetLoader.soundtrack.setVolume(GameWorld.VOLUME);
                AssetLoader.soundtrack.stop();
                return true;
            } else if (muteButton.isTouchUp(screenX, screenY)) {
                GameWorld.VOLUME = 1.0f;
                AssetLoader.soundtrack.setVolume(GameWorld.VOLUME);
                AssetLoader.soundtrack.play();
                return true;
            }
        } else if (myWorld.isGameOver()) {
            if (retryButton.isTouchUp(screenX, screenY)) {
                GameWorld.reset();
                GameWorld.setReady();
            } else if (menuButton.isTouchUp(screenX, screenY)) {
                myWorld.setTierOneMenu();
            }
        } else if (myWorld.isNextLevel()) {
            if (menuButtonScoreboard.isTouchUp(screenX, screenY)) {
                GameWorld.reset();
                myWorld.setTierOneMenu();
                return true;
            } else if (retryButtonScoreboard.isTouchUp(screenX, screenY)) {
                GameWorld.reset();
                GameWorld.setReady();
                return true;
            } else if (playButtonScoreboard.isTouchUp(screenX, screenY)) {
                GameWorld.reset();
                if (LevelFiles.gameLvl == LevelFiles.maxLvl) {
                    GameWorld.setMenu();
                } else {
                    LevelFiles.gameLvl++;
                    GameWorld.setReady();
                }
                return true;
            }
        } else if (myWorld.isContinueMenu()) {
            if (playOnBtn.isTouchUp(screenX, screenY)) {
                Continue.resetContinue();
                //If the user has enough coins
                if (Memory.getCoins() - DrawMenus.coinIncrement >= 0) {
                    //Update the users coins
                    Memory.setCoins(Memory.getCoins() - DrawMenus.coinIncrement);
                    //Increase the coins required to play on
                    DrawMenus.coinIncrement = DrawMenus.coinIncrement * 2;
                    myWorld.setContinueAnimation();
                } else {
                    myWorld.setPurchaseMenu();
                }

            } else if (endGameBtn.isTouchUp(screenX, screenY)) {
                Continue.resetContinue();
                myWorld.setGameOver();
                DrawMenus.coinIncrement = 1;
            }
        } else if (myWorld.isPurchaseMenu()) {
            if (purchaseOkBtn.isTouchUp(screenX, screenY)) {
                myWorld.setContinueMenu();
            } else if (purchaseBtn1.isTouchUp(screenX, screenY)) {
                //add code for purchase here
                SSGame.m_platformResolver.requestPurchase(SSGame.productID_200coins);
            } else if (purchaseBtn2.isTouchUp(screenX, screenY)) {
                //add code for purchase here
                SSGame.m_platformResolver.requestPurchase(SSGame.productID_1000coins);
            } else if (purchaseBtn3.isTouchUp(screenX, screenY)) {
                SSGame.m_platformResolver.requestPurchase(SSGame.productID_2000coins);
            }
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }

    public List<SimpleButton> getMenuButtons() {
        return menuButtons;
    }

    public List<SimpleButton> getMenuBadgesButtons() {
        return menuBadgesButtons;
    }

    public List<SimpleButton> getGameOverButtons() {
        return gameOverButtons;
    }

    public List<SimpleButton> getNextLevelButtons() {
        return nextLevelButtons;
    }

    public List<SimpleButton> getContinueButtons() {
        return continueButtons;
    }

    public List<SimpleButton> getPurchaseButtons() {
        return purchaseButtons;
    }

    public List<SimpleButton> getTierOneButtons() {
        return tierOneLevels;
    }

    public List<SimpleButton> getTierTwoButtons() {
        return tierTwoLevels;
    }

    @Override
    public void input(String text) {
        if (text.contentEquals("") == true) {
            Gdx.input.getTextInput(this, "Reset", "", "Type y to reset all stats");
        } else if (text.contentEquals("y")) {
            // reset to level 1 with high scores of 0
            Memory.setHighestLevel(1);
            for (int level = 1; level <= LevelFiles.maxLvl; level++) {
                Memory.setHighScore(level, 0);
            }
            Memory.setCoins(100);
        } else if (Integer.parseInt(text) >= 1 && Integer.parseInt(text) <= LevelFiles.maxLvl) {
            Memory.setHighestLevel(Integer.parseInt(text));
        } else {
            Gdx.input.getTextInput(this, "Reset", "", "Type y to reset all stats");
        }

    }

    @Override
    public void canceled() {
        userLevel = "Cancelled";
    }

}
