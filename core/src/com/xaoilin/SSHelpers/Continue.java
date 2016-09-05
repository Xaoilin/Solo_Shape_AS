package com.xaoilin.SSHelpers;

import com.badlogic.gdx.math.Polygon;
import com.sun.javafx.geom.Shape;
import com.xaoilin.GameObjects.Shapes;
import com.xaoilin.GameWorld.GameWorld;
import com.xaoilin.GameWorld.Helper;
import com.xaoilin.Levels.LevelDrawing;
import com.xaoilin.Levels.TierOneCheckWin;

public class Continue {
    GameWorld myWorld;
    Helper helper;
    Shapes myShapes;

    public static int continueMenuCounter = 0;
    static int continueAnimationCounter = 0;
    double originalShapeColor = 0;
    static int onceColor = 0;

    public Continue(GameWorld myWorld, Helper helper, LevelDrawing myLevelDrawing, Shapes myShapes) {
        this.myWorld = myWorld;
        this.helper = helper;
        this.myShapes = myShapes;
    }

    public void drawPurchaseMenu() {
        drawEssentials();

        //Draw Menu
        helper.drawTexture(GameWorld.gameWidth * 0.0925, GameWorld.gameHeight * 0.260416, 1.5, AssetLoader.purchaseMenu);
        helper.drawText("Purchase Coins!", GameWorld.gameWidth * 0.2037, GameWorld.gameHeight * 0.3225, 5);
        helper.drawText("BUY", GameWorld.gameWidth * 0.18, GameWorld.gameHeight * 0.43, 5);
        helper.drawText("BUY", GameWorld.gameWidth * 0.18, GameWorld.gameHeight * 0.53, 5);
        helper.drawText("BUY", GameWorld.gameWidth * 0.18, GameWorld.gameHeight * 0.63, 5);
        helper.drawTexture(GameWorld.gameWidth * 0.29, GameWorld.gameHeight * 0.38, 1, AssetLoader.starCoin);
        helper.drawTexture(GameWorld.gameWidth * 0.29, GameWorld.gameHeight * 0.48, 1, AssetLoader.starCoin);
        helper.drawTexture(GameWorld.gameWidth * 0.29, GameWorld.gameHeight * 0.58, 1, AssetLoader.starCoin);
        helper.drawText("200", GameWorld.gameWidth * 0.44, GameWorld.gameHeight * 0.43, 5);
        helper.drawText("1000", GameWorld.gameWidth * 0.44, GameWorld.gameHeight * 0.53, 5);
        helper.drawText("2000", GameWorld.gameWidth * 0.44, GameWorld.gameHeight * 0.63, 5);
    }

    public void drawEssentials() {
        helper.drawScore();
        LevelDrawing.drawAllLevels();
    }

    public void drawContinueMenu() {
        drawEssentials();

        // If Not enough points then don't draw the continue menu
        if (TierOneCheckWin.gameOverMessage.startsWith("Not")) {
            myWorld.setGameOver();
            return;
        }
        //Make the shape you failed on flash red
        flashRed();
        //Draw the continue menu
        drawContinue();
    }

    public void drawContinue() {
        if (continueMenuCounter > 150) {
            helper.drawTexture(GameWorld.gameWidth * 0.0925, GameWorld.gameHeight * 0.260416, 1.5, AssetLoader.continueBackground);
            helper.drawText("Shapes touched!", GameWorld.gameWidth * 0.2037, GameWorld.gameHeight * 0.3125, 5);
            helper.drawText("Continue?", GameWorld.gameWidth * 0.23148, GameWorld.gameHeight * 0.416, 0);
            helper.drawTexture(GameWorld.gameWidth * 0.37, GameWorld.gameHeight * 0.4427083, 1, AssetLoader.starCoin);
            helper.drawText("" + Memory.getCoins(), GameWorld.gameWidth * 0.50925, GameWorld.gameHeight * 0.489583, 5);
        }
    }


