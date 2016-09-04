package com.xaoilin.Levels;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.xaoilin.GameWorld.GameWorld;

public class LevelFiles {

	public static float[][] levelArray, outlineArray, obstacleArray;
	public String fileLevelName;
	public static int gameLvl;
	public static int maxLvl;
	public final int gameHeight = GameWorld.gameHeight;
	public final int gameWidth = GameWorld.gameWidth;
	public int once = 0;
	public int rowParams;
	String[] fileArray;
	String[] fileOutlineArray = new String[300];
	String[] fileObstacleArray;
	
	public LevelFiles(){
		
		maxLvl = 14;
		fileArray = new String[300];
		fileObstacleArray = new String[300];
		fileLevelName = "";
		rowParams = 9;
		obstacleArray = new float[0][0];
	}
	
	// TYPE 1 Circle, 2 Square, 3 Triangle, 4 Rectangle, 5 (5 Star), 6 Pentagon
	// Paramaters are: "Type, X, Y, Width, Height, Rotation, Speed, Colour, Pulsating"
	
//	public void fileRead(int gameLvl){
//		System.out.println("entered fileread" + gameLvl);
//		
//		if(gameLvl >= 1 && gameLvl <= 12){
//			tierOne.file(gameLvl);
//		}
//	}
	
	private void Level88(String fileRead, String[] fileArray, String[] fileOutlineArray) {
		int numberOfShapes = 7;
		levelArray = new float[numberOfShapes][rowParams];

		FileHandle fileLevel = Gdx.files.local("Level8.txt");
		fileLevel.writeString("1, " + gameWidth / 2 + ", " + gameHeight / 2 + ", 0, 0, 0, 0.5, 0\n, " 
				+ "4, " + gameWidth / 2	+ ", " + (gameHeight / 2) * 1.3 + ", 0, 0, 0, 0.5, 1\n, " 
				+ "3, " + (gameWidth / 2) * 1 + ", " + (gameHeight / 2) * 1 + ", 0, 0, 0, 0.5, 1\n, " 
				+ "1, " + (gameWidth / 4) * 2.7 + ", " + (gameHeight / 4) * 1.5 + ", 0, 0, 1, 0.5, 1\n, " 
				+ "1, " + (gameWidth / 4) * 1.3 + ", " + (gameHeight / 4) * 1.5 + ", 0, 0, 1, 0.5, 1\n, " 
				+ "1, " + (gameWidth / 4) * 2.7 + ", " + (gameHeight / 4) * 1.5 + ", 0, 0, 1, 0.5, 0\n, " 
				+ "1, " + (gameWidth / 4) * 1.3 + ", " + (gameHeight / 4) * 1.5 + ", 0, 0, 1, 0.5, 0", false);

		fileRead = fileLevel.readString();

		fileArray = fileRead.split(", ");

		levelArray = createArray(numberOfShapes, fileArray);

		fileLevelName = fileLevel.name();
		
		FileHandle fileOutlineLevel = Gdx.files.local("Level8Outline.txt");
		fileOutlineLevel.writeString("1, " + gameWidth / 2 + ", " + gameHeight/2 + ", 400, 400, 0, 0, 0\n, "
				+ "4, " + (gameWidth / 2)*0.7 + ", " + (gameHeight/2)*1.1 + ", 250, 100, 0, 0, 0", false);
		String readOutlineFile = fileOutlineLevel.readString();
		fileOutlineArray = readOutlineFile.split(", ");
		outlineArray = new float[2][8];
		outlineArray = createArray(2, fileOutlineArray);
		
	}
	
	//Creates the 2D Array for whatever file is given to it
	public float[][] createArray(int iterations, String fileArray[]) {
		float[][] tempArray = new float[iterations][rowParams];
		ArrayList<float[]> action = new ArrayList<float[]>();
		int n = 0;
		for (int i = 0; i < iterations; i++) {
			action.add(new float[rowParams]);
			for (int j = 0; j < rowParams; j++) {
				action.get(i)[j] = Float.parseFloat(fileArray[n]);
				n++;
			}
		}

		for (int i = 0; i < action.size(); i++) {
			for (int j = 0; j < action.get(i).length; j++) {
				tempArray[i][j] = action.get(i)[j];
			}
		}
		return tempArray;
	}
	
	public void ShowArray(float[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void ShowArray(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void ShowArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public float[][] getLevelArray() {
		return levelArray;
	}
	
	public float[][] getObstacleArray() {
		return obstacleArray;
	}

	public String getFileName() {
		return fileLevelName;
	}

	public int getLevel() {
		return gameLvl;
	}
}
