package com.xaoilin.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.xaoilin.Efficiency.DrawMenus;
import com.xaoilin.GameWorld.GameRenderer;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.SSHelpers.InputHandler;
import com.xaoilin.SSHelpers.Memory;

public class GameScreen implements Screen {

	public static Stage stage;
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;
	public static InputMultiplexer inputMultiplexer = new InputMultiplexer();
	// This is the constructor, not the class declaration
	public GameScreen() {

		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 1080;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		world = new GameWorld((int) gameWidth, (int) gameHeight);
		
		stage = new Stage(new FitViewport(GameWorld.gameWidth, GameWorld.gameHeight));
		
		inputMultiplexer.addProcessor(GameScreen.stage);
		inputMultiplexer.addProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
//		inputMultiplexer.
//		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
		
		Gdx.input.setInputProcessor(inputMultiplexer);
		System.out.println("GAME HEIGHT: " + gameHeight);
		System.out.println("GAME WIDTH: " + gameWidth);
		renderer = new GameRenderer(world);
		world.setRenderer(renderer);
		
		
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