    public void drawContinueAnimation() {
        // Draw Essentials
        helper.drawScore();
        LevelDrawing.drawAllLevels();

        continueAnimationCounter++;

        setScore();
        drawCountDown();
        resetShape();
    }

    void setOriginColor(double col) {
        if (onceColor == 0) {
            originalShapeColor = col;
            onceColor++;
        }

    }

    // Makes the label blink different colours
    private void flashRed() {
        continueMenuCounter++;
//		System.out.println("Triangle: " + Helper.grow[3].area());

        // Set the color of failed shape to red
        // Find out if it's a polygon or a circle
        if (continueMenuCounter % 20 == 0 && continueMenuCounter < 200) {
            if (Shapes.polyShapes[Shapes.currentShapes].area() != 0) {
//				 System.out.println("Area is greater than 0, setting colour to Red");
                // Find which polygon is this current shape
                switch (Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices().length) {
                    case 6: // triangle
                        myShapes.triangleObjects.get(Shapes.currentShapes - 1).color = 2;
                        break;
                    case 8: // square
                        myShapes.squareObjects.get(Shapes.currentShapes - 1).color = 2;
                        break;
                    case 10: // pentagon
                        myShapes.pentagonObjects.get(Shapes.currentShapes - 1).color = 2;
                        break;
                    case 16: // four star
                        myShapes.fourStarObjects.get(Shapes.currentShapes - 1).color = 2;
                        break;
                    case 20: // five star
                        myShapes.fiveStarObjects.get(Shapes.currentShapes - 1).color = 2;
                        break;
                    case 168: // snow flake
                        myShapes.snowflakeObjects.get(Shapes.currentShapes - 1).color = 2;
                        break;
                }
            } else if (myShapes.circleObjects.get(Shapes.currentShapes - 1).radius > 0) {
                // System.out.println("Radius is greater than 0, setting colour
                // to Red");
                myShapes.circleObjects.get(Shapes.currentShapes - 1).color = 2;
            }
        } else if (continueMenuCounter % 20 == 10 && continueMenuCounter < 100) {
            if (Shapes.polyShapes[Shapes.currentShapes].area() != 0) {
//				 System.out.println("Area is greater than 0, setting colour to Original");
                // Find which polygon is this current shape
                switch (Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices().length) {
                    case 6: // triangle
                        setOriginColor(myShapes.triangleObjects.get(Shapes.currentShapes - 1).color);
                        myShapes.triangleObjects.get(Shapes.currentShapes - 1).color = originalShapeColor;
                        break;
                    case 8: // square
                        setOriginColor(myShapes.squareObjects.get(Shapes.currentShapes - 1).color);
                        myShapes.squareObjects.get(Shapes.currentShapes - 1).color = (float) originalShapeColor;
                        break;
                    case 10: // pentagon
                        setOriginColor(myShapes.pentagonObjects.get(Shapes.currentShapes - 1).color);
                        myShapes.pentagonObjects.get(Shapes.currentShapes - 1).color = originalShapeColor;
                        break;
                    case 16: //four star
                        setOriginColor(myShapes.fourStarObjects.get(Shapes.currentShapes -1).color);
                        myShapes.fourStarObjects.get(Shapes.currentShapes -1).color = originalShapeColor;
                        break;
                    case 20: // five star
                        setOriginColor(myShapes.fiveStarObjects.get(Shapes.currentShapes - 1).color);
                        myShapes.fiveStarObjects.get(Shapes.currentShapes - 1).color = originalShapeColor;
                        break;
                    case 168: // snow flake
                        setOriginColor(myShapes.snowflakeObjects.get(Shapes.currentShapes - 1).color);
                        myShapes.snowflakeObjects.get(Shapes.currentShapes - 1).color = originalShapeColor;
                        break;
                }
            } else if (myShapes.circleObjects.get(Shapes.currentShapes - 1).radius > 0) {
                // System.out.println("Radius is greater than 0, setting colour
                // to Original");
                setOriginColor(myShapes.circleObjects.get(Shapes.currentShapes - 1).color);
                myShapes.circleObjects.get(Shapes.currentShapes - 1).color = originalShapeColor;
            }
        }

    }


