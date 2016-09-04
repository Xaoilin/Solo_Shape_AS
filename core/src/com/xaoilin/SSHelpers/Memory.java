package com.xaoilin.SSHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.xaoilin.GameWorld.GameWorld;

public class Memory {

	private static Preferences prefs;
	private GameWorld myWorld;
	public Memory(GameWorld myWorld){
		this.myWorld = myWorld;
		createPreferences();
	}
	
	public int starsAchieved(int tier){
		int stars = 0;
		int tierMinLevel = 0;
		int tierMaxLevel = 0;
		switch(tier){
		case 1:
			tierMinLevel = 1;
			tierMaxLevel = 14;
			break;
		case 2:
//			tierMinLevel = 1;
//			tierMaxLevel = 2;
			break;
		case 3:
			//tierMinLevel = 20;
			//tierMaxLevel = 30;
			break;
		}
		
		//Returns the number of stars achieved in a certain tier
		for(int level = tierMinLevel; level <= tierMaxLevel; level++){
			if(getHighScore(level) >= myWorld.getStarTarget().get(level-1)[2]){
				stars += 3;
			}else if(getHighScore(level) >= myWorld.getStarTarget().get(level-1)[1]){
				stars += 2;
			}else if(getHighScore(level) >= myWorld.getStarTarget().get(level-1)[0]){
				stars += 1;
			}
		}
		return stars;
	}
	
	
	public static void createPreferences(){
		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("SoloShape");
		
		//If High score doesn't exist then add one
		if (!prefs.contains("highScore")) {
			prefs.putInteger("highScore", 0);
		}
		//If highest level reached doesn't exist then create it
		if (!prefs.contains("highestLevelReached")) {
			prefs.putInteger("highestLevelReached", 1);
		}
		
		//If coins dont exist then create them
		if (!prefs.contains("coins")) {
			prefs.putInteger("coins", 100);
		}
	}
	
	public static void setHighestLevel(int level) {
		prefs.putInteger("highestLevelReached", level);
		prefs.flush(); //Must do this to update preference
	}

	public static int getHighestUserLevel() {
		return prefs.getInteger("highestLevelReached");
	}
	
	public static void setHighScore(int level, int score) {
		prefs.putInteger("highScore " + level, score);
		prefs.flush(); //Must do this to update preference
	}

	public static int getHighScore(int level) {
		return prefs.getInteger("highScore " + level);
	}

	public static void setCoins(int coins) {
		prefs.putInteger("coins", coins);
		prefs.flush(); //Must do this to update preference
	}

	public static int getCoins() {
		return prefs.getInteger("coins");
	}
}
