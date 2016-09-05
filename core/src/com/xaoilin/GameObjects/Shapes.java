package com.xaoilin.GameObjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.GameWorld.Helper;
import com.xaoilin.Levels.CheckWin;
import com.xaoilin.Levels.LevelDrawing;
import com.xaoilin.Levels.LevelFiles;
import com.xaoilin.Levels.TierOneCheckWin;
import com.xaoilin.Levels.TierOneLevelFiles;

public class Shapes {

	public static int clickCounter, clickCounterInstructions, currentShapes = 0, batchNumber = 0;
	public boolean instructions = true;
	public static boolean isAlive;
	int once = 0;
	public final static int SHAPES_SIZE = 150;
	public final static int OBSTACLES_SIZE = 20;

	//Polygons
	public static Polygon[] polyShapes = new Polygon[Shapes.SHAPES_SIZE];
	public static Polygon[] polyObstacles = new Polygon[Shapes.OBSTACLES_SIZE];
	
	// Array
	public float type, x, y, width, height, rotation, speed, color, pulsating, singleRotation;

	// Shape Objects stored in arrays
	public ArrayList<Triangle> triangleObjects = new ArrayList<Triangle>();
	public ArrayList<Square> squareObjects = new ArrayList<Square>();
	public ArrayList<Circles> circleObjects = new ArrayList<Circles>();
	public ArrayList<Pentagon> pentagonObjects = new ArrayList<Pentagon>();
	public ArrayList<FiveStar> fiveStarObjects = new ArrayList<FiveStar>();
	public ArrayList<Snowflake> snowflakeObjects = new ArrayList<Snowflake>();

	// Shape Objects stored in arrays
	public ArrayList<Triangle> triangleObstacles = new ArrayList<Triangle>();
	public ArrayList<Square> squareObstacles = new ArrayList<Square>();
	public ArrayList<Circles> circleObstacles = new ArrayList<Circles>();
	public ArrayList<Pentagon> pentagonObstacles = new ArrayList<Pentagon>();
	public ArrayList<FiveStar> fiveStarObstacles = new ArrayList<FiveStar>();
	public ArrayList<Snowflake> snowflakeObstacles = new ArrayList<Snowflake>();

	// Game Objects
	private GameWorld myWorld;
	private CheckWin myCheck;
	private TierOneCheckWin tierOneCheckWin;
	private Helper myHelper;
	private TierOneLevelFiles myTierOne;

	public Shapes(GameWorld world) {
		myWorld = world;
		init();
	}

	public void init() {
		clickCounter = 0;
		isAlive = true;
		myTierOne = new TierOneLevelFiles();
		myCheck = new CheckWin(this);
		tierOneCheckWin = new TierOneCheckWin(this);
		myHelper = new Helper(myWorld);

		// Initialize all objects
		for (int i = 0; i < SHAPES_SIZE; i++) {
			Square square = new Square();
			Circles circle = new Circles();
			Triangle triangle = new Triangle();
			Pentagon pentagon = new Pentagon();
			FiveStar fiveStar = new FiveStar();
			Snowflake snowflake = new Snowflake();

			squareObjects.add(square);
			circleObjects.add(circle);
			triangleObjects.add(triangle);
			pentagonObjects.add(pentagon);
			fiveStarObjects.add(fiveStar);
			snowflakeObjects.add(snowflake);
		}

		// Initialize all obstacles
		for (int i = 0; i < OBSTACLES_SIZE; i++) {
			Square square = new Square();
			Circles circle = new Circles();
			Triangle triangle = new Triangle();
			Pentagon pentagon = new Pentagon();
			FiveStar fiveStar = new FiveStar();
			Snowflake snowflake = new Snowflake();

			squareObstacles.add(square);
			circleObstacles.add(circle);
			triangleObstacles.add(triangle);
			pentagonObstacles.add(pentagon);
			fiveStarObstacles.add(fiveStar);
			snowflakeObstacles.add(snowflake);
		}
		
		// Populate batch and polygon
		for (int i = 0; i < polyShapes.length; i++) {
			polyShapes[i] = new Polygon();
		}
		// Populate Obstacle polygons
		for (int i = 0; i < polyObstacles.length; i++) {
			polyObstacles[i] = new Polygon();
		}

	}

	public void update(float delta) {
		readLevel();
		checkLevel();
	}

	private void checkLevel() {
		if (currentShapes != 0) {
			// if level 1-12 check tier one
			if (myTierOne.getLevel() >= 1 && myTierOne.getLevel() <= LevelFiles.maxLvl) {
				tierOneCheckWin.checkLevel(myTierOne.getLevel());
			}
		}
	}

