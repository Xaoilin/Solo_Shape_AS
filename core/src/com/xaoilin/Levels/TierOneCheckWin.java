package com.xaoilin.Levels;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.GameWorld.Helper;

public class TierOneCheckWin extends CheckWin {

	// CheckWin.gameOverMessage = "Not Enough\n Points!";
	// CheckWin.gameOverMessage = "Screen Touched!";
	// CheckWin.gameOverMessage = "Shapes Touched!";

	public int counter = 0;
	public static int continueFromShape = 0;

	public TierOneCheckWin(Shapes myShapes) {
		super(myShapes);

	}

	public void checkLevel(int level) {
		CheckWin.gameOverMessage = "Not Enough\n Points!";
		switch (level) {
		case 1:
//			level1();
			break;
		case 2:
//			level2();
			break;
		case 3:
//			level3();
			break;
		case 4:
//			level4();
			break;
		case 5:
//			level5();
			break;
		case 6:
//			level6();
			break;
		case 7:
			level7();
			break;
		case 8:
			level8();
			break;
		case 9:
			level9();
			break;
		case 10:
			level10();
			break;
		case 11:
			level11();
			break;
		case 12:
			level12();
			break;
		case 13:
			level13();
			break;
		case 14:
			level14();
			break;
		default:
			System.out.println("Error in TierOneCheckWin class, checkLevel method");
			break;
		}
	}

	private void level14(){
		if (Shapes.polyShapes[1].getVertices().length != 0) {
			switch(Shapes.currentShapes){
			case 1:
				if(Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices()[4] > GameWorld.gameWidth){
					reset(1);
				}
				break;
			}
			
		}
	}
	
	private void level13() {
		if (Shapes.polyShapes[1].getVertices().length != 0) {
			switch(Shapes.currentShapes){
			case 1:
				if(overlapsPolygon(Shapes.polyShapes[1], Shapes.polyObstacles[1])){
					reset(1);
				}
				break;
			}
			
		}
	}

