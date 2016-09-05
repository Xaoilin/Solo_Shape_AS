package com.xaoilin.Levels;

import java.util.ArrayList;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.PerformanceCounter;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.GameWorld.Helper;

public class LevelDrawing {

	static Shapes myShapes;
	static Helper helper;
	PerformanceCounter perf;
	String perfString;
	DrawOutlines myOutlines;
	static GameWorld myWorld;
	static WinAnimation myWin;
	static TierOneLevelFiles myTierOne;
	public static ArrayList<Integer> orderArray = new ArrayList<Integer>();
	public static ArrayList<Integer> colorArray = new ArrayList<Integer>();
	public static ArrayList<Integer> obstacleArray = new ArrayList<Integer>();
	public static boolean once = true;
	static int num = 0;
	private static ArrayList<int[]> target;


	
	public LevelDrawing(GameWorld myWorld) {
		LevelDrawing.myShapes = myWorld.getShapes();
		LevelDrawing.helper = myWorld.getHelper();
		LevelDrawing.myWorld = myWorld;
		this.myOutlines = myWorld.getOutlines();
		myWin = new WinAnimation(myWorld);
		myTierOne = new TierOneLevelFiles();
		target = myWorld.getStarTarget();
	}

	public static void drawShape(int gameMode, int type, int order) {
		// Change the picture / batch you use to draw for each shape
		num = Shapes.batchNumber + 1;

		// Game Mode 1 Draw normal shapes
//		System.out.println("type: " + type);
		if(gameMode == 1){
			switch (type) {
			
			case 1:
				helper.drawCircle(myShapes.circleObjects.get(order), num, Shapes.polyShapes);
				break;
			case 2:
				helper.drawSquare(myShapes.squareObjects.get(order), Shapes.polyShapes);
				break;
			case 3:
				helper.drawTriangle(myShapes.triangleObjects.get(order), Shapes.polyShapes);
				break;
			case 4:
				helper.drawFourStar(myShapes.fourStarObjects.get(order), Shapes.polyShapes);
				break;
			case 5:
				helper.drawFiveStar(myShapes.fiveStarObjects.get(order), Shapes.polyShapes);
				break;
			case 6:
				helper.drawPentagon(myShapes.pentagonObjects.get(order), Shapes.polyShapes);
				break;
			case 7:
				helper.drawSnowflake(myShapes.snowflakeObjects.get(order), Shapes.polyShapes);
				break;
			}
		}
		
		
		if(gameMode == 2){
			if(LevelFiles.obstacleArray.length != 0){
				switch (type) {
				case 1:
					helper.drawCircle(myShapes.circleObstacles.get(order), num, Shapes.polyObstacles);
					break;
				case 2:
					helper.drawSquare(myShapes.squareObstacles.get(order), Shapes.polyObstacles);
					break;
				case 3:
					helper.drawTriangle(myShapes.triangleObstacles.get(order), Shapes.polyObstacles);
					break;
				case 4:
//					helper.drawRectangle(myShapes.squareObstacles.get(order), Shapes.polyObstacles);
					break;
				case 5:
					helper.drawFiveStar(myShapes.fiveStarObstacles.get(order), Shapes.polyObstacles);
					break;
				case 6:
					helper.drawPentagon(myShapes.pentagonObstacles.get(order), Shapes.polyObstacles);
					break;
				case 7:
					helper.drawSnowflake(myShapes.snowflakeObstacles.get(order), Shapes.polyObstacles);
					break;
				}
			}
		}
		
		
//		for (int i = 0; i < myShapes.fiveStarObjects.size(); i++) {
//			System.out.println(i + "\t" + myShapes.fiveStarObjects.get(i).width);
//		}
		



	}

	public static void drawAllLevels() {

		int level = LevelFiles.gameLvl;
		// Orders the myShapes into an array
		if (once == true) {
			//Initialize level
			myTierOne.file(level);
			
			// NORMAL ARRAY
			for (int i = 0; i < LevelFiles.levelArray.length; i++) {
				orderArray.add((int) LevelFiles.levelArray[i][0]);
			}

			// OBSTACLE ARRAY
			if(LevelFiles.obstacleArray.length != 0){
				for (int i = 0; i < LevelFiles.obstacleArray.length; i++) {
					System.out.println("Obstacle array type: " + LevelFiles.obstacleArray[i][0]);
					obstacleArray.add((int) LevelFiles.obstacleArray[i][0]);
				}
			}
			

			once = false;
		}

		// Draw Shapes according to shapes array
		for (int i = 0; i < orderArray.size(); i++) {
			drawShape(1, orderArray.get(i), i);
		}

		// Draw Shapes in obstacle Array
		for (int i = 0; i < obstacleArray.size(); i++) {
			drawShape(2, obstacleArray.get(i), i);
		}

		// Win condition
		if (myShapes.getClickCounter() <= LevelFiles.levelArray.length) {
			if(myWorld.isRunning())myWorld.addScore(1);
		} else {
			if (myWorld.getScore() >= target.get(level - 1)[0]) { // The user
																	// wins
				myWorld.setNextLevel();
				myWin.drawWin();
			} else {
				myShapes.setAlive(false);
			}
		}

	}

}