	public void readLevel() {
		if (once == 0) {
			once++;
			// needed to initialize the level with a filename
			myTierOne.file(LevelFiles.gameLvl);
			String fileName = myTierOne.getFileName();

			// Set the game level
			for (int i = 1; i <= LevelFiles.maxLvl; i++) {
				if (fileName.contentEquals("Level" + i + ".txt")) {
					LevelFiles.gameLvl = i;
				}
			}
		}

		// Reads the normal array of shapes
		float levelArray[][] = myTierOne.getLevelArray();

		for (int i = 0; i < levelArray.length; i++) {
			for (int j = 0; j < levelArray[i].length; j++) {
				// a = 1 so that in checkwin the polys and the objects line up
				// 1,2,3..
				for (int a = 0; a < SHAPES_SIZE; a++) {
					if (i == a && clickCounter == (a + 1)) {
						currentShapes = a + 1;
						// sets the type x y width height etc.
						setArrayVariables(levelArray[i][0], levelArray[i][1], levelArray[i][2], levelArray[i][3],
								levelArray[i][4], levelArray[i][5], levelArray[i][6], levelArray[i][7],
								levelArray[i][8], levelArray[i][9]);
						// adds the CURRENT type x y width to the RELEVANT shape
						Shortcut((int) type, circleObjects.get(a), squareObjects.get(a), triangleObjects.get(a),
								fiveStarObjects.get(a), pentagonObjects.get(a), snowflakeObjects.get(a), false);
					}
				}
			
			}
		}

		// Reads the obstacle array of level
		float obstacleArray[][] = myTierOne.getObstacleArray();

		if (obstacleArray.length != 0) {
			for (int i = 0; i < obstacleArray.length; i++) {
				for (int j = 0; j < obstacleArray[i].length; j++) {
					for (int a = 0; a < OBSTACLES_SIZE; a++) {
						if (i == a) {

							setArrayVariables(obstacleArray[i][0], obstacleArray[i][1], obstacleArray[i][2],
									obstacleArray[i][3], obstacleArray[i][4], obstacleArray[i][5], obstacleArray[i][6],
									obstacleArray[i][7], obstacleArray[i][8], obstacleArray[i][9]);

							Shortcut((int) type, circleObstacles.get(a), squareObstacles.get(a),
									triangleObstacles.get(a), fiveStarObstacles.get(a), pentagonObstacles.get(a),
									snowflakeObstacles.get(a), true);
						}
					}
				}
			}
		}

	}

	private void Shortcut(int type, Circles circ, Square square, Triangle tri, FiveStar fiveStar, Pentagon pentagon,
			Snowflake snowflake, boolean obstacle) {

		switch (type) {
		case 1:
			circ.normalCircle((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			break;
		case 2:
			square.drawSquare((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			break;
		case 3:
			tri.drawTriangle((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			break;
		case 4:
			// square.drawRectangle((int) x, (int) y, (float) width, (float)
			// height, rotation, speed, color, pulsating);
			break;
		case 5:
			if (!obstacle)
				fiveStar.normalStar((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			if (obstacle)
				fiveStar.staticStar((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			break;
		case 6:
			pentagon.normalPentagon((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			break;
		case 7:
			snowflake.snowflake((int) x, (int) y, (float) width, (float) height, rotation, speed, color, pulsating, singleRotation);
			break;
		default:
			Gdx.app.log("Error", "Shapes Class, Shortcut Method");
			break;
		}
	}

	public void onRestart() {
		System.out.println("Shapes OnRestart Called");
		batchNumber = 0;
		clickCounter = 0;
		clickCounterInstructions = 0;
		isAlive = true;
		currentShapes = 0;
		once = 0;

		for (Circles circles : circleObjects) {
			circles.resetVariables();
		}

		for (Square squares : squareObjects) {
			squares.resetVariables();
		}

		for (Triangle triangles : triangleObjects) {
			triangles.resetVariables();
		}

		for (FiveStar star : fiveStarObjects) {
			star.resetVariables();
		}

		for (Pentagon pentagon : pentagonObjects) {
			pentagon.resetVariables();
		}

		for (Snowflake snowflake : snowflakeObjects) {
			snowflake.resetVariables();
		}

		GameWorld.scoreArray.clear();
		// setRGB(0, 255, 255);
		
		for (int i = 0; i < polyShapes.length; i++) {
			polyShapes[i] = new Polygon();
		}
		for (int i = 0; i < polyObstacles.length; i++) {
			polyObstacles[i] = new Polygon();
		}
	}

	public void onClick() {
		if (isAlive) {
			clickCounter++;
			batchNumber++;
		}
		//For Continue feature
		GameWorld.scoreArray.add(myWorld.getScore());
	}

	private void setArrayVariables(float aa, float bb, float cc, float dd, float ee, float ff, float gg, float col, float puls, float r) {
		type = aa;
		x = bb;
		y = cc;
		width = dd;
		height = ee;
		rotation = ff;
		speed = gg;
		color = col;
		pulsating = puls;
		singleRotation = r;
	}

	public void instructions() {
		clickCounterInstructions++;
	}

	public int getClickCounter() {
		return clickCounter;
	}

	public int getCurrentShapes() {
		return currentShapes;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setClickCounter(int clickCounter) {
		Shapes.clickCounter = clickCounter;
	}

	public void setCurrentShapes(int currentShapes) {
		Shapes.currentShapes = currentShapes;
	}

	public void setAlive(boolean isAlive) {
		Shapes.isAlive = isAlive;
	}

	public boolean isInstructions() {
		return instructions;
	}

	public int getClickCounterInstructions() {
		return clickCounterInstructions;
	}

	public void setInstructions(boolean instructions) {
		this.instructions = instructions;
	}

}