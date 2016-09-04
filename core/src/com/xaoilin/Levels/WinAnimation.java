package com.xaoilin.Levels;

import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.GameWorld.Helper;
import com.xaoilin.SSHelpers.AssetLoader;
import com.xaoilin.SSHelpers.Memory;

public class WinAnimation {

	//coins
	static int coinCounter = 0;
	static double coinX = GameWorld.gameWidth*0.45, coinY = 10;
	static double fontY = GameWorld.gameHeight*0.4650;
	static float fontOpacity = 1f;
	static int onceCoin = 0;
	
	//stars
	public static int tempSize1 = 0, tempX1 = 0, tempY1 = 0;
	public static int tempSize2 = 0, tempX2 = 0, tempY2 = 0;
	public static int tempSize3 = 0, tempX3 = 0, tempY3 = 0;
	public static int x1, y1, x2, y2, x3, y3;
	public static boolean star1 = false, star2 = false;
	public static boolean once = true, twice = true, thrice = true;
	static boolean once2 = true;
	
	// Game Objects
	Shapes myShapes;
	GameWorld myWorld;
	Helper helper;

	public WinAnimation(GameWorld myWorld) {
		this.myShapes = myWorld.getShapes();
		this.myWorld = myWorld;
		this.helper = myWorld.getHelper();
	}

	public void localReset() {
		fontY = GameWorld.gameHeight*0.4650;
		onceCoin = 0;
		fontOpacity = 1f;
		coinX = GameWorld.gameWidth*0.45;
		coinY = 10;
		coinCounter = 0;
		tempSize1 = 0;
		tempX1 = 0;
		tempY1 = 0;
		tempSize2 = 0;
		tempX2 = 0;
		tempY2 = 0;
		tempSize3 = 0;
		tempX3 = 0;
		tempY3 = 0;
		star1 = false;
		star2 = false;
		once = true;
		twice = true;
		thrice = true;
		once2 = true;
		x1 = 0; y1 = 0; x2 = 0; y2 = 0; x3 = 0; y3 = 0;
		// x1, y1, x2, y2, x3, y3;
	}

	public void drawWin() {
		// shapes.setRGB(0,255,0);
		
		drawScoreboard((GameWorld.gameWidth*0.1), (GameWorld.gameHeight*0.4));
		drawStars();
		if(once2){
			//Update highest level
//			System.out.println("GAME LEVEL " + LevelFiles.gameLvl);
			if(LevelFiles.gameLvl+1 > Memory.getHighestUserLevel()){
				Memory.setHighestLevel(LevelFiles.gameLvl+1);
//				System.out.println("Highest Level Reached: " + Memory.getHighestLevel());
			}
			
			once2 = false;
		}
	}

	public void drawScoreboard(double x, double y){
		//To center all scores
		String highScore = String.valueOf(Memory.getHighScore(LevelFiles.gameLvl));
		String score = String.valueOf(myWorld.getScore());
		double scale = GameWorld.gameWidth*0.02777778;
		
		helper.drawTexture(x, y, 1, AssetLoader.scoreboard);
		helper.drawTexture((GameWorld.gameWidth*0.1148), (GameWorld.gameHeight*0.4134), 0.58, AssetLoader.noStar);
		helper.drawTexture((GameWorld.gameWidth*0.2648), (GameWorld.gameHeight*0.4134), 0.58, AssetLoader.noStar);
		helper.drawTexture((GameWorld.gameWidth*0.4148), (GameWorld.gameHeight*0.4134), 0.58, AssetLoader.noStar);
		helper.drawText(score, (x * 6.8) - ((score.length()-1) * scale),  (y * 1.15), 1);
		helper.drawText(highScore,(x * 6.8) - ((highScore.length()-1) * scale), (y * 1.45), 1);
		helper.drawText("Bank:", (GameWorld.gameWidth*0.1248), (GameWorld.gameHeight*0.5034), 6);
		helper.drawText("" + Memory.getCoins(), (GameWorld.gameWidth*0.3848), (GameWorld.gameHeight*0.5034), 6);
		helper.drawTexture((GameWorld.gameWidth*0.2648), (GameWorld.gameHeight*0.4650), 0.8, AssetLoader.starCoin);
	}
	