    void setScore() {
        // Set score to previous shape
        if (continueAnimationCounter == 1 && Shapes.currentShapes == 1) {
            GameWorld.score = 0;
        } else if (continueAnimationCounter == 1 && Shapes.currentShapes > 1) {
            GameWorld.score = GameWorld.scoreArray.get(GameWorld.scoreArray.size() - 1);
        }
    }

    void drawCountDown() {
        double width = GameWorld.gameWidth * 0.4629;
        // Draw count down
        helper.drawTexture(GameWorld.gameWidth * 0.407, GameWorld.gameHeight * 0.453125, 1, AssetLoader.clock);
        if (continueAnimationCounter < 50) {
            helper.drawText("3", width, GameWorld.gameHeight / 2, 0);
        } else if (continueAnimationCounter < 100) {
            helper.drawText("2", width, GameWorld.gameHeight / 2, 0);
        } else if (continueAnimationCounter < 150) {
            helper.drawText("1", width, GameWorld.gameHeight / 2, 0);
        }
    }

    void resetShape() {
        // Reset Shapes
        if (continueAnimationCounter > 150) {
            // If it is a polygon
            if (Shapes.polyShapes[Shapes.currentShapes].area() != 0) {
                float[] temp = null;
                // Reset variables
                switch (Shapes.polyShapes[Shapes.currentShapes].getTransformedVertices().length) {
                    case 6: // triangle
                        myShapes.triangleObjects.get(Shapes.currentShapes - 1).resetVariables();
                        temp = myShapes.triangleObjects.get(Shapes.currentShapes - 1).verticesPoly;
                        break;
                    case 8: // square
                        myShapes.squareObjects.get(Shapes.currentShapes - 1).resetVariables();
                        temp = myShapes.squareObjects.get(Shapes.currentShapes - 1).verticesPoly;
                        break;
                    case 10: // pentagon
                        myShapes.pentagonObjects.get(Shapes.currentShapes - 1).resetVariables();
                        temp = myShapes.pentagonObjects.get(Shapes.currentShapes - 1).verticesPoly;
                        break;
                    case 16: // four star
                        myShapes.fourStarObjects.get(Shapes.currentShapes - 1).resetVariables();
                        temp = myShapes.fourStarObjects.get(Shapes.currentShapes -1).verticesPoly;
                        break;
                    case 20: // five star
                        myShapes.fiveStarObjects.get(Shapes.currentShapes - 1).resetVariables();
                        temp = myShapes.fiveStarObjects.get(Shapes.currentShapes - 1).verticesPoly;
                        break;
                    case 168: // snow flake
                        myShapes.snowflakeObjects.get(Shapes.currentShapes - 1).resetVariables();
                        temp = myShapes.snowflakeObjects.get(Shapes.currentShapes - 1).verticesPoly;
                        break;
                }
                //reset polygon to 0
                Shapes.polyShapes[Shapes.currentShapes] = new Polygon();
                Shapes.polyShapes[Shapes.currentShapes].setVertices(temp);

                //Continue

                // Continue level
                Shapes.clickCounter = Shapes.currentShapes;
                Shapes.isAlive = true;
                myWorld.setRunning();
            }


            // If it is a circle
            else if (myShapes.circleObjects.get(Shapes.currentShapes - 1).radius > 0) {
                myShapes.circleObjects.get(Shapes.currentShapes - 1).resetVariables();
                if (myShapes.circleObjects.get(Shapes.currentShapes - 1).radius == 0) {
                    // Continue level
                    Shapes.clickCounter = Shapes.currentShapes;
                    Shapes.isAlive = true;
                    myWorld.setRunning();
                }
            }


        }
    }


    public static void resetContinue() {
        onceColor = 0;
        continueAnimationCounter = 0;
        continueMenuCounter = 0;
    }

}