	public void level12() {

		if (Shapes.polyShapes[1].getVertices().length != 0) {

			switch (Shapes.currentShapes) {
			// Squares
			case 1:
				if (Shapes.polyShapes[Shapes.currentShapes].getBoundingRectangle().x < 0) {
					reset(2);
				}
				break;
			case 2:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 1 })) {
					reset(1);
				}
				break;
			case 3:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 2 })) {
					reset(1);
				}
				break;
			case 4:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 3 })) {
					reset(1);
				}
				break;
			case 5:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 4 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[2] > GameWorld.gameWidth) {
					reset(2);
				}
				break;
			case 6:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 2, 3, 4 })) {
					reset(1);
				}
				break;
			case 7:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 6 })) {
					reset(1);
				}
				break;
			case 8:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 7 })) {
					reset(1);
				}
				break;
			case 9:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 8 })) {
					reset(1);
				}
				break;
			case 10:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 9 })) {
					reset(1);
				}
				break;
			case 11:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 10 })) {
					reset(1);
				}
				break;
			case 12:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 11 })) {
					reset(1);
				}
				break;
			case 13:
			case 14:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 12 })) {
					reset(1);
				}
				break;
			case 15:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 13 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[2] > GameWorld.gameWidth) {
					reset(2);
				}
				break;
			case 16:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 3 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getBoundingRectangle().x < 0) {
					reset(2);
				}
				break;
			case 17:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 8, 7, 9 })) {
					reset(1);
				}
				break;
			case 18:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 17 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getBoundingRectangle().x < 0) {
					reset(2);
				}
				break;
			case 19:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] {8, 9, 10 })) {
					reset(1);
				}
				break;
			case 20:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 19 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[2] > GameWorld.gameWidth) {
					reset(2);
				}
				break;
			case 21:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 9, 8, 17, 10})) {
					reset(1);
				}
				break;
			case 22:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 21, 18, 17 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getBoundingRectangle().x < 0) {
					reset(2);
				}
				break;
			case 23:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] {7, 9, 8, 19 })) {
					reset(1);
				}
				break;
			case 24:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 9, 8, 19 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[2] > GameWorld.gameWidth) {
					reset(2);
				}
				break;

			// STARS
			case 25:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 1, 2, 6, 7, 17, 18 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[16] < 0) {
					reset(2);
				}
				break;
			case 26:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 10, 11, 13, 15, 19, 20 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[4] > GameWorld.gameWidth) {
					reset(2);
				}
				break;
			case 27:
				if (overlapsPolygon(Shapes.polyShapes[25], Shapes.polyShapes[27])) {
					reset(1);
				}
				break;
			case 28:
				if (overlapsPolygon(Shapes.polyShapes[26], Shapes.polyShapes[28])) {
					reset(1);
				}
				break;
			case 29:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 4, 5, 6, 7, 23, 24 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[4] > GameWorld.gameWidth) {
					reset(2);
				}
				break;
			case 30:
				if (overlapsPolygon(Shapes.polyShapes[28], Shapes.polyShapes[30])) {
					reset(1);
				}
				break;
			case 31:
				if (overlapsPolygon(Shapes.polyShapes[27], Shapes.polyShapes[31])) {
					reset(1);
				}
				break;
			case 32:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 21, 21, 10, 11, 14, 16 })) {
					reset(1);
				} else if (Shapes.polyShapes[Shapes.currentShapes].getVertices()[16] < 0) {
					reset(2);
				}
				break;
			case 33:
				if (overlapsPolygon(Shapes.polyShapes[29], Shapes.polyShapes[33])) {
					reset(1);
				}
				break;
			case 34:
				if (overlapsPolygon(Shapes.polyShapes[32], Shapes.polyShapes[34])) {
					reset(1);
				}
				break;
			case 35:
				if (overlapsPolygon(Shapes.polyShapes[33], Shapes.polyShapes[35])) {
					reset(1);
				}
				break;
			case 36:
				if (overlapsPolygon(Shapes.polyShapes[34], Shapes.polyShapes[36])) {
					reset(1);
				}
				break;
			// White Squares
			case 37:
				if (overlapsPolygon(Shapes.polyShapes[1], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 38:
				if (overlapsPolygon(Shapes.polyShapes[2], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 39:
				if (overlapsPolygon(Shapes.polyShapes[3], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 40:
				if (overlapsPolygon(Shapes.polyShapes[4], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 41:
				if (overlapsPolygon(Shapes.polyShapes[5], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 42:
				if (overlapsPolygon(Shapes.polyShapes[12], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 43:
				if (overlapsPolygon(Shapes.polyShapes[13], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 44:
				if (overlapsPolygon(Shapes.polyShapes[14], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 45:
				if (overlapsPolygon(Shapes.polyShapes[15], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 46:
				if (overlapsPolygon(Shapes.polyShapes[16], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 47:
				if (overlapsPolygon(Shapes.polyShapes[6], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 48:
				if (overlapsPolygon(Shapes.polyShapes[11], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 49:
				if (overlapsPolygon(Shapes.polyShapes[7], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 50:
				if (overlapsPolygon(Shapes.polyShapes[10], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 51:
				if (overlapsPolygon(Shapes.polyShapes[8], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 52:
				if (overlapsPolygon(Shapes.polyShapes[9], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 53:
				if (overlapsPolygon(Shapes.polyShapes[17], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 54:
				if (overlapsPolygon(Shapes.polyShapes[18], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 55:
				if (overlapsPolygon(Shapes.polyShapes[23], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 56:
				if (overlapsPolygon(Shapes.polyShapes[24], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 57:
				if (overlapsPolygon(Shapes.polyShapes[21], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 58:
				if (overlapsPolygon(Shapes.polyShapes[22], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 59:
				if (overlapsPolygon(Shapes.polyShapes[19], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			case 60:
				if (overlapsPolygon(Shapes.polyShapes[20], Shapes.polyShapes[Shapes.currentShapes])) {
					reset(1);
				}
				break;
			}
		}
	}

	public void level11() {
		Circle circleOne = myShapes.circleObjects.get(8).circleBounds;
		Circle circleTwo = myShapes.circleObjects.get(17).circleBounds;
		Circle circleThree = myShapes.circleObjects.get(26).circleBounds;

		if (Shapes.polyShapes[1].getTransformedVertices().length != 0) {

			for (int i = 1; i <= 8; i++) {
				// Checks if any of the squares go off the screen
				if (i % 2 == 1) {
					if (Shapes.polyShapes[i].getBoundingRectangle().x < 0 && Shapes.currentShapes == i) {
						System.out.println("Level 8 Failed left square touched screen");
						reset(2);
					}
				} else if (i % 2 == 0) {
					if (Shapes.polyShapes[i].getTransformedVertices()[2] > GameWorld.gameWidth && Shapes.currentShapes == i) {
						System.out.println("Level 8 Failed right square touched screen");
						reset(2);
					}
				}

				// Checks first 8 squares don't hit each other
				if (i <= 4) {
					if (overlapsPolygon(Shapes.polyShapes[i], Shapes.polyShapes[i + 4]) && Shapes.currentShapes == (i + 4)) {
						System.out.println("Level 8 Failed Squares touched another square");
						reset(1);
					}
				}

				// Checks if the first Circle touches any of the squares
				if (overlapsCircle(Shapes.polyShapes[i], circleOne) && Shapes.currentShapes == 9) {
					System.out.println("Level 8 Failed Circle touched another square");
					reset(1);
				}

				// Checks white squares don't touch black squares
				if (overlapsPolygon(Shapes.polyShapes[i], Shapes.polyShapes[i + 9]) && Shapes.currentShapes == (i + 9)) {
					System.out.println("Failed, White square touched black square");
					reset(1);
				}

				// Checks black squares don't touch white squares
				if (overlapsPolygon(Shapes.polyShapes[i + 9], Shapes.polyShapes[i + 18]) && Shapes.currentShapes == (i + 18)) {
					System.out.println("Failed, Black square touched white square");
					reset(1);
				}

			}

			// Checks if circle 2 hits circle 1
			if (circleOne.contains(circleTwo) == false && Shapes.currentShapes == 18) {
				System.out.println("Failed, White circle touched black circle");
				reset(1);
			}

			// Checks if circle 3 hits circle 2
			if (circleTwo.contains(circleThree) == false && Shapes.currentShapes == 27) {
				System.out.println("Failed, Black circle touched white circle");
				reset(1);
			}
		}

	}

	public void level10() {
		if (Shapes.polyShapes[1].getVertices().length != 0) {
			// if First square hits screen
			if (Shapes.polyShapes[1].getBoundingRectangle().x < 0 && Shapes.currentShapes == 1) {
				reset(2);
			}

			// if any of the right squares hit the screen
			for (int j = 5; j <= 12; j++) {
				if (Shapes.polyShapes[j].getVertices()[2] > GameWorld.gameWidth && Shapes.currentShapes == j) {
					reset(2);
				}
			}

			// if any of the left squares hit the screen
			for (int j = 16; j <= 21; j++) {
				if (Shapes.polyShapes[j].getBoundingRectangle().x < 0 && Shapes.currentShapes == j) {
					reset(2);
				}
			}

			// if any of the top squares hit each other
			for (int i = 1; i <= 26; i++) {
				if (overlapsPolygon(Shapes.polyShapes[i], Shapes.polyShapes[i + 1]) && Shapes.currentShapes == i + 1) {
					reset(1);
				}
			}

			// shapes 27+ interacting with relevant squares
			if (Shapes.currentShapes >= 27) {
				// if any of the 27+ shapes hit each other
				for (int i = 27; i <= 39; i++) {
					if (overlapsPolygon(Shapes.polyShapes[i], Shapes.polyShapes[i + 1]) && Shapes.currentShapes == i + 1) {
						reset(1);
					}
				}

				switch (Shapes.currentShapes) {
				case 27:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 1, 2, 24, 22 })) {
						reset(1);
					}
					break;
				case 28:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 1, 2, 3, 21, 22, 23 })) {
						reset(1);
					}
					break;
				case 29:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 2, 3, 4, 22, 23 })) {
						reset(1);
					}
					break;
				case 30:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 3, 4, 5, 6, 7, 23 })) {
						reset(1);
					}
					break;
				case 31:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 6, 7, 8, 23, 24 })) {
						reset(1);
					}
					break;
				case 32:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 23, 24, 25, 7, 8, 9 })) {
						reset(1);
					}
					break;
				case 33:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 24, 25, 26, 8, 9, 10 })) {
						reset(1);
					}
					break;
				case 34:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 25, 26, 9, 10, 11 })) {
						reset(1);
					}
					break;
				case 35:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 26, 10, 11, 12, 13, 14 })) {
						reset(1);
					}
					break;
				case 36:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 26, 13, 14, 15 })) {
						reset(1);
					}
					break;
				case 37:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 18, 17, 16, 15, 14, 26 })) {
						reset(1);
					}
					break;
				case 38:
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 19, 18, 17, 23, 26 })) {
						reset(1);
					}
					break;
				case 39:
					System.out.println(39);
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 20, 19, 18, 24, 25, 26 })) {
						reset(1);
					}
					break;
				case 40:
					System.out.println(40);
					if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
							new int[] { 19, 20, 21, 22, 23, 24, 25, 39 })) {
						reset(1);
					}
					break;
				default:
					System.out.println("Error in TierOneCheckWin.java level10()");
					break;
				}
			}

		}
	}

	public void level9() {
		Circle circleOne = myShapes.circleObjects.get(0).circleBounds;
		Circle circleTwo = myShapes.circleObjects.get(2).circleBounds;
		Circle circleThree = myShapes.circleObjects.get(4).circleBounds;
		Circle circleFour = myShapes.circleObjects.get(6).circleBounds;
		Circle circleFive = myShapes.circleObjects.get(8).circleBounds;
		Circle circleSix = myShapes.circleObjects.get(9).circleBounds;
		Circle circleSeven = myShapes.circleObjects.get(10).circleBounds;
		Circle circleEight = myShapes.circleObjects.get(11).circleBounds;
		Circle circleNine = myShapes.circleObjects.get(12).circleBounds;
		Circle circleTen = myShapes.circleObjects.get(13).circleBounds;
		Circle circleEleven = myShapes.circleObjects.get(14).circleBounds;
		Circle circleTwelve = myShapes.circleObjects.get(15).circleBounds;
		Circle circleThirteen = myShapes.circleObjects.get(16).circleBounds;
		Circle circleFourteen = myShapes.circleObjects.get(17).circleBounds;
		Circle circleFifteen = myShapes.circleObjects.get(18).circleBounds;
		Circle circleSixteen = myShapes.circleObjects.get(19).circleBounds;
		Circle circleSeventeen = myShapes.circleObjects.get(20).circleBounds;

		if (Shapes.polyShapes[2].getVertices().length != 0) {

			switch (Shapes.currentShapes) {
			case 1:
				if (circleOne.radius > GameWorld.gameWidth / 2) {
					reset(2);
				}
				break;
			case 2:
				// Square
				if (Shapes.polyShapes[2].getTransformedVertices()[5] > GameWorld.gameHeight) {
					reset(2);
				} else if (overlapsCircle(Shapes.polyShapes[Shapes.currentShapes], circleOne)) {
					reset(1);
				}
				break;
			case 3:
				if (circleOne.contains(circleTwo) == false) {
					reset(1);
				}

				break;
			case 4:
				// Star
				if (Shapes.polyShapes[4].getTransformedVertices()[5] > GameWorld.gameHeight) {
					reset(2);
				} else if (overlapsCircle(Shapes.polyShapes[Shapes.currentShapes], circleOne)) {
					reset(1);
				}
				break;
			case 5:
				if (circleTwo.contains(circleThree) == false) {
					reset(1);
				}
				break;
			case 6:
				// Pentagon
				if (Shapes.polyShapes[6].getTransformedVertices()[0] > GameWorld.gameWidth) {
					reset(2);
				} else if (overlapsCircle(Shapes.polyShapes[Shapes.currentShapes], circleOne)) {
					reset(1);
				}
				break;
			case 7:
				if (circleThree.contains(circleFour) == false) {
					reset(1);
				}
				break;
			case 8:
				// Snowflake
				if (Shapes.polyShapes[8].getTransformedVertices()[84] < 0) {
					reset(2);
				} else if (overlapsCircle(Shapes.polyShapes[Shapes.currentShapes], circleOne)) {
					reset(1);
				}
				break;
			case 9:
				if (circleFour.contains(circleFive) == false) {
					reset(1);
				}
				break;
			case 10:
				if (circleFive.contains(circleSix) == false) {
					reset(1);
				}
				break;
			case 11:
				if (circleSix.contains(circleSeven) == false) {
					reset(1);
				}
				break;
			case 12:
				if (circleSeven.contains(circleEight) == false) {
					reset(1);
				}
				break;
			case 13:
				if (circleEight.contains(circleNine) == false) {
					reset(1);
				}
				break;
			case 14:
				if (circleNine.contains(circleTen) == false) {
					reset(1);
				}
				break;
			case 15:
				if (circleTen.contains(circleEleven) == false) {
					reset(1);
				}
				break;
			case 16:
				if (circleEleven.contains(circleTwelve) == false) {
					reset(1);
				}
				break;
			case 17:
				if (circleTwelve.contains(circleThirteen) == false) {
					reset(1);
				}
				break;
			case 18:
				if (circleThirteen.contains(circleFourteen) == false) {
					reset(1);
				}
				break;
			case 19:
				if (circleFourteen.contains(circleFifteen) == false) {
					reset(1);
				}
				break;
			case 20:
				if (circleFifteen.contains(circleSixteen) == false) {
					reset(1);
				}
				break;
			case 21:
				if (circleSixteen.contains(circleSeventeen) == false) {
					reset(1);
				}
				break;

			}

			// if(Shapes.currentShapes >= 10){
			// for (int i = 8; i <= 19; i++) {
			// if(Shapes.currentShapes == i+ 1){
			//
			// if(myShapes.circleObjects.get(i).circleBounds.contains(myShapes.circleObjects.get(i+1).circleBounds)
			// == false){
			// System.out.println("FALIED");
			// CheckWin.gameOverMessage = "Shapes Touched!";
			// reset();
			// }
			// }
			//
			// }
			// }

		}
	}

	public void level8() {
		if (Shapes.polyShapes[1].getVertices().length != 0) {

			// if any of the polygons touch each other

			switch (Shapes.currentShapes) {
			case 7:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 1 })) {
					reset(1);
				}
				break;
			case 8:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 7 })) {
					reset(1);
				}
				break;
			case 9:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 8, 3 })) {
					reset(1);
				}
				break;
			case 10:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 2 })) {
					reset(1);
				}
				break;
			case 11:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 10 })) {
					reset(1);
				}
				break;
			case 12:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 11, 4 })) {
					reset(1);
				}
				break;
			case 13:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 4 })) {
					reset(1);
				}
				break;
			case 14:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 3 })) {
					reset(1);
				}
				break;
			case 15:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 1 })) {
					reset(1);
				}
				break;
			case 16:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 2 })) {
					reset(1);
				}
				break;
			case 17:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 13 })) {
					reset(1);
				}
				break;
			case 18:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 16 })) {
					reset(1);
				}
				break;
			case 19:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 15, 6 })) {
					reset(1);
				}
				break;
			case 20:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 5, 18 })) {
					reset(1);
				}
				break;
			case 21:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 6, 17 })) {
					reset(1);
				}
				break;
			case 22:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 5, 14 })) {
					reset(1);
				}
				break;
			case 23:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 7, 1, 15 })) {
					reset(1);
				}
				break;
			case 24:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 16, 10, 2 })) {
					reset(1);
				}
				break;
			case 25:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 13, 4, 12 })) {
					reset(1);
				}
				break;
			case 26:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 9, 3, 14 })) {
					reset(1);
				}
				break;
			case 27:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 8, 23, 26 })) {
					reset(1);
				}
				break;
			case 28:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 11, 24, 25 })) {
					reset(1);
				}
				break;
			case 29:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 28, 25, 17, 21, 6 })) {
					reset(1);
				}
				break;
			case 30:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 28, 24, 5, 20, 18 })) {
					reset(1);
				}
				break;
			case 31:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 29, 21, 6, 19, 23, 27 })) {
					reset(1);
				}
				break;
			case 32:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 5, 30, 20, 22, 27 })) {
					reset(1);
				}
				break;
			case 33:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 7, 8, 9, 23, 26, 27 })) {
					reset(1);
				}
				break;
			case 34:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes], new int[] { 12, 11, 10, 24, 25, 28 })) {
					reset(1);
				}
				break;
			case 35:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
						new int[] { 13, 25, 34, 28, 17, 21, 29 })) {
					reset(1);
				}
				break;
			case 36:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
						new int[] { 20, 30, 18, 16, 24, 34, 28 })) {
					reset(1);
				}
				break;
			case 37:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
						new int[] { 15, 23, 33, 19, 27, 31, 6 })) {
					reset(1);
				}
				break;
			case 38:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
						new int[] { 33, 26, 14, 27, 22, 32, 5 })) {
					reset(1);
				}
				break;
			case 39:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
						new int[] { 37, 27, 38, 31, 32, 29, 30 })) {
					reset(1);
				}
				break;
			case 40:
				if (overlapsMultiplePolygons(Shapes.polyShapes[Shapes.currentShapes],
						new int[] { 31, 39, 32, 29, 30, 35, 28, 36 })) {
					reset(1);
				}
				break;
			default:
				System.out.println("Error in TierOneCheckWin.java level8()");
				break;
			}

			// if any of the side polygons touch the screen
			for (int i = 1; i <= 22; i++) {
				switch (Shapes.currentShapes) {
				case 1:
				case 4:
				case 6:
				case 13:
				case 15:
				case 17:
				case 19:
				case 21:
					if (Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices()[112] < 0) {
						reset(2);
						return;
					}
					break;
				case 2:
				case 3:
				case 5:
				case 14:
				case 16:
				case 18:
				case 20:
				case 22:
					if (Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices()[28] > GameWorld.gameWidth) {
						reset(2);
						return;
					}
					break;
				case 10:
				case 11:
				case 12:
					if (Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices()[57] > GameWorld.gameHeight) {
						reset(2);
						return;
					}
					break;
				}
			}
		}
	}

	public void level7() {
		Polygon starOne = Shapes.polyShapes[1];
		Polygon starTwo = Shapes.polyShapes[2];
		Polygon starThree = Shapes.polyShapes[3];
		Polygon starFour = Shapes.polyShapes[4];
		Circle circleOne = myShapes.circleObjects.get(4).circleBounds;
		Polygon squareOne = Shapes.polyShapes[6];
		Circle circleTwo = myShapes.circleObjects.get(6).circleBounds;

		if (starOne.getTransformedVertices().length != 0) {
			// First Star hitting edge of screen
			if (starOne.getTransformedVertices()[0] > (GameWorld.gameWidth)) {
				System.out.println("Level 7 failed [1]");
				reset(2);
			}
			// Second Star hitting edge of screen
			if (starTwo.getTransformedVertices()[8] < 0 && Shapes.currentShapes == 2) {
				System.out.println("Level 7 failed [2]");
				reset(2);
			}
			// Third Star hitting edge of screen
			if (starThree.getTransformedVertices()[8] < 0 && Shapes.currentShapes == 3) {
				System.out.println("Level 7 failed [3]");
				reset(2);
			}
			// Fourth Star hitting edge of screen
			if (starFour.getTransformedVertices()[0] > GameWorld.gameWidth && Shapes.currentShapes == 4) {
				System.out.println("Level 7 failed [4]");
				reset(2);
			}

			// Check if circle interacts with any of the four stars
			// If the stars collide with circle
			for (int i = 1; i <= 4; i++) {
				if (overlapsCircle(Shapes.polyShapes[i], circleOne) && Shapes.currentShapes == 5) {
					reset(1);
				}
			}

			// Check if the square in the circle touches the circle
			// If Polygon growing inside circle use this method

			if (circleOne.contains(squareOne.getTransformedVertices()[0],
					squareOne.getTransformedVertices()[1]) == false && Shapes.currentShapes == 6) {
				counter++; // It returns false once before the shape starts
							// growing abnormally so add a counter to account
							// for this
				if (counter > 1) {
					reset(1);
				}
			}

			// Check if the circle in the square touches the square
			// If Circle growing inside Polygon use this method
			if (overlapsCircle(squareOne, circleTwo) && Shapes.currentShapes == 7) {
				reset(1);
			}
		}

	}

	public void level6() {
		if (Shapes.polyShapes[1].getTransformedVertices().length != 0) {
			if (Shapes.polyShapes[1].getTransformedVertices()[16] < 0) {
				reset(2);
				System.out.println("Level 6 failed star touched screen");
			}

			for (int i = 1; i <= 12; i++) {
				if (overlapsPolygon(Shapes.polyShapes[i], Shapes.polyShapes[i + 1])) {
					reset(1);
					System.out.println("Level 6 failed + [" + i + "]");
				}
			}
		}
	}

	public void level5() {
		// System.out.println("circle: " +
		// myShapes.circleObjects.get(0).radius);
		// System.out.println("square: " +
		// myShapes.squareObjects.get(1).rectBounds);
		// System.out.println("Click counter: " + Shapes.clickCounter);
		if (myShapes.circleObjects.get(0).radius > 536) {
			System.out.println("level 5 failed! [1]");
			reset(2);
		}

		if (myShapes.circleObjects.get(0).circleBounds.contains(myShapes.squareObjects.get(1).rectBounds.x,
				myShapes.squareObjects.get(1).rectBounds.y) == false && myShapes.getCurrentShapes() == 2) {
			System.out.println("level 5 failed! [2]");

			reset(1);
		}

	}

	public void level4() {
		// Overlapping circles
		if (myShapes.circleObjects.get(0).circleBounds.overlaps(myShapes.circleObjects.get(2).circleBounds)
				&& Shapes.currentShapes == 3) {
			reset(1);
		} else if (myShapes.circleObjects.get(1).circleBounds.overlaps(myShapes.circleObjects.get(3).circleBounds)
				&& Shapes.currentShapes == 4) {
			reset(1);
		} else if ((myShapes.circleObjects.get(4).circleBounds.overlaps(myShapes.circleObjects.get(0).circleBounds)
				|| myShapes.circleObjects.get(4).circleBounds.overlaps(myShapes.circleObjects.get(1).circleBounds)
				|| myShapes.circleObjects.get(4).circleBounds.overlaps(myShapes.circleObjects.get(2).circleBounds)
				|| myShapes.circleObjects.get(4).circleBounds.overlaps(myShapes.circleObjects.get(3).circleBounds))
				&& Shapes.currentShapes == 5) {
			reset(1);
		}

		// Overlapping Screens
		if (myShapes.circleObjects.get(0).radius > 270 && Shapes.currentShapes == 1) {
			System.out.println("level 4 failed [4]");
			reset(2);
		} else if (myShapes.circleObjects.get(1).radius > 270 && Shapes.currentShapes == 2) {
			System.out.println("level 4 failed [5]");
			reset(2);
			;
		} else if (myShapes.circleObjects.get(2).radius > 270 && Shapes.currentShapes == 3) {
			System.out.println("level 4 failed [6]");
			reset(2);
		} else if (myShapes.circleObjects.get(3).radius > 260 && Shapes.currentShapes == 4) {
			System.out.println("level 4 failed [7]");
			reset(2);
		}

	}

	public void level3() {
		// Bottom left of triangle
		if (myShapes.circleObjects.get(1).circleBounds.contains(myShapes.triangleObjects.get(2).verticesPoly[4],
				myShapes.triangleObjects.get(2).verticesPoly[5]) == false && myShapes.getCurrentShapes() == 3) {
			reset(1);
		}

		if (myShapes.circleObjects.get(1).circleBounds.contains(myShapes.triangleObjects.get(2).verticesPoly[0],
				myShapes.triangleObjects.get(2).verticesPoly[1]) == false && myShapes.getCurrentShapes() == 3) {
			reset(1);
		}

		// Rectangle Bounds touch screen
		else if (myShapes.squareObjects.get(0).rectBounds.x < 1) {
			reset(2);
		} else if (myShapes.squareObjects.get(0).rectBounds.contains(
				myShapes.circleObjects.get(1).circleBounds.radius + GameWorld.gameWidth / 2,
				myShapes.circleObjects.get(1).circleBounds.radius + GameWorld.gameHeight / 2) == false
				&& Shapes.currentShapes == 2) {
			reset(1);
		}

	}

	public void level2() {
		if (myShapes.squareObjects.get(0).rectX < 0) {
			reset(2);
		}
	}

	public void level1() {

		if (Shapes.polyShapes[1].getTransformedVertices().length != 0) {

			if (Shapes.polyShapes[1].getVertices()[8] < 0) {
				reset(2);
				System.out.println("Level 1 failed Left screen hit");
			}
			if (Shapes.polyShapes[1].getVertices()[2] > GameWorld.gameWidth) {
				reset(2);
				System.out.println("Level 1 failed right screen hit");
			}
		}
	}

	@Override
	public void reset(int lossMessage) {
		if (lossMessage == 1) {
			CheckWin.gameOverMessage = "Shapes Touched!";
		} else if (lossMessage == 2) {
			CheckWin.gameOverMessage = "Screen Touched!";
		}
		myShapes.setClickCounter(0);
		myShapes.setAlive(false);
		counter = 0;

		// System.out.println("CHECK WIN RESET");
	}

}