	public void drawStars() {
		coinCounter++;
		int growth = 4;
		double size = AssetLoader.goldStar.getRegionHeight()*0.6;
		if (tempSize1 < size && star1 == false) {
			tempSize1 += growth;
			tempX1 -= growth / 2;
			tempY1 -= growth / 2;

		} else {
			if(once && myWorld.getScore() >= myWorld.getStarTarget().get(LevelFiles.gameLvl - 1)[0]){
				AssetLoader.starAchieved.play(GameWorld.VOLUME);
				once = false;
			}
			
			star1 = true;
			star2 = false;
		}

		if (tempSize2 < size && star1 == true) {
			tempSize2 += growth;
			tempX2 -= growth / 2;
			tempY2 -= growth / 2;
		} else {
			star2 = true;
			if(twice && myWorld.getScore() >= myWorld.getStarTarget().get(LevelFiles.gameLvl - 1)[1]){
				AssetLoader.starAchieved.play(GameWorld.VOLUME);
				twice = false;
			}
		}

		if (tempSize3 < size && star2 == true && star1 == true) {
			tempSize3 += growth;
			tempX3 -= growth / 2;
			tempY3 -= growth / 2;
			if(thrice && myWorld.getScore() >= myWorld.getStarTarget().get(LevelFiles.gameLvl - 1)[2]){
				AssetLoader.starAchieved.play(GameWorld.VOLUME);
				thrice = false;
			}
		}

		x1 = (int) (GameWorld.gameWidth * 0.169) + tempX1;
		y1 = (int) (GameWorld.gameHeight * 0.443) + tempY1;

		x2 = (int) (GameWorld.gameWidth * 0.319) + tempX2;
		y2 = (int) (GameWorld.gameHeight *0.443) + tempY2;

		x3 = (int) (GameWorld.gameWidth * 0.469) + tempX3;
		y3 = (int) (GameWorld.gameHeight * 0.443) + tempY3;

		//Achieved stars
		if (myWorld.getScore() >= myWorld.getStarTarget().get(LevelFiles.gameLvl - 1)[0]) {

			helper.drawTexture(x1, y1, tempSize1, AssetLoader.goldStar, false);
		}

		if (myWorld.getScore() >= myWorld.getStarTarget().get(LevelFiles.gameLvl - 1)[1]) {

			helper.drawTexture(x2, y2, tempSize2, AssetLoader.goldStar, false);
		}

		if (myWorld.getScore() >= myWorld.getStarTarget().get(LevelFiles.gameLvl - 1)[2]) {

			helper.drawTexture(x3, y3, tempSize3, AssetLoader.goldStar, false);
		}
		
		//Coin Animation
		
		if(coinCounter > 100){
			if(coinX > (GameWorld.gameWidth*0.2648)){
				coinX-=4;
				if(coinX < GameWorld.gameWidth*0.2648){
					coinX = GameWorld.gameWidth*0.2648;
				}
			}
			
			if(coinY < (GameWorld.gameHeight*0.4650)){
				coinY+=18;
				if(coinY > GameWorld.gameHeight*0.4650){
					coinY = GameWorld.gameHeight*0.4650;
				}
			}
			
			helper.drawTexture(coinX, coinY, 0.8, AssetLoader.starCoin);
		}
		
		//text +1 coin
		if(coinX == GameWorld.gameWidth*0.2648){
			fontY--;
			fontOpacity-=0.01f;
			Helper.batch.begin();
			AssetLoader.coinFont.draw(Helper.batch, "+"+(int) (myWorld.getScore()/50),(float) (GameWorld.gameWidth*0.2648),(float) fontY);
			AssetLoader.coinFont.setColor(255, 255, 255, fontOpacity);
			Helper.batch.end();
			
			if(onceCoin == 0){
				AssetLoader.starAchieved.play();
				Memory.setCoins(Memory.getCoins() + (int) (myWorld.getScore()/50)); 
				onceCoin++;
			}
			
		}
	}

}
